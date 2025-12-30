package controller;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class WelcomePageController {

    Stage stage = new Stage();

    @FXML
    private Button btnGo;

    @FXML
    public void initialize() {
        addButtonHoverAnimation();
    }

    @FXML
    private void handleGoAction() throws IOException {

        ScaleTransition st = new ScaleTransition(Duration.millis(150), btnGo);
        st.setFromX(1.0);
        st.setFromY(1.0);
        st.setToX(0.90);
        st.setToY(0.90);
        st.setAutoReverse(true);
        st.setCycleCount(2);
        st.play();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"))));
        Stage stage1 = (Stage) btnGo.getScene().getWindow();
        stage1.close();
        stage.show();
        stage.setTitle("Dashboard Page");

    }

    private void addButtonHoverAnimation() {

        btnGo.setOnMouseEntered(e -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(150), btnGo);
            st.setToX(1.12);
            st.setToY(1.12);
            st.play();
        });

        btnGo.setOnMouseExited(e -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(150), btnGo);
            st.setToX(1.0);
            st.setToY(1.0);
            st.play();
        });
    }
}
