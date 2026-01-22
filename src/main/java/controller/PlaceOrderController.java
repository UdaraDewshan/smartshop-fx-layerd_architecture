package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.dto.CustomerDTO;
import model.dto.ItemDTO;
import service.CustomerService;
import service.ItemServise;
import service.impl.CustomerServiceImpl;
import service.impl.ItemServiceImpl;

public class PlaceOrderController {

    ItemServise itemServise = new ItemServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();

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
    private TableView<?> tblPlaceOrder;

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
    void btnAddToCartAction(ActionEvent event) {

    }

    @FXML
    void btnBackAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderAction(ActionEvent event) {

    }

    @FXML
    void txtCustomerIDAction(ActionEvent event) {
        CustomerDTO customerDTO = customerService.searchCustomer(txtCustomerID.getText());
        if (customerDTO != null){
            txtCustomerName.setText(customerDTO.getName());
        }else {
            new Alert(Alert.AlertType.ERROR, "Customer Not Found!").show();
        }
    }

    @FXML
    void txtItemCodeOnAction(ActionEvent event) {
        ItemDTO itemDTO = itemServise.searchItem(txtItemCode.getText());
        if(itemDTO != null){
                txtItemDescription.setText(itemDTO.getDescription());
                txtPrice.setText(String.valueOf(itemDTO.getUnitPrice()));

        }else {
            new Alert(Alert.AlertType.ERROR, "Item Not Found!").show();
        }

    }

}
