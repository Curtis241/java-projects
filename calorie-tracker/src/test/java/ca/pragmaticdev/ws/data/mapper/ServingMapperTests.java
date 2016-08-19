package ca.pragmaticdev.ws.data.mapper;


import ca.pragmaticdev.ws.data.ServingImpl;
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
public class ServingMapperTests {

    protected static Logger logger = Logger.getLogger(ServingMapperTests.class);

    @Autowired
    private ServingMapper servingMapper;

    @Test
    @Transactional
    public void SelectAllTest() {

        ServingImpl fake = createServingFake();
        servingMapper.Insert(fake);
        List<ServingImpl> servingList = servingMapper.SelectAll();

        assertTrue(servingList.size() == 1);
        ServingImpl serving = servingList.get(0);
        assertTrue(serving.getDate().matches(fake.getDate()));
        assertTrue(serving.getDescription().matches(fake.getDescription()));
        assertTrue(serving.getMeal().matches(fake.getMeal()));
        assertTrue(serving.getUnit().matches(fake.getUnit()));
        assertTrue(serving.getCalories() == fake.getCalories());
        assertTrue(serving.getServingId() == fake.getServingId());
        assertTrue(serving.getDailyIntakeId() == fake.getDailyIntakeId());
        assertTrue(serving.getQuantity() == fake.getQuantity());
        assertTrue(serving.getActive() == fake.getActive());

    }

    @Test
    @Transactional
    public void SelectByIdTest() {

        ServingImpl fake = createServingFake();
        servingMapper.Insert(fake);
        List<ServingImpl> servingList = servingMapper.SelectByDailyIntakeId(fake.getDailyIntakeId());

        assertTrue(servingList.size() == 1);
        ServingImpl serving = servingList.get(0);
        assertTrue(serving.getDate().matches(fake.getDate()));
        assertTrue(serving.getDescription().matches(fake.getDescription()));
        assertTrue(serving.getMeal().matches(fake.getMeal()));
        assertTrue(serving.getUnit().matches(fake.getUnit()));
        assertTrue(serving.getCalories() == fake.getCalories());
        assertTrue(serving.getServingId() == fake.getServingId());
        assertTrue(serving.getDailyIntakeId() == fake.getDailyIntakeId());
        assertTrue(serving.getQuantity() == fake.getQuantity());
        assertTrue(serving.getActive() == fake.getActive());
    }

    @Test
    @Transactional
    public void RemoveTest() {

        ServingImpl fake = createServingFake();
        servingMapper.Insert(fake);
        servingMapper.Remove(fake.getDailyIntakeId());

        //Remove does a soft delete so there should be no results.
        List<ServingImpl> servingList = servingMapper.SelectByDailyIntakeId(fake.getDailyIntakeId());

        assertTrue(servingList.size() == 0);
    }

    @Test
    @Transactional
    public void UpdateTest() {

        ServingImpl fake = createServingFake();
        servingMapper.Insert(fake);
        fake.setDate("2016-02-05");
        servingMapper.Update(fake);

        List<ServingImpl> servingList = servingMapper.SelectByDailyIntakeId(fake.getDailyIntakeId());

        assertTrue(servingList.size() == 1);
        ServingImpl serving = servingList.get(0);
        assertTrue(serving.getDate().contains(fake.getDate()));
    }

    @Test
    @Transactional
    public void DeleteTest() {

        ServingImpl fake = createServingFake();
        servingMapper.Insert(fake);
        servingMapper.Delete(fake.getDailyIntakeId());

        List<ServingImpl> servingList = servingMapper.SelectByDailyIntakeId(fake.getDailyIntakeId());
        assertTrue(servingList.size() == 0);
    }

    public ServingImpl createServingFake() {
        ServingImpl serving = new ServingImpl();
        serving.setServingId(1);
        serving.setDailyIntakeId(1);
        serving.setDate("2016-01-27");
        serving.setDescription("Muffin");
        serving.setMeal("Breakfast");
        serving.setQuantity(1);
        serving.setUnit("");
        serving.setCalories(250);
        serving.setActive(1);
        return serving;
    }
}

