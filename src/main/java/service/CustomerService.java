package service;

import javafx.collections.ObservableList;
import model.dto.CustomerDTO;
import repository.CustomerRepository;

public class CustomerService {

    CustomerRepository customerrepository = new CustomerRepository();

    public ObservableList<CustomerDTO> getAllCustomers() {
        return customerrepository.getAllCustomers();
    }
}
