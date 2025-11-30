package service;

import javafx.collections.ObservableList;
import model.dto.CustomerDTO;
import repository.CustomerRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerService {

    CustomerRepository customerRepository = new CustomerRepository();

    public ObservableList<CustomerDTO> getAllCustomers() {
        ObservableList<CustomerDTO> customerDTOS = javafx.collections.FXCollections.observableArrayList();
        try {
            ResultSet resultSet = customerRepository.getAllCustomers();
            while (resultSet.next()){
                CustomerDTO customerDTO = new CustomerDTO(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDouble(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9)
                );
                customerDTOS.add(customerDTO);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerDTOS;
    }

    public void addCustomer(String custID, String title, String name, String dob, double salary, String address, String city, String province, String postalCode) {
        try {
            customerRepository.add(custID,title,name,dob,salary,address,city,province,postalCode);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
