package fyzzbox.physicsapp.model.core.rigidbodies;


import fyzzbox.physicsapp.model.core.Vector2D;

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

    public Vector2D getVelocity() {
        return null;
    }

    public double getMass() {
        return 0.0;
    }

    public Shape getShape() {
        return null;
    }
}
