package ca.pragmaticdev.ws;

import ca.pragmaticdev.ws.data.*;

/**
 * Created by cpeterson on 18/02/16.
 */
public class Fakes {

    public User createFakeUser() {
        User user = new UserImpl();
        user.setUserId(1);
        user.setUsername("curtispe");
        user.setPassword("password");
        user.setActive(1);
        return user;
    }

    public Serving createFakeServing() {
        Serving serving = new ServingImpl();
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

    public RegistrationInfo createFakeRegistrationInfo() {
        RegistrationInfo registrationInfo = new RegistrationInfoImpl();
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

    public DailyIntake createFakeDailyIntake() {
        DailyIntake dailyIntake = new DailyIntakeImpl();
        dailyIntake.setDailyIntakeId(1);
        dailyIntake.setUserId(1);
        dailyIntake.setDate("2016-01-27");
        dailyIntake.setCalorieDiff(-300);
        dailyIntake.setCalorieLimit(1700);
        dailyIntake.setTotalCalories(2000);
        dailyIntake.setActive(1);
        return dailyIntake;
    }
}
