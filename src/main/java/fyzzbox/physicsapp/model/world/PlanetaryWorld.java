package fyzzbox.physicsapp.model.world;

import fyzzbox.physicsapp.model.core.Particle;

public class PlanetaryWorld extends NewtonianWorld {
    private Particle centralBody;

    public Particle getCentralBody() {
        return centralBody;
    }

    public void setCentralBody(Particle centralBody) {
        this.centralBody = centralBody;
    }
}
