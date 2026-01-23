package controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.dto.ItemDTO;
import service.impl.ItemServiceImpl;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemController implements Initializable {

    ObservableList<ItemDTO> itemDTOS = FXCollections.observableArrayList();
    ItemServiceImpl itemServise = new ItemServiceImpl();

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

        loadTable();

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
        double price = Double.parseDouble(txtUnitPrice.getText());
        itemServise.addItemDetails(txtId.getText(), txtDescription.getText(), txtPackSize.getText(),price, Integer.parseInt(txtQtyOnHand.getText()));
        loadTable();
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
        clearText();
    }

    private void clearText() {
        txtPackSize.setText("");
        txtDescription.setText("");
        txtUnitPrice.setText("");
        txtId.setText("");
        txtQtyOnHand.setText("");
    }

    @FXML
    void btnCustomerPageAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CustomerPage.fxml"))));
        Stage stage1 = (Stage) btnCustomer.getScene().getWindow();
        stage1.close();
        stage.show();
        stage.setTitle("Order Management Page");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        itemServise.deleteItemDetails(txtId.getText());
        loadTable();
    }

    @FXML
    void btnOrderDetailAction(ActionEvent event) {

    }

    @FXML
    void btnOrderPageAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        double price = Double.parseDouble(txtUnitPrice.getText());
        itemServise.updateItemDetails(txtId.getText(),txtDescription.getText(),txtPackSize.getText(),price, Integer.parseInt(txtQtyOnHand.getText()));
        loadTable();
    }

    private void loadTable(){
        tblItem.setItems(itemServise.getAllItemDetails());
    }

    @FXML
    void txtIdOnAction(ActionEvent event) {
        String id = txtId.getText();
        ItemDTO itemDTO = itemServise.searchItem(id);

        if(itemDTO != null){
            txtPackSize.setText(itemDTO.getPackSize());
            txtDescription.setText(itemDTO.getDescription());
            txtUnitPrice.setText(String.valueOf(itemDTO.getUnitPrice()));
            txtId.setText(itemDTO.getCode());
            txtQtyOnHand.setText(String.valueOf(itemDTO.getQtyOnHand()));
        }else{
            new Alert(Alert.AlertType.ERROR, "Item Not Found!").show();
            clearText();
        }
    }

}
