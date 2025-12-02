package repository;

import db.DBConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositoryImpl implements CusromerRepository{

    @Override
    public void add(String custID, String title, String name, String dob, double salary, String address, String city, String province, String postalCode) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?)");

        preparedStatement.setString(1,custID);
        preparedStatement.setString(2,title);
        preparedStatement.setString(3,name);
        preparedStatement.setString(4,dob);
        preparedStatement.setString(5, String.valueOf(salary));
        preparedStatement.setString(6,address);
        preparedStatement.setString(7,city);
        preparedStatement.setString(8,province);
        preparedStatement.setString(9,postalCode);

        int rowsInserted = preparedStatement.executeUpdate();

        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(null, "Added Successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Add Unsuccessful!");
        }
    }

    @Override
    public void deleteCustomer(String custId) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("Delete from customer where CustID=?");
        preparedStatement.setString(1,custId);
        int i = preparedStatement.executeUpdate();
        if (i>0){
            JOptionPane.showMessageDialog(null, "Delete Successfully!");
        }else{
            JOptionPane.showMessageDialog(null, "Delete Unsuccessful!");
        }
    }

    @Override
    public void updateCustomer(String custID, String title, String name, String dob, double salary, String address, String city, String province, String postalCode) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customer SET CustTitle =?, CustName =?, DOB=?, salary =?, CustAddress= ? ,City=? , Province= ?, PostalCode=? WHERE CustID = ?");
        preparedStatement.setObject(1,title);
        preparedStatement.setObject(2,name);
        preparedStatement.setObject(3,dob);
        preparedStatement.setObject(4,salary);
        preparedStatement.setObject(5,address);
        preparedStatement.setObject(6,city);
        preparedStatement.setObject(7,province);
        preparedStatement.setObject(8,postalCode);
        preparedStatement.setObject(9,custID);
        int i = preparedStatement.executeUpdate();

        if (i>0){
            JOptionPane.showMessageDialog(null, "updated Successfully!");
        }else{
            JOptionPane.showMessageDialog(null, "updated Unsuccessful!");
        }
    }

    @Override
    public ResultSet getAllCustomers() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("Select * From Customer");
        return preparedStatement.executeQuery();
    }
}
