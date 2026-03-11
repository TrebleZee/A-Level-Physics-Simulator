package fyzzbox.physicsapp.model.world;

import fyzzbox.physicsapp.model.core.Force;
import fyzzbox.physicsapp.model.core.Particle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class PhysicsWorld {
    protected final List<Particle> particles = new ArrayList<>();

    public void addParticle(Particle particle) {
        particles.add(particle);
    }

    public void removeParticle(Particle particle) {
        particles.remove(particle);
    }

    public void clearParticles() {
        particles.clear();
    }

    public List<Particle> getParticles() {
        return Collections.unmodifiableList(particles);
    }

    public void step(double dtSeconds) {
        for (Particle particle : particles) {
            Force netForce = computeNetForce(particle, particles);
            particle.applyForce(netForce);
        }

        for (Particle particle : particles) {
            particle.update(dtSeconds);
        }
    }

    protected abstract Force computeNetForce(Particle target, List<Particle> allParticles);
}
