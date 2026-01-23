package service;

import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.ItemDTO;

public interface ItemServise {
    public void addItemDetails(String itemCode, String description, String packSize, double unitPrice, int qtyOnHand);
    public void deleteItemDetails(String itemCode);
    public void updateItemDetails(String itemCode, String description, String packSize, double unitPrice, int qtyOnHand);
    public ObservableList<ItemDTO> getAllItemDetails();
    public ItemDTO searchItem(String id);

    void updateItemQty(ObservableList<CartItem> cartItems);
}
