package homework24.service;

import homework24.model.Order;

import java.util.List;

public interface OrderService {

    void add(Order order);

    List<Order> getAll();

    Order getByUserId(Long userId);
}
