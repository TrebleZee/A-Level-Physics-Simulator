package fyzzbox.physicsapp.model.core;

public interface RigidBody {
    Vector2D getPosition();

    void setPosition(Vector2D position);

    Vector2D getVelocity();

    void setVelocity(Vector2D velocity);

    double getMass();

    void applyForce(Force force);

    void update(double dtSeconds);
}
