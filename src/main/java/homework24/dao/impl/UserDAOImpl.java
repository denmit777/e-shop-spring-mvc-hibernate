package homework24.dao.impl;

import homework24.dao.UserDAO;
import homework24.model.User;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    private static final String QUERY_SELECT_FROM_USER = "from User";
    private static final String QUERY_SELECT_FROM_USER_BY_LOGIN = "from User u where u.login = :login";

    private final SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAll() {
        return getCurrentSession().createQuery(QUERY_SELECT_FROM_USER).list();
    }

    @Override
    public User getByLogin(String login) {
        final User user = (User) getCurrentSession().createQuery(QUERY_SELECT_FROM_USER_BY_LOGIN)
                .setParameter("login", login).uniqueResult();

        return user;
    }

    @Override
    public void add(User user) {
        getCurrentSession().save(user);
    }

    @Override
    public void update(User user) {
        final User newUser = getByLogin(user.getLogin());

        newUser.setLogin(user.getLogin());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setUserRole(user.getUserRole());

        getCurrentSession().saveOrUpdate(newUser);
    }

    @Override
    public void delete(User user) {
        if (user != null) {
            getCurrentSession().delete(user);
        }
    }

    private User getById(Long id) {
        return getCurrentSession().get(User.class, id);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
