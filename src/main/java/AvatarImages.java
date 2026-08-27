import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/** Produces simple in-memory avatars used by the tutorial application. */
public final class AvatarImages {
    private AvatarImages() {
    }

    public static Image user() {
        return create(Color.CORNFLOWERBLUE);
    }

    public static Image duke() {
        return create(Color.MEDIUMSEAGREEN);
    }

    private static Image create(Color color) {
        WritableImage image = new WritableImage(100, 100);
        for (int y = 0; y < 100; y++) {
            for (int x = 0; x < 100; x++) {
                double distance = Math.hypot(x - 49.5, y - 49.5);
                image.getPixelWriter().setColor(x, y, distance < 46 ? color : Color.TRANSPARENT);
            }
        }
        return image;
    }
}
