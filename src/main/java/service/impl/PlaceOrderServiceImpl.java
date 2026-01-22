package service.impl;

import model.dto.CustomerDTO;
import model.dto.ItemDTO;
import service.CustomerService;
import service.ItemServise;

public class PlaceOrderServiceImpl {

    ItemServise itemServise = new ItemServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();


    public CustomerDTO getCustomer(String id) {
        return customerService.searchCustomer(id);
    }

    public ItemDTO getItem(String id) {
        return itemServise.searchItem(id);
    }
}
