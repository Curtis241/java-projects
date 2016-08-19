package ca.pragmaticdev.ws.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyIntakeImpl implements DailyIntake {

    @JsonIgnore
    private int dailyIntakeId;

    @JsonIgnore
    private int userId;

    @JsonProperty("date")
    @NotBlank
    private String date;

    @JsonProperty("totalCalories")
    private int totalCalories;

    @JsonProperty("calorieLimit")
    private int calorieLimit;

    @JsonProperty("calorieDiff")
    private int calorieDiff;

    @JsonIgnore
    private int active = 1;

    @JsonDeserialize(contentAs=ServingImpl.class)
    @JsonProperty("servings")
    private List<Serving> servingList;


    @Override
    public int getDailyIntakeId() {
        return this.dailyIntakeId;
    }

    @Override
    public void setDailyIntakeId(int dailyIntakeId) {
        this.dailyIntakeId = dailyIntakeId;
    }

    @Override
    public int getUserId() {
        return this.userId;
    }

    @Override
    public void setUserId(int userId) { this.userId = userId; }

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

    @Override
    public List<Serving> getServingList() {
        return servingList;
    }

    @Override
    public void setServingList(List<Serving> servingList) {
        this.servingList = servingList;
    }
}
