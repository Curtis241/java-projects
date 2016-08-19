package ca.pragmaticdev.ws.data;

public interface Serving {

    int getServingId();
    void setServingId(int servingId);

    int getDailyIntakeId();
    void setDailyIntakeId(int dailyIntakeId);

    String getDate();
    void setDate(String date);

    String getMeal();
    void setMeal(String meal);

    String getDescription();
    void setDescription(String description);

    int getQuantity();
    void setQuantity(int quantity);

    String getUnit();
    void setUnit(String unit);

    int getCalories();
    void setCalories(int calories);

    int getActive();
    void setActive(int active);
}
