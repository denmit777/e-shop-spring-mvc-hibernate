package homework24.dao;

import homework24.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAll();

    User getByLogin(String login);

    void add(User user);

    void update(User user);

    void delete(User user);
}
