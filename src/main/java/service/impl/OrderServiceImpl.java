package service.impl;

import model.dto.Orders;
import repository.OrderRepository;
import repository.impl.OrderRepositoryImpl;
import service.OrderService;

import java.sql.SQLException;

public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository = new OrderRepositoryImpl();

    @Override
    public boolean addOrder(Orders orders) {
        try {
            return orderRepository.addOrder(orders);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
