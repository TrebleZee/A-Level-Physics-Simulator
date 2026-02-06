module com.rober.physicssim {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires com.almasb.fxgl.all;

    opens com.rober.physicssim to javafx.fxml;
    exports com.rober.physicssim;
}