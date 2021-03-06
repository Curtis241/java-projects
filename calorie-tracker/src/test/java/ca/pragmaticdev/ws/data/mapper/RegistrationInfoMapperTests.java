package ca.pragmaticdev.ws.data.mapper;


import ca.pragmaticdev.ws.data.RegistrationInfoImpl;
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
public class RegistrationInfoMapperTests {

    protected static Logger logger = Logger.getLogger(DailyIntakeMapperTests.class);

    @Autowired
    private RegistrationInfoMapper registrationInfoMapper;

    @Test
    @Transactional
    public void SelectAllTest() {

        RegistrationInfoImpl fake = createRegistrationFake();
        registrationInfoMapper.Insert(fake);
        List<RegistrationInfoImpl> registrationList = registrationInfoMapper.SelectAll();

        assertTrue(registrationList.size() == 1);
        RegistrationInfoImpl registrationInfo = registrationList.get(0);
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

        RegistrationInfoImpl fake = createRegistrationFake();
        registrationInfoMapper.Insert(fake);
        RegistrationInfoImpl registrationInfo = registrationInfoMapper.SelectById(fake.getUserId());

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

        RegistrationInfoImpl fake = createRegistrationFake();
        registrationInfoMapper.Insert(fake);
        registrationInfoMapper.Remove(fake.getUserId());

        //Remove does a soft delete so there should be no results.
        RegistrationInfoImpl registrationInfo = registrationInfoMapper.SelectById(fake.getUserId());

        assertTrue(registrationInfo == null);
    }

    @Test
    @Transactional
    public void UpdateTest() {

        RegistrationInfoImpl fake = createRegistrationFake();
        registrationInfoMapper.Insert(fake);
        fake.setCity("Vancouver");
        registrationInfoMapper.Update(fake);

        RegistrationInfoImpl registrationInfo = registrationInfoMapper.SelectById(fake.getUserId());

        assertTrue(registrationInfo != null);
        assertTrue(registrationInfo.getCity().contains(fake.getCity()));
    }

    @Test
    @Transactional
    public void DeleteTest() {

        RegistrationInfoImpl fake = createRegistrationFake();
        registrationInfoMapper.Insert(fake);
        registrationInfoMapper.Delete(fake.getUserId());

        RegistrationInfoImpl registrationInfo = registrationInfoMapper.SelectById(fake.getUserId());
        assertTrue(registrationInfo == null);
    }

    public RegistrationInfoImpl createRegistrationFake() {
        RegistrationInfoImpl registrationInfo = new RegistrationInfoImpl();
        registrationInfo.setUserId(1);
        registrationInfo.setCity("Saskatoon");
        registrationInfo.setState("Saskatchewan");
        registrationInfo.setCountry("Canada");
        registrationInfo.setFirstName("Curtis");
        registrationInfo.setLastName("Peterson");
        registrationInfo.setEmail("copeterson07@gmail.com");
        registrationInfo.setActive(1);
        return registrationInfo;
    }
}
