package repository;

import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.OrderDetail;
import model.dto.Orders;

import java.sql.SQLException;

public interface OrderDetailsRepository {
    public void addOrderDetails(OrderDetail orderDetail) throws SQLException;
}
