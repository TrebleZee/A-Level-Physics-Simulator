package fyzzbox.physicsapp.controller;

import fyzzbox.physicsapp.app.SceneManager;
import fyzzbox.physicsapp.model.world.PhysicsWorld;
import fyzzbox.physicsapp.util.TimeController;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class SimulationController {
    @FXML
    private Pane simulationPane;

    private final TimeController timeController = new TimeController();
    private SceneManager sceneManager;
    private PhysicsWorld world;

    @FXML
    private void initialize() {
        // Placeholder for animation timer and view initialization.
    }

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public void setWorld(PhysicsWorld world) {
        this.world = world;
    }

    public Pane getSimulationPane() {
        return simulationPane;
    }

    public TimeController getTimeController() {
        return timeController;
    }

    public PhysicsWorld getWorld() {
        return world;
    }

    @FXML
    private void onBackClicked() {
        if (sceneManager != null) {
            sceneManager.showStartView();
        }
    }

    @FXML
    private void onInspectorClicked() {
        if (sceneManager != null) {
            sceneManager.showInspectorView();
        }
    }
}
