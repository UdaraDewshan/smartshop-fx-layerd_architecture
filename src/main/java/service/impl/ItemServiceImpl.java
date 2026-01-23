package service.impl;

import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.ItemDTO;
import repository.impl.ItemRepositoryImpl;
import service.ItemServise;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemServiceImpl implements ItemServise{
    ItemRepositoryImpl itemRepository = new ItemRepositoryImpl();

    @Override
    public void addItemDetails(String itemCode, String description, String packSize, double unitPrice, int qtyOnHand) {
        try {
            itemRepository.add(itemCode,description,packSize,unitPrice,qtyOnHand);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    @Override
    public void deleteItemDetails(String itemCode) {
        itemRepository.deleteItemDetails(itemCode);
    }

    @Override
    public void updateItemDetails(String itemCode, String description, String packSize, double unitPrice, int qtyOnHand) {
        try {
            itemRepository.updateItem(itemCode,description,packSize,unitPrice,qtyOnHand);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    @Override
    public ObservableList<ItemDTO> getAllItemDetails() {
        ObservableList<ItemDTO> itemDTOS = javafx.collections.FXCollections.observableArrayList();

        try {
            ResultSet resultSet = itemRepository.getAllCustomers();
            while (resultSet.next()){
                ItemDTO itemDTO = new ItemDTO(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4),
                        resultSet.getInt(5)
                );
                itemDTOS.add(itemDTO);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return itemDTOS;
    }

    @Override
    public ItemDTO searchItem(String id) {
        try {
            return itemRepository.searchItem(id);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return null;
    }

    @Override
    public boolean updateItemQty(ObservableList<CartItem> cartItems) {
        for (CartItem cartItem : cartItems) {
            try {
                boolean isUpdated = itemRepository.updateItemQty(cartItem.getItemCode(), cartItem.getQty());
                if (!isUpdated) {
                    return false;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
        return true;
    }

}
