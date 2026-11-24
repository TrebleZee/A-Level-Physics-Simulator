package fyzzbox.physicsapp.controller;

import fyzzbox.physicsapp.view.BodyRenderData;
import fyzzbox.physicsapp.view.RenderSnapshot;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class InfoPanelController {
    @FXML private Label selectedName;
    @FXML private Label massLabel;
    @FXML private Label positionLabel;
    @FXML private Label velocityLabel;
    @FXML private VBox propertiesBox;

    private BodyRenderData selectedBody;

    public void update(RenderSnapshot snap) {
    }

    public void onBodySelected(BodyRenderData b) {
        selectedBody = b;
    }
}
