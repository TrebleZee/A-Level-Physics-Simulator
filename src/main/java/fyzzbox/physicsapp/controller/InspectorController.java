package fyzzbox.physicsapp.controller;

import fyzzbox.physicsapp.app.SceneManager;
import fyzzbox.physicsapp.model.core.Particle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InspectorController {
    @FXML
    private Label massLabel;
    @FXML
    private Label positionLabel;
    @FXML
    private Label velocityLabel;

    private SceneManager sceneManager;

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public void inspect(Particle particle) {
        massLabel.setText(String.format("Mass: %.3e kg", particle.getMass()));
        positionLabel.setText(String.format("Position: (%.2f, %.2f)", particle.getPosition().x(), particle.getPosition().y()));
        velocityLabel.setText(String.format("Velocity: (%.2f, %.2f)", particle.getVelocity().x(), particle.getVelocity().y()));
    }

    @FXML
    private void onBackClicked() {
        if (sceneManager != null) {
            sceneManager.showSimulationView();
        }
    }
}
