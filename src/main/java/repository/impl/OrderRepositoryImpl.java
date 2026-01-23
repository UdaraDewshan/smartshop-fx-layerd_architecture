package repository.impl;

import db.DBConnection;
import model.dto.Orders;
import repository.OrderRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderRepositoryImpl implements OrderRepository {

    public void addOrder(Orders orders) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO orders VALUES(?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setObject(1, orders.getOrderId());
        preparedStatement.setObject(2, orders.getOrderDate());
        preparedStatement.setObject(3, orders.getCustomerId());

        preparedStatement.executeUpdate();
    }
}
