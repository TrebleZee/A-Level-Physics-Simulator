package fyzzbox.physicsapp.model.world;

import fyzzbox.physicsapp.model.core.Force;
import fyzzbox.physicsapp.model.core.Particle;
import fyzzbox.physicsapp.model.core.Vector2D;

import java.util.List;

public class NewtonianWorld extends PhysicsWorld {
    private static final double G = 6.67430e-11;

    @Override
    protected Force computeNetForce(Particle target, List<Particle> allParticles) {
        Vector2D sum = Vector2D.zero();

        for (Particle other : allParticles) {
            if (other == target) {
                continue;
            }

            Vector2D direction = other.getPosition().subtract(target.getPosition());
            double distance = Math.max(direction.magnitude(), 1e-6);
            double magnitude = G * target.getMass() * other.getMass() / (distance * distance);
            Vector2D contribution = direction.normalize().scale(magnitude);
            sum = sum.add(contribution);
        }

        return new Force(sum);
    }
}
