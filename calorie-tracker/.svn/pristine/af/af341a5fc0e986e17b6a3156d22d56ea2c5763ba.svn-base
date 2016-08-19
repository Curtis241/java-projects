package ca.pragmaticdev.ws.service;


import ca.pragmaticdev.ws.data.DailyIntakeImpl;
import ca.pragmaticdev.ws.data.RegistrationInfoImpl;
import ca.pragmaticdev.ws.data.ServingImpl;
import ca.pragmaticdev.ws.data.UserImpl;
import ca.pragmaticdev.ws.data.mapper.DailyIntakeMapper;
import ca.pragmaticdev.ws.data.mapper.RegistrationInfoMapper;
import ca.pragmaticdev.ws.data.mapper.ServingMapper;
import ca.pragmaticdev.ws.data.mapper.UserMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Service
public class UserService {

    protected static Logger logger = Logger.getLogger(UserService.class);

    @Autowired(required = true)
    private DailyIntakeMapper dailyIntakeMapper;

    @Autowired(required = true)
    private ServingMapper servingMapper;

    @Autowired(required = true)
    private RegistrationInfoMapper registrationInfoMapper;

    @Autowired(required = true)
    private UserMapper userMapper;


    public Response getUser(String username) {

        UserImpl user = userMapper.SelectByName(username);
        RegistrationInfoImpl registrationInfo = registrationInfoMapper.SelectById(user.getUserId());
        user.setRegistrationInfo(registrationInfo);

        List<DailyIntakeImpl> dailyIntakeList = dailyIntakeMapper.SelectByUserId(user.getUserId());

        for (DailyIntakeImpl dailyIntake : dailyIntakeList) {
            List<ServingImpl> servingList = servingMapper.SelectByDailyIntakeId(dailyIntake.getDailyIntakeId());
            dailyIntake.setServingList(servingList);
        }
        user.setDailyIntakeList(dailyIntakeList);

        return convertListToJson(user);
    }

    private Response convertListToJson(UserImpl user) {

        ObjectMapper mapper = new ObjectMapper();
        String json;
        try {
            json = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            logger.error(e);
            return getServerErrorResponse(e.getStackTrace().toString());
        }

        return getOkResponse(json);
    }

    private Response getServerErrorResponse(String exception) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exception).build();
    }

    //Reference: http://stackoverflow.com/questions/23450494/how-to-enable-cross-domain-requests-on-jax-rs-web-services
    private Response getOkResponse(String json) {
        return Response.
                ok(json, MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .build();
    }
}
