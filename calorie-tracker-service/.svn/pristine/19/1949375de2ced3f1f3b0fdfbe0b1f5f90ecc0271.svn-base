package ca.pragmaticdev.ws.data.mapper;

import ca.pragmaticdev.ws.data.DailyIntakeImpl;
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
public class DailyIntakeMapperTests {

    protected static Logger logger = Logger.getLogger(DailyIntakeMapperTests.class);

    @Autowired
    private DailyIntakeMapper dailyIntakeMapper;

    @Test
    @Transactional
    public void SelectAllTest() {

        DailyIntakeImpl fake = createDailyIntakeFake();
        dailyIntakeMapper.Insert(fake);
        List<DailyIntakeImpl> dailyIntakeList = dailyIntakeMapper.SelectAll();

        assertTrue(dailyIntakeList.size() == 1);
        DailyIntakeImpl dailyIntake = dailyIntakeList.get(0);
        assertTrue(dailyIntake.getDate().contains(fake.getDate()));
        assertTrue(dailyIntake.getActive() == fake.getActive());
        assertTrue(dailyIntake.getDailyIntakeId() == fake.getDailyIntakeId());
        assertTrue(dailyIntake.getCalorieDiff() == fake.getCalorieDiff());
        assertTrue(dailyIntake.getCalorieLimit() == fake.getCalorieLimit());
        assertTrue(dailyIntake.getTotalCalories() == fake.getTotalCalories());
        assertTrue(dailyIntake.getUserId() == fake.getUserId());
    }

    @Test
    @Transactional
    public void SelectByIdTest() {

        DailyIntakeImpl fake = createDailyIntakeFake();
        dailyIntakeMapper.Insert(fake);
        List<DailyIntakeImpl> dailyIntakeList = dailyIntakeMapper.SelectById(fake.getDailyIntakeId());

        assertTrue(dailyIntakeList.size() == 1);
        DailyIntakeImpl dailyIntake = dailyIntakeList.get(0);
        assertTrue(dailyIntake.getDate().contains(fake.getDate()));
        assertTrue(dailyIntake.getActive() == fake.getActive());
        assertTrue(dailyIntake.getDailyIntakeId() == fake.getDailyIntakeId());
        assertTrue(dailyIntake.getCalorieDiff() == fake.getCalorieDiff());
        assertTrue(dailyIntake.getCalorieLimit() == fake.getCalorieLimit());
        assertTrue(dailyIntake.getTotalCalories() == fake.getTotalCalories());
        assertTrue(dailyIntake.getUserId() == fake.getUserId());

    }

    @Test
    @Transactional
    public void SelectByUserIdTest() {

        DailyIntakeImpl fake = createDailyIntakeFake();
        dailyIntakeMapper.Insert(fake);
        List<DailyIntakeImpl> dailyIntakeList = dailyIntakeMapper.SelectByUserId(fake.getUserId());

        assertTrue(dailyIntakeList.size() == 1);
        DailyIntakeImpl dailyIntake = dailyIntakeList.get(0);
        assertTrue(dailyIntake.getDate().contains(fake.getDate()));
        assertTrue(dailyIntake.getActive() == fake.getActive());
        assertTrue(dailyIntake.getDailyIntakeId() == fake.getDailyIntakeId());
        assertTrue(dailyIntake.getCalorieDiff() == fake.getCalorieDiff());
        assertTrue(dailyIntake.getCalorieLimit() == fake.getCalorieLimit());
        assertTrue(dailyIntake.getTotalCalories() == fake.getTotalCalories());
        assertTrue(dailyIntake.getUserId() == fake.getUserId());

    }

    @Test
    @Transactional
    public void RemoveTest() {

        DailyIntakeImpl fake = createDailyIntakeFake();
        dailyIntakeMapper.Insert(fake);
        dailyIntakeMapper.Remove(fake.getDailyIntakeId());

        //Remove method does a soft delete so there should be no results.
        List<DailyIntakeImpl> dailyIntakeList = dailyIntakeMapper.SelectById(fake.getDailyIntakeId());

        assertTrue(dailyIntakeList.size() == 0);
    }

    @Test
    @Transactional
    public void UpdateTest() {

        //Insert the dailyIntake row.
        DailyIntakeImpl fake = createDailyIntakeFake();
        dailyIntakeMapper.Insert(fake);

        //Change the date
        fake.setDate("2016-02-03");
        dailyIntakeMapper.Update(fake);

        List<DailyIntakeImpl> dailyIntakeList = dailyIntakeMapper.SelectById(fake.getDailyIntakeId());

        assertTrue(dailyIntakeList.size() == 1);
        assertTrue(dailyIntakeList.get(0).getDate().matches("2016-02-03"));
    }

    @Test
    @Transactional
    public void DeleteTest() {

        //Insert the dailyIntake row.
        DailyIntakeImpl fake = createDailyIntakeFake();
        dailyIntakeMapper.Insert(fake);
        dailyIntakeMapper.Delete(fake.getDailyIntakeId());

        List<DailyIntakeImpl> dailyIntakeList = dailyIntakeMapper.SelectById(fake.getDailyIntakeId());

        assertTrue(dailyIntakeList.size() == 0);
    }

    public DailyIntakeImpl createDailyIntakeFake() {
        DailyIntakeImpl dailyIntake = new DailyIntakeImpl();
        dailyIntake.setDailyIntakeId(1);
        dailyIntake.setUserId(1234567891);
        dailyIntake.setDate("2016-01-27");
        dailyIntake.setCalorieDiff(-300);
        dailyIntake.setCalorieLimit(1700);
        dailyIntake.setTotalCalories(2000);
        dailyIntake.setActive(1);
        return dailyIntake;
    }
}
