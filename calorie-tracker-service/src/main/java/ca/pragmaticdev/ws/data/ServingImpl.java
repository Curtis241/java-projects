package ca.pragmaticdev.ws.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

public class ServingImpl implements Serving {


    @JsonIgnore
    private int servingId;

    @JsonProperty("date")
    @NotBlank
    private String date;

    @JsonIgnore
    private int active = 1;

    @JsonIgnore
    private int dailyIntakeId;

    @JsonProperty("meal")
    @NotBlank
    private String meal;

    @JsonProperty("description")
    @NotBlank
    private String description;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("calories")
    private int calories;


    @Override
    public int getServingId() {
        return this.servingId;
    }

    @Override
    public void setServingId(int servingId) {
        this.servingId = servingId;
    }

    @Override
    public String getDate() {
        return this.date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
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
    public String getMeal() {
        return this.meal;
    }

    @Override
    public void setMeal(String meal) {
        this.meal = meal;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getUnit() {
        return this.unit;
    }

    @Override
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public int getCalories() {
        return this.calories;
    }

    @Override
    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public int getActive() {
        return this.active;
    }

    @Override
    public void setActive(int active) {
        this.active = active;
    }
}
