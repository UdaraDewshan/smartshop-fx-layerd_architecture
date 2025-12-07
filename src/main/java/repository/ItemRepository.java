package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ItemRepository {
    public ResultSet getAllCustomers() throws SQLException;
    public void add(String itemCode, String description, String packSize, double unitPrice, int qtyOnHand) throws SQLException;
}
