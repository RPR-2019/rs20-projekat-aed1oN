package ba.unsa.etf.rs.projekat;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController {
    HotelDAO users;

    public Button logOutButton;


    public MainScreenController(HotelDAO users) {
        this.users = users;
    }


    public void logOutAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)logOutButton.getScene().getWindow();
        stage.close();
    }
}
