package service;

import javafx.collections.ObservableList;
import model.dto.CustomerDTO;

import java.sql.SQLException;

public interface CustomerService {
    public void addCustomer(String custID,String title,String name,String dob,double salary,String address,String city,String province,String postalCode) throws SQLException;

    public void deleteCustomer(String custId);

    public void updateCustomer(String custID,String title,String name,String dob,double salary,String address,String city,String province,String postalCode);

    public ObservableList<CustomerDTO> getAllCustomers();
}
