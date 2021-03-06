package ca.pragmaticdev.ws.data.mapper;


import ca.pragmaticdev.ws.Fakes;
import ca.pragmaticdev.ws.data.RegistrationInfo;
import ca.pragmaticdev.ws.data.User;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
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
public class RegistrationInfoMapperTests {

    protected static Logger logger = Logger.getLogger(DailyIntakeMapperTests.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RegistrationInfoMapper registrationInfoMapper;

    @Autowired
    private Fakes fakes;

    private RegistrationInfo fake;

    @Before
    public void Setup() {

        User userFake = fakes.createFakeUser();
        userMapper.Insert(userFake);
        int userId = userMapper.SelectByName(userFake.getUsername()).getUserId();

        fake = fakes.createFakeRegistrationInfo();
        fake.setUserId(userId);

    }

    @After
    public void Teardown() {

        userMapper.Delete(fake.getUserId());
    }

    @Test
    @Transactional
    public void SelectAllTest() {


        registrationInfoMapper.Insert(fake);
        List<RegistrationInfo> registrationList = registrationInfoMapper.SelectAll();

        assertTrue(registrationList.size() == 1);
        RegistrationInfo registrationInfo = registrationList.get(0);
        assertTrue(registrationInfo.getUserId() == (fake.getUserId()));
        assertTrue(registrationInfo.getFirstName().matches(fake.getFirstName()));
        assertTrue(registrationInfo.getLastName().matches(fake.getLastName()));
        assertTrue(registrationInfo.getCity().matches(fake.getCity()));
        assertTrue(registrationInfo.getState().matches(fake.getState()));
        assertTrue(registrationInfo.getCountry().matches(fake.getCountry()));
        assertTrue(registrationInfo.getEmail().matches(fake.getEmail()));
        assertTrue(registrationInfo.getActive() == fake.getActive());

    }

    @Test
    @Transactional
    public void SelectByIdTest() {

        registrationInfoMapper.Insert(fake);
        RegistrationInfo registrationInfo = registrationInfoMapper.SelectById(fake.getUserId());

        assertTrue(registrationInfo != null);
        assertTrue(registrationInfo.getUserId() == (fake.getUserId()));
        assertTrue(registrationInfo.getFirstName().matches(fake.getFirstName()));
        assertTrue(registrationInfo.getLastName().matches(fake.getLastName()));
        assertTrue(registrationInfo.getCity().matches(fake.getCity()));
        assertTrue(registrationInfo.getState().matches(fake.getState()));
        assertTrue(registrationInfo.getCountry().matches(fake.getCountry()));
        assertTrue(registrationInfo.getEmail().matches(fake.getEmail()));
        assertTrue(registrationInfo.getActive() == fake.getActive());
    }

    @Test
    @Transactional
    public void RemoveTest() {

        registrationInfoMapper.Insert(fake);
        registrationInfoMapper.Remove(fake.getUserId());

        //Remove does a soft delete so there should be no results.
        RegistrationInfo registrationInfo = registrationInfoMapper.SelectById(fake.getUserId());

        assertTrue(registrationInfo == null);
    }

    @Test
    @Transactional
    public void UpdateTest() {

        registrationInfoMapper.Insert(fake);
        fake.setCity("Vancouver");
        registrationInfoMapper.Update(fake);

        RegistrationInfo registrationInfo = registrationInfoMapper.SelectById(fake.getUserId());

        assertTrue(registrationInfo != null);
        assertTrue(registrationInfo.getCity().contains(fake.getCity()));
    }

    @Test
    @Transactional
    public void DeleteTest() {

        registrationInfoMapper.Insert(fake);
        registrationInfoMapper.Delete(fake.getUserId());

        RegistrationInfo registrationInfo = registrationInfoMapper.SelectById(fake.getUserId());
        assertTrue(registrationInfo == null);
    }


}
