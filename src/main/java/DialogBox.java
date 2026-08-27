import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/** A chat message together with its speaker's avatar. */
public class DialogBox extends HBox {
    private final Label text;
    private final ImageView displayPicture;

    private DialogBox(String message, Image image) {
        text = new Label(message);
        displayPicture = new ImageView(image);
        text.setWrapText(true);
        displayPicture.setFitWidth(100.0);
        displayPicture.setFitHeight(100.0);
        setAlignment(Pos.TOP_RIGHT);
        getChildren().addAll(text, displayPicture);
    }

    public static DialogBox getUserDialog(String message, Image image) {
        return new DialogBox(message, image);
    }
}
