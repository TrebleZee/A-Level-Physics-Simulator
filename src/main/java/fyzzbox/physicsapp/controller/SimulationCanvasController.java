package fyzzbox.physicsapp.controller;

import fyzzbox.physicsapp.app.SceneManager;
import fyzzbox.physicsapp.view.EntityRenderer;
import fyzzbox.physicsapp.view.RenderSnapshot;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SimulationCanvasController {
    @FXML private AnchorPane canvasContainer;
    @FXML private Slider timeScale;
    @FXML private TextField timeScaleField;

    private EntityRenderer renderer;
    private final TimeController timeController = new TimeController();
    private SceneManager sceneManager;

    @FXML
    private void initialize() {
        initialise();
        if (timeScale != null) {
            timeScale.valueProperty().addListener((observable, oldValue, newValue) -> {
                timeController.setTimeScale(newValue.doubleValue());
                if (timeScaleField != null) {
                    timeScaleField.setText(String.format("%.2f", newValue.doubleValue()));
                }
            });
        }
    }

    public void initialise() {
        renderer = new EntityRenderer();
    }

    public void onModelUpdate(RenderSnapshot snap) {
        if (renderer != null) {
            renderer.render(snap);
        }
    }

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    private void onTimeScaleReleased() {
        if (timeScale != null) {
            timeController.setTimeScale(timeScale.getValue());
        }
    }

    @FXML
    private void onTimeScaleSubmitted() {
        if (timeScaleField == null || timeScale == null) {
            return;
        }
        try {
            double value = Double.parseDouble(timeScaleField.getText());
            if (!Double.isFinite(value)) {
                throw new NumberFormatException();
            }
            timeScale.setValue(value);
        } catch (NumberFormatException ignored) {
            timeScaleField.setText(String.format("%.2f", timeScale.getValue()));
        }
    }

    @FXML private void onResetClicked() { }
    @FXML private void onRewindClicked() { }
    @FXML private void onStepBackClicked() { }
    @FXML private void onPlayPauseClicked() { timeController.togglePause(); }
    @FXML private void onStepClicked() { }
    @FXML private void onStartSimulationClicked() { }
    @FXML private void onNewClicked() { }
    @FXML private void onSaveClicked() { }
    @FXML private void onUndoClicked() { }
    @FXML private void onRedoClicked() { }
    @FXML private void onAboutClicked() { }

    @FXML
    private void onLoadClicked() {
        if (sceneManager != null) {
            sceneManager.showSavedScenariosView();
        }
    }

    @FXML
    private void onSettingsClicked() {
        if (sceneManager != null) {
            sceneManager.showSettingsWindow();
        }
    }

    @FXML
    private void onExitClicked() {
        if (sceneManager != null) {
            sceneManager.showMainMenuView();
        }
    }
}
