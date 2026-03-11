package fyzzbox.physicsapp.model.core;

public final class Force {
    private final Vector2D vector;

    public Force(Vector2D vector) {
        this.vector = vector;
    }

    public static Force of(double x, double y) {
        return new Force(new Vector2D(x, y));
    }

    public static Force zero() {
        return new Force(Vector2D.zero());
    }

    public Vector2D vector() {
        return vector;
    }

    public Force add(Force other) {
        return new Force(vector.add(other.vector));
    }
}
