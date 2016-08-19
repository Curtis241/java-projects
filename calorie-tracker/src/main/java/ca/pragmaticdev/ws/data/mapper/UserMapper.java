package ca.pragmaticdev.ws.data.mapper;

import ca.pragmaticdev.ws.data.UserImpl;

import java.util.List;

public interface UserMapper {

    List<UserImpl> SelectAll();

    UserImpl SelectById(long userId);

    UserImpl SelectByName(String username);

    void Delete(long userId);

    void Insert(UserImpl user);

    void Remove(long userId);

    void Update(UserImpl user);

    int SelectNextId();
}
