package fyzzbox.physicsapp.model.core;

public class Particle implements RigidBody {
    private Vector2D position;
    private Vector2D velocity;
    private final double mass;
    private final double radius;
    private Force netForce = Force.zero();

    public Particle(Vector2D position, Vector2D velocity, double mass, double radius) {
        this.position = position;
        this.velocity = velocity;
        this.mass = mass;
        this.radius = radius;
    }

    @Override
    public Vector2D getPosition() {
        return position;
    }

    @Override
    public void setPosition(Vector2D position) {
        this.position = position;
    }

    @Override
    public Vector2D getVelocity() {
        return velocity;
    }

    @Override
    public void setVelocity(Vector2D velocity) {
        this.velocity = velocity;
    }

    @Override
    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void applyForce(Force force) {
        netForce = netForce.add(force);
    }

    @Override
    public void update(double dtSeconds) {
        Vector2D acceleration = netForce.vector().scale(1.0 / mass);
        velocity = velocity.add(acceleration.scale(dtSeconds));
        position = position.add(velocity.scale(dtSeconds));
        netForce = Force.zero();
    }
}
