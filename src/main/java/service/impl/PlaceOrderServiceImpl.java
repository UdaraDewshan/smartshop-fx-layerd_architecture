package service.impl;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.CustomerDTO;
import model.dto.ItemDTO;
import model.dto.Orders;
import service.*;
import java.sql.Connection;
import java.sql.SQLException;

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

    public void placeOrder(Orders orders, ObservableList<CartItem> cartItems) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            connection.setAutoCommit(false);

            boolean  isAddOrder= orderService.addOrder(orders);

            if (isAddOrder){
                boolean isAddOrderDetails = orderDetailsService.addOrder(orders, cartItems);
                if (isAddOrderDetails){
                    boolean isAddItem = itemServise.updateItemQty(cartItems);

                    if (isAddItem){
                        connection.commit();
                    }else {
                        connection.rollback();
                        throw new RuntimeException("Item qty not updated");
                    }

                }
            }

        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);

        }finally {
            connection.setAutoCommit(true);
        }
    }



}
