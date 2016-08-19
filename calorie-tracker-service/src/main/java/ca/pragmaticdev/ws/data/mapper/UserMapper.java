package ca.pragmaticdev.ws.data.mapper;

import ca.pragmaticdev.ws.data.User;

import java.util.List;

public interface UserMapper {

    List<User> SelectAll();

    User SelectById(int userId);

    User SelectByName(String username);

    void Delete(int userId);

    void Insert(User user);

    void Remove(int userId);

    void Update(User user);

    int SelectNextId();

    int SelectCurrentId();
}
