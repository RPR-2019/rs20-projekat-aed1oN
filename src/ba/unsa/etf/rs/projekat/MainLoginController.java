package ba.unsa.etf.rs.projekat;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainLoginController {

    private HotelDAO users;

    public TextField fldUsername;
    public PasswordField fldPassword;
    public Label wrongLabel;
    public Button logIn;

    public MainLoginController(HotelDAO users) {
        this.users = users;
    }

    public void loginAction(ActionEvent actionEvent) throws IOException {
        if (users.validateUser(fldUsername.getText(), fldPassword.getText())) {
            fldUsername.getStyleClass().removeAll("invalidField");
            fldPassword.getStyleClass().removeAll("invalidField");
            wrongLabel.setText("");
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainScreen.fxml"));
            loader.setController(new MainScreenController(users));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
            primaryStage.show();
        } else {
            shake(fldUsername);
            shake(fldPassword);
            fldUsername.getStyleClass().add("invalidField");
            fldPassword.getStyleClass().add("invalidField");
            wrongLabel.setText("Wrong username or password");
        }
    }

    private void shake(TextField field) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(0), new KeyValue(field.translateXProperty(), 0, Interpolator.LINEAR)),
                new KeyFrame(Duration.millis(100), new KeyValue(field.translateXProperty(), 10, Interpolator.LINEAR)),
                new KeyFrame(Duration.millis(200), new KeyValue(field.translateXProperty(), 0, Interpolator.LINEAR)),
                new KeyFrame(Duration.millis(300), new KeyValue(field.translateXProperty(), 10, Interpolator.LINEAR)),
                new KeyFrame(Duration.millis(400), new KeyValue(field.translateXProperty(), 0, Interpolator.LINEAR)),
                new KeyFrame(Duration.millis(500), new KeyValue(field.translateXProperty(), 10, Interpolator.LINEAR)),
                new KeyFrame(Duration.millis(600), new KeyValue(field.translateXProperty(), 0, Interpolator.LINEAR)));
        timeline.play();
    }

}
