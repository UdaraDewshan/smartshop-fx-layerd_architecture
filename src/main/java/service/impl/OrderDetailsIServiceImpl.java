package service.impl;

import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.OrderDetail;
import model.dto.Orders;
import repository.OrderDetailsRepository;
import repository.impl.OrderDetailsRepositoryImpl;
import service.OrderDetailsService;

import java.sql.SQLException;

public class OrderDetailsIServiceImpl implements OrderDetailsService {

    OrderDetailsRepository orderDetailsRepository = new OrderDetailsRepositoryImpl();
    @Override
    public void addOrder(Orders orders, ObservableList<CartItem> cartItems){
        for (CartItem temp:cartItems){
            try {
                orderDetailsRepository.addOrderDetails(
                        new OrderDetail(
                                orders.getOrderId(),
                                temp.getItemCode(),
                                temp.getQty(),
                                temp.getDiscount()
                        )
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    }

}
