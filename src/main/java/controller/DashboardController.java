package controller;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class DashboardController {

    @FXML
    private Button btnCustomer;
    @FXML
    private Button btnItem;
    @FXML
    private Button btnOrder;
    @FXML
    private Button btnOrderDetail;
    @FXML
    private StackPane cardCustomer;
    @FXML
    private StackPane cardItem;
    @FXML
    private StackPane cardOrder;
    @FXML
    private StackPane cardOrderDetail;

    public void initialize() {
        addCardHover(cardCustomer);
        addCardHover(cardItem);
        addCardHover(cardOrder);
        addCardHover(cardOrderDetail);
    }

    private void addCardHover(StackPane card) {
        card.setOnMouseEntered(e -> scale(card, 1.05));
        card.setOnMouseExited(e -> scale(card, 1.0));
    }

    private void scale(StackPane card, double size) {
        ScaleTransition st = new ScaleTransition(Duration.millis(200), card);
        st.setToX(size);
        st.setToY(size);
        st.play();
    }

    @FXML
    void btnCustomerAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/"))));
        Stage stage1 = (Stage) btnCustomer.getScene().getWindow();
        stage1.close();
        stage.show();
        stage.setTitle("Customer Management Page");
    }

    @FXML
    void btnItemAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/"))));
        Stage stage1 = (Stage) btnItem.getScene().getWindow();
        stage1.close();
        stage.show();
        stage.setTitle("Item Management Page");
    }

    @FXML
    void btnOrderAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"))));
        Stage stage1 = (Stage) btnOrder.getScene().getWindow();
        stage1.close();
        stage.show();
        stage.setTitle("Order Management Page");
    }

    @FXML
    void btnOrderDetailAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"))));
        Stage stage1 = (Stage) btnOrderDetail.getScene().getWindow();
        stage1.close();
        stage.show();
        stage.setTitle("OrderDetail Management Page");
    }

}
