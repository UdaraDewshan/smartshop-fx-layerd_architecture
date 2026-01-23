package service;

import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.CustomerDTO;
import model.dto.ItemDTO;
import model.dto.Orders;

public interface PlaceOrderService {


    public CustomerDTO getCustomer(String id);

    public ItemDTO getItem(String id);

    public void placeOrder(Orders orders, ObservableList<CartItem> cartItems);
}
