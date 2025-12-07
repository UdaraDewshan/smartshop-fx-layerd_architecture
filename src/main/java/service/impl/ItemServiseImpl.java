package service.impl;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.dto.CustomerDTO;
import model.dto.ItemDTO;
import repository.impl.ItemRepositoryImpl;
import service.ItemServise;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemServiseImpl implements ItemServise{
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

    }

    @Override
    public void updateItemDetails(String itemCode, String description, String packSize, double unitPrice, int qtyOnHand) {

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

}
