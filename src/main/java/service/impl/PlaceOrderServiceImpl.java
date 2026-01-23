package service.impl;

import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.CustomerDTO;
import model.dto.ItemDTO;
import model.dto.Orders;
import service.*;

public class PlaceOrderServiceImpl implements PlaceOrderService {

    ItemServise itemServise = new ItemServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();

    public CustomerDTO getCustomer(String id) {
        return customerService.searchCustomer(id);
    }

    public ItemDTO getItem(String id) {
        return itemServise.searchItem(id);
    }


    OrderService orderService = new OrderServiceImpl();
    OrderDetailsService orderDetailsService = new OrderDetailsIServiceImpl();

    public void placeOrder(Orders orders, ObservableList<CartItem> cartItems) {

        orderService.addOrder(orders);
        orderDetailsService.addOrder(orders, cartItems);
        itemServise.updateItemQty(cartItems);

    }
}
