package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CusromerRepository {

    public void add(String custID,String title,String name,String dob,double salary,String address,String city,String province,String postalCode) throws SQLException;

    public void deleteCustomer(String custId) throws SQLException;

    public void updateCustomer(String custID,String title,String name,String dob,double salary,String address,String city,String province,String postalCode) throws SQLException;

    public ResultSet getAllCustomers() throws SQLException;

}