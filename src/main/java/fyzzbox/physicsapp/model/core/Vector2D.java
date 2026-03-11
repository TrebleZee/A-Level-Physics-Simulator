package fyzzbox.physicsapp.model.core;

public final class Vector2D {
    private final double x;
    private final double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Vector2D zero() {
        return new Vector2D(0.0, 0.0);
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public Vector2D add(Vector2D other) {
        return new Vector2D(x + other.x, y + other.y);
    }

    public Vector2D subtract(Vector2D other) {
        return new Vector2D(x - other.x, y - other.y);
    }

    public Vector2D scale(double scalar) {
        return new Vector2D(x * scalar, y * scalar);
    }

    public double magnitude() {
        return Math.hypot(x, y);
    }

    public Vector2D normalize() {
        double mag = magnitude();
        if (mag == 0.0) {
            return zero();
        }
        return scale(1.0 / mag);
    }
}
