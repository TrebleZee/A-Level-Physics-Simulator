module com.rober.physicssim {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires com.almasb.fxgl.all;

    opens com.rober.physicssim to javafx.fxml;
    opens fyzzbox.physicsapp.controller to javafx.fxml;

    exports com.rober.physicssim;
    exports fyzzbox.physicsapp.app;
    exports fyzzbox.physicsapp.controller;
    exports fyzzbox.physicsapp.model.core;
    exports fyzzbox.physicsapp.model.scenarios;
    exports fyzzbox.physicsapp.model.world;
    exports fyzzbox.physicsapp.util;
    exports fyzzbox.physicsapp.view.ui;
}
