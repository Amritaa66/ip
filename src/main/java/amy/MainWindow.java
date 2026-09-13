package amy;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
/**
 * Controller for the main GUI.
 */

public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Amy amy;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/img.png"));
    private Image amyImage = new Image(this.getClass().getResourceAsStream("/images/img_1.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the Duke instance */
    public void setAmy(Amy a) {
        amy = a;
        String savedTasks = amy.getResponse("list");
        if (!savedTasks.equals("There are no tasks in your list!")) {
            dialogContainer.getChildren().add(DialogBox.getDukeDialog(savedTasks, amyImage, false));
        }
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        // The controller is injected by Main before the user can interact with the window.
        assert amy != null : "Amy must be injected before handling user input";
        String input = userInput.getText();
        String response = amy.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, amyImage, isErrorResponse(response))
        );
        userInput.clear();
    }

    /**
     * Identifies responses that should receive Amy's error styling.
     *
     * @param response the response returned by Amy
     * @return true when the response reports invalid input or unavailable data
     */
    private boolean isErrorResponse(String response) {
        return response.startsWith("I'm sorry")
                || response.startsWith("Please ")
                || response.startsWith("A todo description cannot")
                || response.startsWith("That task does not exist")
                || response.startsWith("There is no command to undo")
                || response.startsWith("Undo cancelled")
                || response.startsWith("Unable to save");
    }
}
