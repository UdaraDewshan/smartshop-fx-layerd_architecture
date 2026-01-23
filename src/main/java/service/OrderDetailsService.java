package service;

import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.Orders;

public interface OrderDetailsService {
    public void addOrder(Orders orders, ObservableList<CartItem> cartItems);
}
