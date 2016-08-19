package ca.pragmaticdev.ws.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserImpl implements User{

    int uid;

    @JsonProperty("id")
    long userId;

    @JsonProperty("username")
    String username;

    @JsonProperty("md5hash")
    String hash;

    int active;

    @JsonProperty("registrationInfo")
    RegistrationInfoImpl registrationInfo;

    @JsonProperty("dailyIntakes")
    List<DailyIntakeImpl> dailyIntakeList;

    public RegistrationInfoImpl getRegistrationInfo() {
        return this.registrationInfo;
    }

    public void setRegistrationInfo(RegistrationInfoImpl registrationInfo) {
        this.registrationInfo = registrationInfo;
    }

    public List<DailyIntakeImpl> getDailyIntakeList() {
        return this.dailyIntakeList;
    }

    public void setDailyIntakeList(List<DailyIntakeImpl> dailyIntakeList) {
        this.dailyIntakeList = dailyIntakeList;
    }

    @Override
    public int getUid() {
        return this.uid;
    }

    @Override
    public long getUserId() {
        return this.userId;
    }

    @Override
    public void setUserId(long userId) {
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
    public String getHash() {
        return this.hash;
    }

    @Override
    public void setHash(String hash) {
        this.hash = hash;
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
