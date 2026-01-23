package repository;

import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.Orders;

public interface OrderDetailsRepository {
    void addItemDetails(Orders orders, ObservableList<CartItem> cartItems);
}
