package homework24.dao;

import homework24.model.Order;

import java.util.List;

public interface OrderDAO {

    List<Order> getAll();

    void update(Order order);

    void delete(Order order);

    void add(Order order);

    Order get(Long userId);
}
