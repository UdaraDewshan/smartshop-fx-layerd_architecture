package repository.impl;

import db.DBConnection;
import repository.ItemRepository;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRepositoryImpl implements ItemRepository{

    @Override
    public ResultSet getAllCustomers() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("Select * From item");
        return preparedStatement.executeQuery();
    }

    public void add(String itemCode, String description, String packSize, double unitPrice, int qtyOnHand) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("Insert Into item VALUES(?,?,?,?,?)");

        preparedStatement.setString(1,itemCode);
        preparedStatement.setString(2,description);
        preparedStatement.setString(3,packSize);
        preparedStatement.setString(4, String.valueOf(unitPrice));
        preparedStatement.setString(5, String.valueOf(qtyOnHand));

        int i = preparedStatement.executeUpdate();

        if (i > 0) {
            JOptionPane.showMessageDialog(null, "Added Successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Add Unsuccessful!");
        }

    }
}
