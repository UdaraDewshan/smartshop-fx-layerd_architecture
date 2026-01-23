package repository;

import model.dto.Orders;

import java.sql.SQLException;

public interface OrderRepository {
    public boolean addOrder(Orders orders) throws SQLException;
}
