package fyzzbox.physicsapp.model.world;

import fyzzbox.physicsapp.model.core.Force;
import fyzzbox.physicsapp.model.core.Particle;

import java.util.List;

public class CollisionWorld extends PhysicsWorld {

    @Override
    protected Force computeNetForce(Particle target, List<Particle> allParticles) {
        return Force.zero();
    }

    @Override
    public void step(double dtSeconds) {
        super.step(dtSeconds);
        resolveCollisions();
    }

    private void resolveCollisions() {
        // Placeholder for collision detection and response.
    }
}
