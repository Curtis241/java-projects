package ca.pragmaticdev.ws.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyIntakeImpl implements DailyIntake {

    private int uid;

    @JsonProperty("id")
    private int dailyIntakeId;

    @JsonProperty("userId")
    private long userId;

    @JsonProperty("date")
    private String date;

    @JsonProperty("totalCalories")
    private int totalCalories;

    @JsonProperty("calorieLimit")
    private int calorieLimit;

    @JsonProperty("calorieDiff")
    private int calorieDiff;

    private int active;

    @JsonProperty("servings")
    private List<ServingImpl> servingList;

    @Override
    public int getUid() {
        return this.uid;
    }

    @Override
    public int getDailyIntakeId() {
        return this.dailyIntakeId;
    }

    @Override
    public void setDailyIntakeId(int dailyIntakeId) {
        this.dailyIntakeId = dailyIntakeId;
    }

    @Override
    public long getUserId() {
        return this.userId;
    }

    @Override
    public void setUserId(long userId) { this.userId = userId; }

    @Override
    public String getDate() {
        return this.date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int getTotalCalories() {
        return this.totalCalories;
    }

    @Override
    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    @Override
    public int getCalorieLimit() {
        return this.calorieLimit;
    }

    @Override
    public void setCalorieLimit(int calorieLimit) {
        this.calorieLimit = calorieLimit;
    }

    @Override
    public int getCalorieDiff() {
        return this.calorieDiff;
    }

    @Override
    public void setCalorieDiff(int calorieDiff) {
        this.calorieDiff = calorieDiff;
    }

    @Override
    public int getActive() {
        return this.active;
    }

    @Override
    public void setActive(int active) {
        this.active = active;
    }

    public List<ServingImpl> getServingList() {
        return servingList;
    }

    public void setServingList(List<ServingImpl> servingList) {
        this.servingList = servingList;
    }
}
