module com.rober.physicssim {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires com.almasb.fxgl.all;

    opens treble.demo.physicssim to javafx.fxml;
    opens fyzzbox.physicsapp.controller to javafx.fxml;
    opens fyzzbox.physicsapp.view to javafx.fxml;

    exports treble.demo.physicssim;
    exports fyzzbox.physicsapp.app;
    exports fyzzbox.physicsapp.controller;
    exports fyzzbox.physicsapp.model.core;
    exports fyzzbox.physicsapp.model.scenarios;
    exports fyzzbox.physicsapp.model.world;
    exports fyzzbox.physicsapp.util;
    exports fyzzbox.physicsapp.view;
}
