package fyzzbox.physicsapp.model.scenarios;

import fyzzbox.physicsapp.model.world.PhysicsWorld;

public interface Scenario {
    String getName();

    void configure(PhysicsWorld world);
}
