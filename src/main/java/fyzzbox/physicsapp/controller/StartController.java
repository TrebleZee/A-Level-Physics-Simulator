package fyzzbox.physicsapp.controller;

import fyzzbox.physicsapp.app.SceneManager;
import javafx.fxml.FXML;

public class StartController {
    private SceneManager sceneManager;

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    private void onStartClicked() {
        if (sceneManager != null) {
            sceneManager.showSimulationView();
        }
    }
}
