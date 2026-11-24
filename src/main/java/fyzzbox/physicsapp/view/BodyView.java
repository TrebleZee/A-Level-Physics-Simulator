package fyzzbox.physicsapp.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BodyView extends Circle {
    public BodyView(double radiusPx) {
        setRadius(radiusPx);
        setFill(Color.ORANGE);
    }

    public void updatePosition(double xPixels, double yPixels) {
        setCenterX(xPixels);
        setCenterY(yPixels);
    }
}
