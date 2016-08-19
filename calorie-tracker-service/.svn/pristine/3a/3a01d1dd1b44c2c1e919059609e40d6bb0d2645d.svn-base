package ca.pragmaticdev.ws.data.mapper;


import ca.pragmaticdev.ws.Fakes;
import ca.pragmaticdev.ws.data.DailyIntake;
import ca.pragmaticdev.ws.data.Serving;
import ca.pragmaticdev.ws.data.ServingImpl;
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
public class ServingMapperTests {

    protected static Logger logger = Logger.getLogger(ServingMapperTests.class);

    @Autowired
    private ServingMapper servingMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DailyIntakeMapper dailyIntakeMapper;

    @Autowired
    private Fakes fakes;

    private DailyIntake dailyIntakeFake;
    private Serving fake;

    @Before
    public void Setup() {

        User userFake = fakes.createFakeUser();
        userMapper.Insert(userFake);
        int userId = userMapper.SelectByName(userFake.getUsername()).getUserId();

        dailyIntakeFake = fakes.createFakeDailyIntake();
        dailyIntakeFake.setUserId(userId);
        dailyIntakeMapper.Insert(dailyIntakeFake);
        int dailyIntakeId = dailyIntakeMapper.SelectCurrentId();
        dailyIntakeFake.setDailyIntakeId(dailyIntakeId);

        fake = fakes.createFakeServing();
        fake.setDailyIntakeId(dailyIntakeFake.getDailyIntakeId());
    }

    @After
    public void Teardown() {

        dailyIntakeMapper.Delete(dailyIntakeFake.getDailyIntakeId());
        userMapper.Delete(dailyIntakeFake.getUserId());

    }

    @Test
    @Transactional
    public void SelectAllTest() {

        servingMapper.Insert(fake);
        int servingId = servingMapper.SelectCurrentId();
        List<Serving> servingList = servingMapper.SelectAll();

        assertTrue(servingList.size() == 1);
        Serving serving = servingList.get(0);
        assertTrue(serving.getDate().matches(fake.getDate()));
        assertTrue(serving.getDescription().matches(fake.getDescription()));
        assertTrue(serving.getMeal().matches(fake.getMeal()));
        assertTrue(serving.getUnit().matches(fake.getUnit()));
        assertTrue(serving.getCalories() == fake.getCalories());
        assertTrue(serving.getServingId() == servingId);
        assertTrue(serving.getDailyIntakeId() == fake.getDailyIntakeId());
        assertTrue(serving.getQuantity() == fake.getQuantity());
        assertTrue(serving.getActive() == fake.getActive());

    }

    @Test
    @Transactional
    public void SelectByIdTest() {

        servingMapper.Insert(fake);
        int servingId = servingMapper.SelectCurrentId();
        List<Serving> servingList = servingMapper.SelectByDailyIntakeId(fake.getDailyIntakeId());

        assertTrue(servingList.size() == 1);
        Serving serving = servingList.get(0);
        assertTrue(serving.getDate().matches(fake.getDate()));
        assertTrue(serving.getDescription().matches(fake.getDescription()));
        assertTrue(serving.getMeal().matches(fake.getMeal()));
        assertTrue(serving.getUnit().matches(fake.getUnit()));
        assertTrue(serving.getCalories() == fake.getCalories());
        assertTrue(serving.getServingId() == servingId);
        assertTrue(serving.getDailyIntakeId() == fake.getDailyIntakeId());
        assertTrue(serving.getQuantity() == fake.getQuantity());
        assertTrue(serving.getActive() == fake.getActive());
    }

    @Test
    @Transactional
    public void RemoveTest() {

        servingMapper.Insert(fake);
        servingMapper.Remove(fake.getDailyIntakeId());

        //Remove does a soft delete so there should be no results.
        List<Serving> servingList = servingMapper.SelectByDailyIntakeId(fake.getDailyIntakeId());

        assertTrue(servingList.size() == 0);
    }

    @Test
    @Transactional
    public void UpdateTest() {

        servingMapper.Insert(fake);
        fake.setDate("2016-02-05");
        servingMapper.Update(fake);

        List<Serving> servingList = servingMapper.SelectByDailyIntakeId(fake.getDailyIntakeId());

        assertTrue(servingList.size() == 1);
        Serving serving = servingList.get(0);
        assertTrue(serving.getDate().contains(fake.getDate()));
    }

    @Test
    @Transactional
    public void DeleteTest() {

        servingMapper.Insert(fake);
        servingMapper.Delete(fake.getDailyIntakeId());

        List<Serving> servingList = servingMapper.SelectByDailyIntakeId(fake.getDailyIntakeId());
        assertTrue(servingList.size() == 0);
    }


}

