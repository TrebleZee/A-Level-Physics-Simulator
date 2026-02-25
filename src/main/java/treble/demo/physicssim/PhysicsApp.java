package treble.demo.physicssim;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PhysicsApp extends Application {

    private AxesPlane plane;
    private Map<Particle, Circle> particleViews = new HashMap<>();
    private Map<Particle, Polyline> particleTrails = new HashMap<>();
    private double SCALE;
    //private List<Polyline> trails = new ArrayList<>();


    private static String[] launchParams;

    public static void launchApp(String[] args) {
        launchParams = args;
        launch(args);
    }


    @Override
    public void start(Stage stage) throws IOException {

        double scrWidth = Double.parseDouble(launchParams[0]);
        double scrHeight = Double.parseDouble(launchParams[1]);
        double simWidth = Double.parseDouble(launchParams[2]);
        double simHeight = Double.parseDouble(launchParams[3]);

        plane = new AxesPlane(simWidth, simHeight);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("physics_view.fxml"));
        Parent root = loader.load();

        PhysicsController controller = loader.getController();
        controller.init(plane, particleViews, particleTrails, scrHeight);

        Pane simPane = controller.getSimPane();

        SCALE = scrHeight / simHeight;

        Scene scene = new Scene(root, scrWidth, scrHeight, Color.BLACK);


        // --v-- Add Particles here --v--


        Celestial p2 = new Celestial(7000, 10000, 0, 6600, 8e16, 200);
        Celestial p1 = new Celestial(13000, 10000, 0, -6600, 8e16, 200);
       // Celestial p3 = new Celestial(14000, 10000, 0.0, -18000, 8e13, 200);

        plane.addParticle(p1);
        plane.addParticle(p2);
        //plane.addParticle(p3);



        // --^-----------------------^--


        for (Particle p : plane.getParticles()) {
            double r = p.getRadius();
            Circle c = new Circle(r * SCALE);
            c.setFill(Color.RED);
            particleViews.put(p, c);

            Polyline trail = new Polyline();
            trail.setStroke(Color.RED);
            trail.setStrokeWidth(1);
            trail.setOpacity(0.6);
            particleTrails.put(p, trail);

            simPane.getChildren().add(trail);
            simPane.getChildren().add(c);
        }

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case SPACE -> controller.togglePause();
                case COMMA -> controller.slowDown();    // <
                case PERIOD -> controller.speedUp();    // >
                case SLASH -> controller.resetSpeed();  // ?
                case RIGHT -> controller.step(1.0 / 60.0); // → single frame
                case LEFT -> controller.step(-1.0 / 60.0);
            }
        });


//        System.out.println("Particles in plane: " + plane.getParticles().size());
//        System.out.println("Circles in root: " + simPane.getChildren().size());

        stage.setTitle("PhysicsApp");
        stage.setScene(scene);
        stage.show();



        controller.start();


    }
}
