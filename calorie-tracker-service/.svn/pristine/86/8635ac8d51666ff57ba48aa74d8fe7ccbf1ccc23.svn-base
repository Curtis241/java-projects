package ca.pragmaticdev.ws.data.mapper;


import ca.pragmaticdev.ws.data.UserImpl;
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

    @Test
    @Transactional
    public void SelectAllTest() {

        UserImpl fake = createUserFake();
        userMapper.Insert(fake);
        List<UserImpl> userList = userMapper.SelectAll();

        assertTrue(userList.size() == 1);
        UserImpl user = userList.get(0);
        assertTrue(user.getUserId() == (fake.getUserId()));
        assertTrue(user.getUsername().matches(fake.getUsername()));
        assertTrue(user.getHash().matches(fake.getHash()));
        assertTrue(user.getActive() == fake.getActive());

    }

    @Test
    @Transactional
    public void SelectByIdTest() {

        UserImpl fake = createUserFake();
        userMapper.Insert(fake);
        UserImpl user = userMapper.SelectById(fake.getUserId());

        assertTrue(user != null);
        assertTrue(user.getUserId() == (fake.getUserId()));
        assertTrue(user.getUsername().matches(fake.getUsername()));
        assertTrue(user.getHash().matches(fake.getHash()));
        assertTrue(user.getActive() == fake.getActive());
    }

    @Test
    @Transactional
    public void RemoveTest() {

        UserImpl fake = createUserFake();
        userMapper.Insert(fake);
        userMapper.Remove(fake.getUserId());

        //Remove does a soft delete so there should be no results
        UserImpl user = userMapper.SelectById(fake.getUserId());

        assertTrue(user == null);
    }

    @Test
    @Transactional
    public void UpdateTest() {

        UserImpl fake = createUserFake();
        userMapper.Insert(fake);
        fake.setUsername("newuser");
        userMapper.Update(fake);

        UserImpl user = userMapper.SelectById(fake.getUserId());

        assertTrue(user != null);
        assertTrue(user.getUsername().contains(fake.getUsername()));
    }

    @Test
    @Transactional
    public void DeleteTest() {

        UserImpl fake = createUserFake();
        userMapper.Insert(fake);
        userMapper.Delete(fake.getUserId());

        UserImpl user = userMapper.SelectById(fake.getUserId());
        assertTrue(user == null);
    }

    public UserImpl createUserFake() {
        UserImpl user = new UserImpl();
        user.setUserId(1);
        user.setUsername("curtispe");
        user.setHash("5da7b6bed3a81f88049a2902a9c3dd99");
        user.setActive(1);
        return user;
    }
}
