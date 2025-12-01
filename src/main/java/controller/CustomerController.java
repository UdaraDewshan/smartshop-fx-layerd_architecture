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
import model.dto.CustomerDTO;
import service.CustomerServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    ObservableList<CustomerDTO> customerDTOS = FXCollections.observableArrayList();

    CustomerServiceImpl customerService = new CustomerServiceImpl();
    @FXML
    private JFXButton btnBack;
    @FXML
    private TableColumn<?, ?> colAddress;
    @FXML
    private TableColumn<?, ?> colCity;
    @FXML
    private TableColumn<?, ?> colDob;
    @FXML
    private TableColumn<?, ?> colId;
    @FXML
    private TableColumn<?, ?> colName;
    @FXML
    private TableColumn<?, ?> colPostalCode;
    @FXML
    private TableColumn<?, ?> colProvince;
    @FXML
    private TableColumn<?, ?> colSalary;
    @FXML
    private TableColumn<?, ?> colTitle;
    @FXML
    private TableView<CustomerDTO> tblCustomer;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtCity;
    @FXML
    private TextField txtDob;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPostalCode;
    @FXML
    private TextField txtProvince;
    @FXML
    private TextField txtSalary;
    @FXML
    private TextField txtTitle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        tblCustomer.setItems(customerDTOS);

        loadtable();

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if(newValue != null){
                txtAddress.setText(newValue.getAddress());
                txtCity.setText(newValue.getCity());
                txtDob.setText(newValue.getDob());
                txtName.setText(newValue.getName());
                txtProvince.setText(newValue.getProvince());
                txtId.setText(newValue.getId());
                txtPostalCode.setText(newValue.getPostalCode());
                txtSalary.setText(String.valueOf(newValue.getSalary()));
                txtTitle.setText(newValue.getTitle());
            }
        });
    }

    private void loadtable() {
        tblCustomer.setItems(customerService.getAllCustomers());
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String custID = txtId.getText();
        String title = txtTitle.getText();
        String name = txtName.getText();
        String dob = txtDob.getText();
        double salary = Double.parseDouble(txtSalary.getText());
        String address = txtAddress.getText();
        String city = txtCity.getText();
        String province = txtProvince.getText();
        String postalCode = txtPostalCode.getText();

        customerService.addCustomer(custID,title,name,dob,salary,address,city,province,postalCode);
        loadtable();
        clearTest();
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
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearTest();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    public void clearTest(){
        txtAddress.setText("");
        txtCity.setText("");
        txtDob.setText("");
        txtName.setText("");
        txtProvince.setText("");
        txtId.setText("");
        txtPostalCode.setText("");
        txtSalary.setText("");
        txtTitle.setText("");
    }


}
