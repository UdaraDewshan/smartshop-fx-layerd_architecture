package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.dto.CartItem;
import model.dto.CustomerDTO;
import model.dto.ItemDTO;
import model.dto.Orders;
import service.PlaceOrderService;
import service.impl.PlaceOrderServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class PlaceOrderController implements Initializable {

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colDiscount;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private Label lblNetPrice;

    @FXML
    private TableView<CartItem> tblPlaceOrder;

    @FXML
    private TextField txtCustomerID;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtDiscount;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtItemDescription;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtOrderId;

    PlaceOrderService placeOrderService = new PlaceOrderServiceImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
    }

    ObservableList<CartItem> cartItems = FXCollections.observableArrayList();
    @FXML
    void btnAddToCartAction(ActionEvent event) {
        CartItem cartItem = new CartItem(
                txtItemCode.getText(),
                txtItemDescription.getText(),
                Integer.parseInt(txtQty.getText()),
                Double.parseDouble(txtPrice.getText()),
                Double.parseDouble(txtDiscount.getText()),
                (Integer.parseInt(txtQty.getText()) * Double.parseDouble(txtPrice.getText())) - Double.parseDouble(txtDiscount.getText())
        );
        cartItems.add(cartItem);
        clearText();
        tblPlaceOrder.setItems(cartItems);
        calculateNetTotal();
    }

    private void calculateNetTotal() {
        double netTotal = 0;
        for (CartItem item : cartItems) {
            netTotal += item.getTotal();
        }
        lblNetPrice.setText(String.valueOf(netTotal));
    }

    @FXML
    void btnBackAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"))));
        Stage stage1 = (Stage) btnBack.getScene().getWindow();
        stage1.close();
        stage.show();
        stage.setTitle("Dashboard");
    }


    @FXML
    void txtCustomerIDAction(ActionEvent event) {

        CustomerDTO customerDTO = placeOrderService.getCustomer(txtCustomerID.getText());
        if (customerDTO != null){
            txtCustomerName.setText(customerDTO.getName());
        }else {
            new Alert(Alert.AlertType.ERROR, "Customer Not Found!").show();
        }
    }

    @FXML
    void txtItemCodeOnAction(ActionEvent event) {
        ItemDTO itemDTO = placeOrderService.getItem(txtItemCode.getText());
        if(itemDTO != null){
            txtItemDescription.setText(itemDTO.getDescription());
            txtPrice.setText(String.valueOf(itemDTO.getUnitPrice()));

        }else {
            new Alert(Alert.AlertType.ERROR, "Item Not Found!").show();
        }

    }

    void clearText(){
        txtItemCode.setText("");
        txtItemDescription.setText("");
        txtPrice.setText("");
        txtQty.setText("");
        txtDiscount.setText("");
    }

    @FXML
    void btnPlaceOrderAction(ActionEvent event) throws SQLException {

        placeOrderService.placeOrder(new Orders(
                    txtOrderId.getText(),
                    LocalDate.now(),
                    txtCustomerID.getText().trim()
        ),cartItems);
    }


}
