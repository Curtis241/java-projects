package ca.pragmaticdev.ws.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;


@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationInfoImpl implements RegistrationInfo {

    @JsonIgnore
    private int registrationId;

    @JsonIgnore
    private int userId;

    @JsonProperty("firstName")
    @NotBlank
    private String firstName;

    @JsonProperty("lastName")
    @NotBlank
    private String lastName;

    @JsonProperty("city")
    @NotBlank
    private String city;

    @JsonIgnore
    private int active = 1;

    @JsonProperty("email")
    @NotBlank
    private String email;

    @JsonProperty("country")
    @NotBlank
    private String country;

    @JsonProperty("state")
    @NotBlank
    private String state;


    @Override
    public int getRegistrationId() {
        return this.registrationId;
    }

    @Override
    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    @Override
    public int getUserId() {
        return this.userId;
    }

    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getCity() {
        return this.city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String getCountry() {
        return this.country;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
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
