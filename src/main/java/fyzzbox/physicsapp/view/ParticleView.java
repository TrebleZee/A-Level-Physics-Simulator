package fyzzbox.physicsapp.view;

import fyzzbox.physicsapp.model.core.Particle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ParticleView extends Circle {
    private final Particle particle;

    public ParticleView(Particle particle, double radiusPx) {
        this.particle = particle;
        setRadius(radiusPx);
        setFill(Color.ORANGE);
    }

    public Particle getParticle() {
        return particle;
    }

    public void syncFromModel(double metersPerPixel) {
        setCenterX(particle.getPosition().x() / metersPerPixel);
        setCenterY(particle.getPosition().y() / metersPerPixel);
    }
}
