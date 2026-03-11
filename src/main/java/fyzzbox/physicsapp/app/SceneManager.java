package fyzzbox.physicsapp.app;

import fyzzbox.physicsapp.controller.InspectorController;
import fyzzbox.physicsapp.controller.SimulationController;
import fyzzbox.physicsapp.controller.StartController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private static final double DEFAULT_WIDTH = 1200;
    private static final double DEFAULT_HEIGHT = 800;

    private final Stage stage;

    public SceneManager(Stage stage) {
        this.stage = stage;
    }

    public void showStartView() {
        showView("/fyzzbox/physicsapp/view/fxml/start_view.fxml");
        stage.setTitle("Physics Sim - Start");
    }

    public void showSimulationView() {
        showView("/fyzzbox/physicsapp/view/fxml/sim_view.fxml");
        stage.setTitle("Physics Sim - Simulation");
    }

    public void showInspectorView() {
        showView("/fyzzbox/physicsapp/view/fxml/inspector_view.fxml");
        stage.setTitle("Physics Sim - Inspector");
    }

    private void showView(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            wireController(loader.getController());

            Scene scene = new Scene(root, DEFAULT_WIDTH, DEFAULT_HEIGHT);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new IllegalStateException("Could not load FXML: " + fxmlPath, e);
        }
    }

    private void wireController(Object controller) {
        if (controller instanceof StartController startController) {
            startController.setSceneManager(this);
            return;
        }
        if (controller instanceof SimulationController simulationController) {
            simulationController.setSceneManager(this);
            return;
        }
        if (controller instanceof InspectorController inspectorController) {
            inspectorController.setSceneManager(this);
        }
    }
}
