package fyzzbox.physicsapp.model.world;

import fyzzbox.physicsapp.model.core.collision.CollisionDetector;
import fyzzbox.physicsapp.model.core.collision.CollisionResolver;
import fyzzbox.physicsapp.model.core.rules.PhysicsRule;
import fyzzbox.physicsapp.model.core.RewindBuffer;
import fyzzbox.physicsapp.model.core.SimulationState;

import java.util.List;

public class World {
    private SimulationState state;
    private RewindBuffer buffer;
    private List<PhysicsRule> rules;
    private CollisionDetector detector;
    private CollisionResolver resolver;

    public void step() {
    }

    public void start() {
    }

    public void pause() {
    }

    public void setTimeScale(double s) {
    }
}
