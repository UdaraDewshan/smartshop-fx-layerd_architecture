package repository;
import model.dto.OrderDetail;

import java.sql.SQLException;

public interface OrderDetailsRepository {
    public boolean addOrderDetails(OrderDetail orderDetail) throws SQLException;
}
