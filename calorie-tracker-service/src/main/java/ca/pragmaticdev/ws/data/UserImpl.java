package ca.pragmaticdev.ws.data;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserImpl implements User{

    @JsonProperty("id")
    private int userId;

    @JsonProperty("username")
    @NotBlank
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonIgnore
    private int active = 1;

    @JsonDeserialize(as=RegistrationInfoImpl.class)
    private RegistrationInfo registrationInfo;

    @JsonDeserialize(contentAs=DailyIntakeImpl.class)
    @JsonProperty("dailyIntakes")
    private List<DailyIntake> dailyIntakeList;

    @Override
    public RegistrationInfo getRegistrationInfo() {
        return this.registrationInfo;
    }

    @Override
    public void setRegistrationInfo(RegistrationInfo registrationInfo) {
        this.registrationInfo = registrationInfo;
    }

    @Override
    public List<DailyIntake> getDailyIntakeList() {
        return this.dailyIntakeList;
    }

    @Override
    public void setDailyIntakeList(List<DailyIntake> dailyIntakeList) {
        this.dailyIntakeList = dailyIntakeList;
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
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
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
