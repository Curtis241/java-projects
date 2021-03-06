package ca.pragmaticdev.ws.data;

/**
 * Created by cpeterson on 05/02/16.
 */
public interface RegistrationInfo {

    int getRegistrationId();
    void setRegistrationId(int registrationId);

    int getUserId();
    void setUserId(int userId);

    String getFirstName();
    void setFirstName(String firstName);

    String getLastName();
    void setLastName(String lastName);

    String getCity();
    void setCity(String city);

    String getState();
    void setState(String state);

    String getCountry();
    void setCountry(String country);

    String getEmail();
    void setEmail(String email);

    int getActive();
    void setActive(int active);

}
