package service.impl;

import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.Orders;
import repository.OrderDetailsRepository;
import repository.impl.OrderDetailsRepositoryImpl;
import service.OrderDetailsService;

import java.sql.SQLException;

public class OrderDetailsImpl implements OrderDetailsService {

    OrderDetailsRepository orderDetailsRepository = new OrderDetailsRepositoryImpl();
    @Override
    public void addOrder(Orders orders, ObservableList<CartItem> cartItems){
        try {
            orderDetailsRepository.addItemDetails(orders,cartItems);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
