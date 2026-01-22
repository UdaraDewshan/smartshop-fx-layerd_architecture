package repository;

import model.dto.ItemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ItemRepository {
    public ResultSet getAllCustomers() throws SQLException;
    public void add(String itemCode, String description, String packSize, double unitPrice, int qtyOnHand) throws SQLException;
    public void deleteItemDetails(String itemCode);
    public ItemDTO searchItem(String id) throws SQLException;
    public void updateItem(String itemCode, String description, String packSize, double unitPrice, int qtyOnHand) throws SQLException;
}
