package fyzzbox.physicsapp.controller;

import fyzzbox.physicsapp.model.world.Environment;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SettingsWindowController {
    @FXML private Label sectionTitle;

    private Environment env;
    private Stage settingsStage;

    public void setSettingsStage(Stage settingsStage) {
        this.settingsStage = settingsStage;
    }

    public void update() {
    }

    public void onSettingChanged(String key, Object val) {
    }

    @FXML private void onGeneralTabClicked() { showSection("General Settings"); }
    @FXML private void onDisplayTabClicked() { showSection("Display Settings"); }
    @FXML private void onSimulationTabClicked() { showSection("Simulation Settings"); }
    @FXML private void onControlsTabClicked() { showSection("Controls"); }
    @FXML private void onApplyClicked() { }
    @FXML private void onSaveClicked() { closeWindow(); }
    @FXML private void onCancelClicked() { closeWindow(); }

    private void showSection(String title) {
        if (sectionTitle != null) {
            sectionTitle.setText(title);
        }
    }

    private void closeWindow() {
        if (settingsStage != null) {
            settingsStage.close();
        }
    }
}
