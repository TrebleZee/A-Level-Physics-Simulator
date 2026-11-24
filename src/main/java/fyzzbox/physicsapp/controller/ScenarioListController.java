package fyzzbox.physicsapp.controller;

import fyzzbox.physicsapp.app.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ScenarioListController {
    @FXML private ListView<String> builtinList;
    @FXML private ListView<String> userList;

    private SceneManager sceneManager;

    @FXML
    private void initialize() {
        if (builtinList != null && builtinList.getItems().isEmpty()) {
            builtinList.getItems().add("Solar System");
        }
    }

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    private void onBackClicked() {
        if (sceneManager != null) {
            sceneManager.showMainMenuView();
        }
    }

    @FXML
    private void onOpenClicked() {
        boolean selected = builtinList.getSelectionModel().getSelectedItem() != null
                || userList.getSelectionModel().getSelectedItem() != null;
        if (selected && sceneManager != null) {
            sceneManager.showSimulationView();
        }
    }

    @FXML
    private void onEditClicked() {
        // Scenario editing is a planned advanced-mode feature.
    }

    @FXML
    private void onDeleteClicked() {
        String selected = userList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            userList.getItems().remove(selected);
        }
    }
}
