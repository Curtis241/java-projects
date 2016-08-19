package ca.pragmaticdev.ws.data.mapper;

import ca.pragmaticdev.ws.Fakes;
import ca.pragmaticdev.ws.data.DailyIntake;
import ca.pragmaticdev.ws.data.DailyIntakeImpl;
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
public class DailyIntakeMapperTests {

    protected static Logger logger = Logger.getLogger(DailyIntakeMapperTests.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DailyIntakeMapper dailyIntakeMapper;

    @Autowired
    private Fakes fakes;

    private DailyIntake fake;

    @Before
    public void Setup() {

        User userFake = fakes.createFakeUser();
        userMapper.Insert(userFake);
        int userId = userMapper.SelectByName(userFake.getUsername()).getUserId();

        fake = fakes.createFakeDailyIntake();
        fake.setUserId(userId);
    }

    @After
    public void Teardown() {

        userMapper.Delete(fake.getUserId());
    }

    @Test
    @Transactional
    public void SelectAllTest() {

        dailyIntakeMapper.Insert(fake);
        List<DailyIntake> dailyIntakeList = dailyIntakeMapper.SelectAll();

        assertTrue(dailyIntakeList.size() == 1);
        DailyIntake dailyIntake = dailyIntakeList.get(0);
        assertTrue(dailyIntake.getDate().contains(fake.getDate()));
        assertTrue(dailyIntake.getActive() == fake.getActive());
        assertTrue(dailyIntake.getCalorieDiff() == fake.getCalorieDiff());
        assertTrue(dailyIntake.getCalorieLimit() == fake.getCalorieLimit());
        assertTrue(dailyIntake.getTotalCalories() == fake.getTotalCalories());
        assertTrue(dailyIntake.getUserId() == fake.getUserId());
    }

    @Test
    @Transactional
    public void SelectByIdTest() {

        dailyIntakeMapper.Insert(fake);
        int dailyIntakeId = dailyIntakeMapper.SelectCurrentId();
        List<DailyIntake> dailyIntakeList = dailyIntakeMapper.SelectById(dailyIntakeId);

        assertTrue(dailyIntakeList.size() == 1);
        DailyIntake dailyIntake = dailyIntakeList.get(0);
        assertTrue(dailyIntake.getDate().contains(fake.getDate()));
        assertTrue(dailyIntake.getActive() == fake.getActive());
        assertTrue(dailyIntake.getCalorieDiff() == fake.getCalorieDiff());
        assertTrue(dailyIntake.getCalorieLimit() == fake.getCalorieLimit());
        assertTrue(dailyIntake.getTotalCalories() == fake.getTotalCalories());
        assertTrue(dailyIntake.getUserId() == fake.getUserId());

    }

    @Test
    @Transactional
    public void SelectByUserIdTest() {

        dailyIntakeMapper.Insert(fake);
        List<DailyIntake> dailyIntakeList = dailyIntakeMapper.SelectByUserId(fake.getUserId());

        assertTrue(dailyIntakeList.size() == 1);
        DailyIntake dailyIntake = dailyIntakeList.get(0);
        assertTrue(dailyIntake.getDate().contains(fake.getDate()));
        assertTrue(dailyIntake.getActive() == fake.getActive());
        assertTrue(dailyIntake.getCalorieDiff() == fake.getCalorieDiff());
        assertTrue(dailyIntake.getCalorieLimit() == fake.getCalorieLimit());
        assertTrue(dailyIntake.getTotalCalories() == fake.getTotalCalories());
        assertTrue(dailyIntake.getUserId() == fake.getUserId());

    }

    @Test
    @Transactional
    public void RemoveTest() {

        dailyIntakeMapper.Insert(fake);
        dailyIntakeMapper.Remove(fake.getDailyIntakeId());

        //Remove method does a soft delete so there should be no results.
        List<DailyIntake> dailyIntakeList = dailyIntakeMapper.SelectById(fake.getDailyIntakeId());

        assertTrue(dailyIntakeList.size() == 0);
    }

    @Test
    @Transactional
    public void UpdateTest() {

        //Insert the dailyIntake row.
        dailyIntakeMapper.Insert(fake);
        int dailyIntakeId = dailyIntakeMapper.SelectCurrentId();
        fake.setDailyIntakeId(dailyIntakeId);

        //Change the date
        fake.setDate("2016-02-03");
        dailyIntakeMapper.Update(fake);

        List<DailyIntake> dailyIntakeList = dailyIntakeMapper.SelectById(fake.getDailyIntakeId());

        assertTrue(dailyIntakeList.size() == 1);
        assertTrue(dailyIntakeList.get(0).getDate().matches("2016-02-03"));
    }

    @Test
    @Transactional
    public void DeleteTest() {

        //Insert the dailyIntake row.
        dailyIntakeMapper.Insert(fake);
        dailyIntakeMapper.Delete(fake.getDailyIntakeId());

        List<DailyIntake> dailyIntakeList = dailyIntakeMapper.SelectById(fake.getDailyIntakeId());

        assertTrue(dailyIntakeList.size() == 0);
    }


}
