package repository;

import model.dto.Orders;

import java.sql.SQLException;

public interface OrderRepository {
    public void addOrder(Orders orders) throws SQLException;
}
