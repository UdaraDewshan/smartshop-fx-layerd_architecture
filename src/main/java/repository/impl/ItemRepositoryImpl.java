package repository.impl;

import db.DBConnection;
import model.dto.ItemDTO;
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

    public void deleteItemDetails(String itemCode) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from item where ItemCode=?");
            preparedStatement.setString(1,itemCode);
            int i = preparedStatement.executeUpdate();
            if (i>0){
                JOptionPane.showMessageDialog(null, "Delete Successfully!");
            }else{
                JOptionPane.showMessageDialog(null, "Delete Unsuccessful!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }

    @Override
    public ItemDTO searchItem(String id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from item where ItemCode=?");
        preparedStatement.setObject(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            return new ItemDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getInt(5)
            );
        }

        return null;
    }

    @Override
    public void updateItem(String itemCode, String description, String packSize, double unitPrice, int qtyOnHand) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update item set Description=? , PackSize=?, UnitPrice=?, QtyOnHand=? where ItemCode=?");
        preparedStatement.setObject(1,description);
        preparedStatement.setObject(2,packSize);
        preparedStatement.setObject(3,unitPrice);
        preparedStatement.setObject(4,qtyOnHand);
        preparedStatement.setObject(5,itemCode);
        int i = preparedStatement.executeUpdate();

        if (i>0){
            JOptionPane.showMessageDialog(null, "updated Successfully!");
        }else{
            JOptionPane.showMessageDialog(null, "updated Unsuccessful!");
        }

    }

    public boolean updateItemQty(String itemCode, int qty) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update item set QtyOnHand=QtyOnHand-? where ItemCode=?");
        preparedStatement.setInt(1,qty);
        preparedStatement.setString(2,itemCode);

        return preparedStatement.executeUpdate() > 0;
    }
}
