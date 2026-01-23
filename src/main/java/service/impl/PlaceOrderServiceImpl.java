package service.impl;

import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.CustomerDTO;
import model.dto.ItemDTO;
import model.dto.Orders;
import service.CustomerService;
import service.ItemServise;
import service.OrderService;
import service.PlaceOrderService;

public class PlaceOrderServiceImpl implements PlaceOrderService {

    ItemServise itemServise = new ItemServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();

    public CustomerDTO getCustomer(String id) {
        return customerService.searchCustomer(id);
    }

    public ItemDTO getItem(String id) {
        return itemServise.searchItem(id);
    }

    public void placeOrder(Orders orders, ObservableList<CartItem> cartItems) {
        OrderService orderService = new OrderServiceImpl();
        orderService.addOrder(orders);


    }
}
