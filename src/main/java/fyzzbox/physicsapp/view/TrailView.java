package fyzzbox.physicsapp.view;

import fyzzbox.physicsapp.model.core.Vector2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrailView extends Polyline {
    private final Deque<Double> points = new ArrayDeque<>();
    private final int maxPoints;

    public TrailView(int maxPoints) {
        this.maxPoints = maxPoints;
        setStroke(Color.DEEPSKYBLUE);
        setStrokeWidth(1.5);
    }

    public void addPoint(Vector2D point, double metersPerPixel) {
        points.addLast(point.x() / metersPerPixel);
        points.addLast(point.y() / metersPerPixel);

        while (points.size() > maxPoints * 2) {
            points.removeFirst();
            points.removeFirst();
        }

        getPoints().setAll(points);
    }
}
