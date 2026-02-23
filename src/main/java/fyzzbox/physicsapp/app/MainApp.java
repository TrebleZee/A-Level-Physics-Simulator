package fyzzbox.physicsapp.app;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        SceneManager sceneManager = new SceneManager(stage);
        sceneManager.showStartView();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
