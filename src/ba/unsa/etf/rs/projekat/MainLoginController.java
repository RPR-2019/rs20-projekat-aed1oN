package ba.unsa.etf.rs.projekat;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainLoginController {


    public Button closeButton;

    public void closeAction(ActionEvent actionEvent) {
        Stage stage = (Stage)closeButton.getScene().getWindow();
        stage.close();
    }
}
