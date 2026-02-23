package fyzzbox.physicsapp.model.scenarios;

import fyzzbox.physicsapp.model.core.Particle;
import fyzzbox.physicsapp.model.core.Vector2D;
import fyzzbox.physicsapp.model.world.PhysicsWorld;

public class SolarSystemScenario implements Scenario {
    @Override
    public String getName() {
        return "Solar System";
    }

    @Override
    public void configure(PhysicsWorld world) {
        world.clearParticles();

        Particle sun = new Particle(new Vector2D(0, 0), Vector2D.zero(), 1.9885e30, 10);
        Particle earth = new Particle(new Vector2D(1.496e11, 0), new Vector2D(0, 29_780), 5.972e24, 5);

        world.addParticle(sun);
        world.addParticle(earth);
    }
}
