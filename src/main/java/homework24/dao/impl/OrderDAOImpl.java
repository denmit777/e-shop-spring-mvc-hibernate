package homework24.dao.impl;

import homework24.dao.OrderDAO;
import homework24.model.Order;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    private static final String QUERY_SELECT_FROM_ORDER = "from Order";

    private final SessionFactory sessionFactory;

    public OrderDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Order> getAll() {
        return getCurrentSession().createQuery(QUERY_SELECT_FROM_ORDER).list();
    }

    @Override
    public void add(Order order) {
        getCurrentSession().save(order);
    }

    @Override
    public void update(Order order) {
        final Order newOrder = get(order.getId());

        newOrder.setUserId(order.getUserId());
        newOrder.setTotalPrice(order.getTotalPrice());

        getCurrentSession().saveOrUpdate(newOrder);
    }

    @Override
    public void delete(Order order) {
        if (order != null) {
            getCurrentSession().delete(order);
        }
    }

    @Override
    public Order get(Long userId) {
        return getCurrentSession().get(Order.class, userId);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
