package ca.pragmaticdev.ws.service;


import ca.pragmaticdev.ws.data.*;
import ca.pragmaticdev.ws.data.mapper.DailyIntakeMapper;
import ca.pragmaticdev.ws.data.mapper.RegistrationInfoMapper;
import ca.pragmaticdev.ws.data.mapper.ServingMapper;
import ca.pragmaticdev.ws.data.mapper.UserMapper;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    protected static Logger logger = LoggerFactory.getLogger(UserService.class);
    protected int dailyIntakeLimit = 10;

    @Autowired(required = true)
    private DailyIntakeMapper dailyIntakeMapper;

    @Autowired(required = true)
    private ServingMapper servingMapper;

    @Autowired(required = true)
    private RegistrationInfoMapper registrationInfoMapper;

    @Autowired(required = true)
    private UserMapper userMapper;


    public ResponseEntity<List<User>> selectAll() {

        List<User> users = getUsers(getDailyIntakeLimit());

        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    private List<User> getUsers(int limit) {

        List<User> returnedUsers = new ArrayList<User>();
        List<User> users = userMapper.SelectAll();

        for(User user : users) {
            User returnedUser = getUser(user.getUserId(),limit);
            returnedUser.setPassword("Not Visible");
            returnedUsers.add(returnedUser);
        }
        return returnedUsers;
    }

    public ResponseEntity<User> select(int userId) {

        User user = getUser(userId,getDailyIntakeLimit());

        if(user != null){
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    //TODO Implement limit to restrict number of daily intake objects.
    private User getUser(int userId, int dailyIntakeLimit) {

        User user = userMapper.SelectById(userId);
        if(user == null) throw new UserNotFoundException();

        RegistrationInfo registrationInfo = registrationInfoMapper.SelectById(user.getUserId());
        user.setRegistrationInfo(registrationInfo);
        if(registrationInfo == null) throw new RegistrationInfoNotFoundException();

        List<DailyIntake> dailyIntakeList = dailyIntakeMapper.SelectByUserId(user.getUserId());
        //It is expected that the DailyIntake array may not be populated.
        if(dailyIntakeList == null || dailyIntakeList.size() == 0) {
            //Create an empty dailyIntake array instead of removing it.
            user.setDailyIntakeList(new ArrayList<DailyIntake>());
        } else {

            for (DailyIntake dailyIntake : dailyIntakeList) {
                List<Serving> servingList = servingMapper.SelectByDailyIntakeId(dailyIntake.getDailyIntakeId());
                if (servingList == null || servingList.size() == 0) throw new ServingNotFoundException();
                dailyIntake.setServingList(servingList);
            }
            user.setDailyIntakeList(dailyIntakeList);
        }

        return user;
    }

    public ResponseEntity<User> insert(User user) {

        return new ResponseEntity<User>(addUser(user),HttpStatus.CREATED);
    }

    private User addUser(User user) {

        //There must be a user and registrationInfo object before it is inserted, but dailyIntake and servings
        //may be missing if is an initial insert.
        if(user == null) throw new UserNotFoundException();
        int userId = 0;

        RegistrationInfo registrationInfo = user.getRegistrationInfo();
        if(registrationInfo == null) throw new RegistrationInfoNotFoundException();

        //The inserted user should not exist in the database otherwise abort.
        User selectedUser = userMapper.SelectByName(user.getUsername());

        if(selectedUser == null) {

            String encodedPassword = encode(user.getPassword());

            user.setPassword(encodedPassword);
            userMapper.Insert(user);
            //RegistrationInfo.userId is not required in the json object so have to copy it from User.userId.
            userId = userMapper.SelectCurrentId();
            registrationInfo.setUserId(userId);
            registrationInfoMapper.Insert(registrationInfo);

        } else {
            throw new UserAlreadyExistsException();
        }

        return getUser(userId,0);
    }

    public ResponseEntity<User> update(User user) {

        return new ResponseEntity<User>(modifyUser(user),HttpStatus.OK);
    }

    private User modifyUser(User user) {

        if(user == null) throw new UserNotFoundException();
        //Check that userId and username match existing user record.
        User selectedUser = userMapper.SelectById(user.getUserId());

        if(selectedUser != null && selectedUser.getUsername().matches(user.getUsername())) {

            userMapper.Update(user);

            RegistrationInfo registrationInfo = user.getRegistrationInfo();
            if (registrationInfo == null) throw new RegistrationInfoNotFoundException();
            registrationInfoMapper.Update(registrationInfo);

        } else {
            throw new InvalidUserException();
        }

        return getUser(user.getUserId(),getDailyIntakeLimit());
    };

    public ResponseEntity remove(int userId) {

        removeUser(userId);
        return new ResponseEntity(HttpStatus.OK);
    }

    private void removeUser(int userId) {

        User user = userMapper.SelectById(userId);

        if(user != null) {
            userMapper.Remove(userId);
            registrationInfoMapper.Remove(user.getUserId());

            List<DailyIntake> dailyIntakeList = user.getDailyIntakeList();
            if (dailyIntakeList != null && dailyIntakeList.size() > 0) {
                for (DailyIntake dailyIntake : dailyIntakeList) {
                    dailyIntakeMapper.Remove(dailyIntake.getDailyIntakeId());

                    for (Serving serving : dailyIntake.getServingList()) {
                        servingMapper.Remove(serving.getDailyIntakeId());
                    }
                }
            }
        } else {
            throw new UserNotFoundException();
        }
    }

    private User addServing(int userId,Serving serving) {

        //Check that there is a serving object to work with.
        if(serving == null) throw new ServingNotFoundException();
        //Check that there is a user matching provided userId.
        User selectedUser = getUser(userId,getDailyIntakeLimit());
        if(selectedUser != null) {
            //Check that there is a date to work with.
            if(!serving.getDate().isEmpty()) {
                //Make sure we have a dailyIntakeList to work with. This will happen
                //if it is a new user/registrationInfo object.
                if(selectedUser.getDailyIntakeList() != null && selectedUser.getDailyIntakeList().size() != 0) {
                    //Find the daily intake object in the selected user that matches provided date.
                    for(DailyIntake dailyIntake:selectedUser.getDailyIntakeList()){

                        if(dailyIntake.getDate().matches(serving.getDate())) {
                            serving.setDailyIntakeId(dailyIntake.getDailyIntakeId());
                            servingMapper.Insert(serving);
                        }
                    }
                } else {
                    DailyIntake dailyIntake = new DailyIntakeImpl();
                    dailyIntake.setUserId(userId);
                    dailyIntake.setDate(serving.getDate());
                    dailyIntakeMapper.Insert(dailyIntake);

                    int dailyIntakeId = dailyIntakeMapper.SelectCurrentId();
                    serving.setDailyIntakeId(dailyIntakeId);
                    servingMapper.Insert(serving);
                }
            } else {
                throw new InvalidServingException();
            }

        } else {
            throw new UserNotFoundException();
        }

        return getUser(userId,getDailyIntakeLimit());
    }


    public Boolean validate(String encodedAuthorizationHeader) {

        String[] credentials = decodeBase64String(encodedAuthorizationHeader);

        if(credentials.length == 2) {
            User user = userMapper.SelectByName(credentials[0]);

            if(user != null){
                return validatePassword(new Password(credentials[1],false),new Password(user.getPassword(),true));
            }
        }

        return false;
    }

    public String[] decodeBase64String(String encodedAuthorizationHeader) {

        if(encodedAuthorizationHeader.contains("Basic")) {

            String[] base64String = encodedAuthorizationHeader.split(" ");

            if(base64String.length == 2) {
                String decodedAuthorizationHeader = decode(base64String[1]);
                return decodedAuthorizationHeader.split(":");
            }
        }

        return new String[0];
    }

    public Boolean validatePassword(Password provided, Password expected) {


        if (provided != null && expected != null) {

            String providedPassword = provided.password;
            String expectedPassword = expected.password;

            if (provided.encoded) {
                providedPassword = decode(provided.password);
            }

            if (expected.encoded) {
                expectedPassword = decode(expected.password);
            }

            return providedPassword.matches(expectedPassword);
        }

        return false;
    }

    public String encode(String stringToEncode) {
        return Base64.encodeBase64String(stringToEncode.getBytes(Charset.forName("US-ASCII")));
    }

    public String decode(String base64String) {
        return new String(Base64.decodeBase64(base64String.getBytes(Charset.forName("US-ASCII"))));
    }


    public ResponseEntity<User> insertServing(int userId,Serving serving) {

        return new ResponseEntity<User>(addServing(userId,serving),HttpStatus.OK);
    }

    public void setDailyIntakeLimit(int limit) {
        this.dailyIntakeLimit = limit;
    }

    public int getDailyIntakeLimit() {
        return this.dailyIntakeLimit;
    }

    public void setDailyIntakeMapper(DailyIntakeMapper dailyIntakeMapper) {
        this.dailyIntakeMapper = dailyIntakeMapper;
    }

    public void setServingMapper(ServingMapper servingMapper) {
        this.servingMapper = servingMapper;
    }

    public void setRegistrationInfoMapper(RegistrationInfoMapper registrationInfoMapper) {
        this.registrationInfoMapper = registrationInfoMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

}
