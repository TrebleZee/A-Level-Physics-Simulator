package fyzzbox.physicsapp.model.core.rules;

import fyzzbox.physicsapp.model.core.rigidbodies.Body;
import fyzzbox.physicsapp.model.core.Vector2D;

public interface PhysicsRule {
    boolean detect(Body b);

    Vector2D calculate(Body b);

    void apply(Body b);
}
