package fyzzbox.physicsapp.model.core;


public class Body {
    private Vector2D position;
    private Vector2D velocity;
    private Vector2D force;
    private double mass;
    private Shape shape;

    public void applyForce(Vector2D f) {
    }

    public void update(double dt) {
    }

    public Vector2D getPosition() {
        return null;
    }

    public Shape getShape() {
        return null;
    }
}
