import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/** A chat message together with its speaker's avatar. */
public class DialogBox extends HBox {
    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    private DialogBox(String message, Image image) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new IllegalStateException("Unable to load a dialog box", exception);
        }
        dialog.setText(message);
        displayPicture.setImage(image);
    }

    public static DialogBox getUserDialog(String message, Image image) {
        return new DialogBox(message, image);
    }

    public static DialogBox getDukeDialog(String message, Image image) {
        return getDukeDialog(message, image, "");
    }

    public static DialogBox getDukeDialog(String message, Image image, String commandType) {
        DialogBox dialogBox = new DialogBox(message, image);
        dialogBox.flip();
        dialogBox.changeDialogStyle(commandType);
        return dialogBox;
    }

    /** Moves the avatar to the left to distinguish Duke's messages. */
    private void flip() {
        setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> children = FXCollections.observableArrayList(getChildren());
        Collections.reverse(children);
        getChildren().setAll(children);
        dialog.getStyleClass().add("reply-label");
    }

    /** Adds a visual treatment for supported Duke command categories. */
    private void changeDialogStyle(String commandType) {
        switch (commandType) {
        case "add" -> dialog.getStyleClass().add("add-label");
        case "marked" -> dialog.getStyleClass().add("marked-label");
        case "delete" -> dialog.getStyleClass().add("delete-label");
        default -> {
            // The standard response style needs no additional class.
        }
        }
    }
}
