package ba.unsa.etf.rs.projekat;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainLoginController {

    private UsersDAO users;

    public Button closeButton;
    public Button loginButton;
    public TextField fldUsername;
    public PasswordField fldPassword;
    public Label wrongLabel;

    public MainLoginController(UsersDAO users) {
        this.users = users;
    }

    public void closeAction(ActionEvent actionEvent) {
        Stage stage = (Stage)closeButton.getScene().getWindow();
        stage.close();
    }

    public void loginAction(ActionEvent actionEvent) {
        if (users.validateUser(fldUsername.getText(), fldPassword.getText())) {
            fldUsername.getStyleClass().removeAll("invalidField");
            fldPassword.getStyleClass().removeAll("invalidField");
            wrongLabel.setText("");
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
