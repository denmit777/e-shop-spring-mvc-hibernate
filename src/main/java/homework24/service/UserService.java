package homework24.service;

import homework24.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void add(User user);

    User getByLogin(String login);
}
