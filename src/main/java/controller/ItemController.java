package controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.dto.ItemDTO;
import service.impl.ItemServiseImpl;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemController implements Initializable {

    ObservableList<ItemDTO> itemDTOS = FXCollections.observableArrayList();
    ItemServiseImpl itemServise = new ItemServiseImpl();

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnCustomer;

    @FXML
    private JFXButton btnOrderDetail;

    @FXML
    private JFXButton btnOrderPage;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colPackSize;

    @FXML
    private TableColumn<?, ?> colQtyOnHand;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableView<ItemDTO> tblItem;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtPackSize;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtUnitPrice;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colPackSize.setCellValueFactory(new PropertyValueFactory<>("packSize"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        tblItem.setItems(itemDTOS);

        loadtable();

        tblItem.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue!=null){
                txtId.setText(newValue.getCode());
                txtUnitPrice.setText(String.valueOf(newValue.getUnitPrice()));
                txtDescription.setText(newValue.getDescription());
                txtQtyOnHand.setText(String.valueOf(newValue.getQtyOnHand()));
                txtPackSize.setText(newValue.getPackSize());
            }
        });
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        Double price = Double.valueOf(txtUnitPrice.getText());
        itemServise.addItemDetails(txtId.getText(), txtDescription.getText(), txtPackSize.getText(),price, Integer.parseInt(txtQtyOnHand.getText()));
        loadtable();
    }

    @FXML
    void btnBackAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Dashboard.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Dashboard");
            stage.show();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtPackSize.setText("");
        txtDescription.setText("");
        txtUnitPrice.setText("");
        txtId.setText("");
        txtQtyOnHand.setText("");
    }

    @FXML
    void btnCustomerPageAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnOrderDetailAction(ActionEvent event) {

    }

    @FXML
    void btnOrderPageAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    private void loadtable(){
        tblItem.setItems(itemServise.getAllItemDetails());
    }

}
