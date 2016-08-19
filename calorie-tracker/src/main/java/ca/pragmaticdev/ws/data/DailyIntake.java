package ca.pragmaticdev.ws.data;

public interface DailyIntake {

    int getUid();

    int getDailyIntakeId();
    void setDailyIntakeId(int dailyIntakeId);

    long getUserId();
    void setUserId(long userId);

    String getDate();
    void setDate(String date);

    int getTotalCalories();
    void setTotalCalories(int calories);

    int getCalorieLimit();
    void setCalorieLimit(int calorieLimit);

    int getCalorieDiff();
    void setCalorieDiff(int calorieDiff);

    int getActive();
    void setActive(int active);

}
