package ca.pragmaticdev.ws.data.mapper;


import ca.pragmaticdev.ws.Fakes;
import ca.pragmaticdev.ws.data.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = {"test-mapper-configuration.xml"})
public class UserMapperTests {

    protected static Logger logger = Logger.getLogger(UserMapperTests.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Fakes fakes;

    @Test
    @Transactional
    public void SelectAllTest() {

        User fake = fakes.createFakeUser();
        userMapper.Insert(fake);
        List<User> userList = userMapper.SelectAll();

        assertTrue(userList.size() == 1);
        User user = userList.get(0);
        assertTrue(user.getUsername().matches(fake.getUsername()));
        assertTrue(user.getPassword().matches(fake.getPassword()));
        assertTrue(user.getActive() == fake.getActive());

    }

    @Test
    @Transactional
    public void SelectByIdTest() {

        User fake = fakes.createFakeUser();
        userMapper.Insert(fake);

        int userId = userMapper.SelectCurrentId();
        User user = userMapper.SelectById(userId);

        assertTrue(user != null);
        assertTrue(user.getUsername().matches(fake.getUsername()));
        assertTrue(user.getPassword().matches(fake.getPassword()));
        assertTrue(user.getActive() == fake.getActive());
    }

    @Test
    @Transactional
    public void RemoveTest() {

        User fake = fakes.createFakeUser();
        userMapper.Insert(fake);
        int userId = userMapper.SelectCurrentId();
        userMapper.Remove(userId);

        //Remove does a soft delete so there should be no results

        User user = userMapper.SelectById(userId);

        assertTrue(user == null);
    }

    @Test
    @Transactional
    public void UpdateTest() {

        //Insert user object and select user to get id.
        User fake = fakes.createFakeUser();
        userMapper.Insert(fake);

        //Set a new username and id from the returnedUser because it auto increments.
        fake.setUsername("newuser");
        int userId = userMapper.SelectCurrentId();
        fake.setUserId(userId);
        userMapper.Update(fake);

        //Select by id and

        User user = userMapper.SelectById(userId);

        assertTrue(user != null);
        assertTrue(user.getUsername().contains(fake.getUsername()));
    }

    @Test
    @Transactional
    public void DeleteTest() {

        User fake = fakes.createFakeUser();
        userMapper.Insert(fake);
        userMapper.Delete(fake.getUserId());

        User user = userMapper.SelectById(fake.getUserId());
        assertTrue(user == null);
    }

}
