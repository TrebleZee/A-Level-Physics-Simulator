package fyzzbox.physicsapp.controller;

import fyzzbox.physicsapp.app.SceneManager;
import javafx.fxml.FXML;

public class MenuController {
    private SceneManager sceneManager;

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    private void onLoadSavedClicked() {
        if (sceneManager != null) {
            sceneManager.showSavedScenariosView();
        }
    }

    @FXML
    private void onStartNewClicked() {
        if (sceneManager != null) {
            sceneManager.showSimulationView();
        }
    }

    @FXML
    private void onSettingsClicked() {
        if (sceneManager != null) {
            sceneManager.showSettingsWindow();
        }
    }

    @FXML
    private void onBackClicked() {
        if (sceneManager != null) {
            sceneManager.showStartView();
        }
    }
}
