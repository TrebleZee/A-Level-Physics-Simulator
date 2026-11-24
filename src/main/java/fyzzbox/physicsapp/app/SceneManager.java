package fyzzbox.physicsapp.app;

import fyzzbox.physicsapp.controller.MenuController;
import fyzzbox.physicsapp.controller.ScenarioListController;
import fyzzbox.physicsapp.controller.SettingsWindowController;
import fyzzbox.physicsapp.controller.SimulationCanvasController;
import fyzzbox.physicsapp.controller.StartController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
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
        showView("/fyzzbox/physicsapp/view/fxml/dark/start_view.fxml");
        stage.setTitle("Physics Sim - Start");
    }

    public void showMainMenuView() {
        showView("/fyzzbox/physicsapp/view/fxml/dark/menu_view.fxml");
        stage.setTitle("Physics Sim - Main Menu");
    }

    public void showSavedScenariosView() {
        showView("/fyzzbox/physicsapp/view/fxml/dark/saved_scenario_dark.fxml");
        stage.setTitle("Physics Sim - Saved Scenarios");
    }

    public void showSimulationView() {
        showView("/fyzzbox/physicsapp/view/fxml/dark/sim_view.fxml");
        stage.setTitle("Physics Sim - Simulation");
    }

    public void showSettingsWindow() {
        String fxmlPath = "/fyzzbox/physicsapp/view/fxml/dark/settings-window.fxml";
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            SettingsWindowController controller = loader.getController();

            Stage settingsStage = new Stage();
            settingsStage.initOwner(stage);
            settingsStage.initModality(Modality.WINDOW_MODAL);
            settingsStage.setTitle("Physics Sim - Settings");
            settingsStage.setScene(new Scene(root));
            controller.setSettingsStage(settingsStage);
            settingsStage.show();
        } catch (IOException e) {
            throw new IllegalStateException("Could not load FXML: " + fxmlPath, e);
        }
    }

    public void exitApplication() {
        stage.close();
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
        if (controller instanceof MenuController menuController) {
            menuController.setSceneManager(this);
            return;
        }
        if (controller instanceof ScenarioListController scenarioListController) {
            scenarioListController.setSceneManager(this);
            return;
        }
        if (controller instanceof SimulationCanvasController simulationCanvasController) {
            simulationCanvasController.setSceneManager(this);
        }
    }
}
