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

import static org.junit.Assert.assertTrue;

/**
 * Created by cpeterson on 19/03/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = {"test-mapper-configuration.xml"})
public class AuthenticationMapperTests {

    protected static Logger logger = Logger.getLogger(AuthenticationMapperTests.class);

    @Autowired
    private AuthenticationMapper authenticationMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Fakes fakes;

    @Test
    @Transactional
    public void SelectByNameTest() {

        User fake = fakes.createFakeUser();
        userMapper.Insert(fake);

        User user = userMapper.SelectByName(fake.getUsername());

        assertTrue(user != null);
        assertTrue(user.getUsername().matches(fake.getUsername()));
        assertTrue(user.getPassword().matches(fake.getPassword()));
        assertTrue(user.getActive() == fake.getActive());
    }
}
