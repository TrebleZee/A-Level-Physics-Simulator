package fyzzbox.physicsapp.model.core;

public interface PhysicsRule {
    boolean detect(Body b);

    Vector2D calculate(Body b);

    void apply(Body b);
}
