package repository.impl;

import db.DBConnection;
import model.dto.OrderDetail;
import repository.OrderDetailsRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailsRepositoryImpl implements OrderDetailsRepository {

    @Override
    public void addOrderDetails(OrderDetail orderDetail) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO orderdetail VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, orderDetail.getOrderId());
        preparedStatement.setObject(2, orderDetail.getItemCode());
        preparedStatement.setObject(3, orderDetail.getOrderQty());
        preparedStatement.setObject(4, orderDetail.getDiscount());
        preparedStatement.executeUpdate();
    }
}
