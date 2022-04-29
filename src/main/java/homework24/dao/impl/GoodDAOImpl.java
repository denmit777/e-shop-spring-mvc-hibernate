package homework24.dao.impl;

import homework24.dao.GoodDAO;
import homework24.model.Good;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodDAOImpl implements GoodDAO {

    private static final String QUERY_SELECT_FROM_GOOD = "from Good";

    private final SessionFactory sessionFactory;

    public GoodDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Good> getAll() {
        return getCurrentSession().createQuery(QUERY_SELECT_FROM_GOOD).list();
    }

    @Override
    public void add(Good good) {
        getCurrentSession().save(good);
    }

    @Override
    public void update(Good good) {
        final Good newGood = get(good.getId());

        newGood.setName(good.getName());
        newGood.setPrice(good.getPrice());

        getCurrentSession().saveOrUpdate(newGood);
    }

    @Override
    public void delete(Good good) {
        if (good != null) {
            getCurrentSession().delete(good);
        }
    }

    private Good get(Long id) {
        return getCurrentSession().get(Good.class, id);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
