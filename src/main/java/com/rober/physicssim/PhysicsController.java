package com.rober.physicssim;

import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;

import java.util.Map;

public class PhysicsController {

    @FXML private AnchorPane root;
    @FXML private Pane simPane;

    @FXML private Label timeLabel;
    @FXML private Label posLabel;
    @FXML private Label velLabel;
    @FXML private Label accLabel;
    @FXML private Label forceLabel;


    private  AxesPlane plane;
    private  Map<Particle, Circle> particleViews;
    private  double SCALE;
    private  double screenHeight;
    private AnimationTimer timer;
    private long lastUpdate;

    private boolean paused = false;
    private double timeScale = 1.0;
    private static final double MAX_FRAME_DT = 1.0 / 30.0;

    private Map<Particle, Polyline> trails;
    final int MAX_POINTS = 800;

    // TD: declare trail, add to controller, update in func


    public void init(AxesPlane plane, Map<Particle, Circle> particleViews, Map<Particle, Polyline> trails, double screenHeight) {
        this.plane = plane;
        this.particleViews = particleViews;
        this.screenHeight = screenHeight;
        this.SCALE = screenHeight / plane.getHeight();
        this.trails = trails;

        for (Circle c : particleViews.values()) {
            simPane.getChildren().add(c);
        }
    }

    public Pane getSimPane() {
        return simPane;
    }

    public void pause() {
        paused = true;
    }
    public void resume() {
        paused = false;
    }
    public void togglePause() {
        paused = !paused;
    }

    public void setTimeScale(double timeScale) {
        this.timeScale = timeScale;
    }

    public void slowDown() { timeScale *= 0.5; }
    public void speedUp()  { timeScale *= 2.0; }
    public void resetSpeed() { timeScale = 1.0; }

    public void step(double dt) {
        plane.update(dt);
        updateGraphics();
    }


    private void updateGraphics() {
        for (Particle p : plane.getParticles()){
            Circle c = particleViews.get(p);
            c.setCenterX(p.getX() * SCALE);
            c.setCenterY(screenHeight - p.getY() * SCALE);

            Polyline trail = trails.get(p);
            trail.getPoints().addAll(
                    p.getX() * SCALE,
                    screenHeight - p.getY() * SCALE
            );
            //p.printPosition();
            ObservableList<Double> points = trail.getPoints();
            if (points.size() > MAX_POINTS) { points.remove(0,2);}
        }


    }

    private void updateInfo() {
        if (plane.getParticles().isEmpty()) {
            return;
        }

        Particle p = plane.getParticles().get(0);

        timeLabel.setText(String.format("Time Scale: %.2fx", timeScale));
        posLabel.setText(String.format("Pos: (%.2f, %.2f)", p.getX(), p.getY()));
        velLabel.setText(String.format("Vel: %.2f m/s @ %.1f°", p.getSpeed(), p.getVAngle()));
        accLabel.setText(String.format("Acc: %.2f m/s/s @ %.2f°", p.getAScalar(), p.getAAngle()));

        double fx = p.lastFx;
        double fy = p.lastFy;
        double mag = Math.sqrt(fx*fx + fy*fy);
        double ang = Math.toDegrees(Math.atan2(fy, fx));

        forceLabel.setText(String.format("Force: %.2f N @ %.1f°", mag, ang));
    }

    public void start() {
        if (timer != null) return;

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (lastUpdate > 0 && !paused) {

                    //System.out.println(lastUpdate);

                    double dt = (now - lastUpdate) / 1e9;
                    dt = dt * timeScale;
                    dt = Math.max(-MAX_FRAME_DT, Math.min(MAX_FRAME_DT, dt));

                    //System.out.println(dt);

                    plane.update(dt);
                    updateGraphics();
                    updateInfo();
                }
                lastUpdate = now;
            }
        };
        timer.start();
    }

    public void stop() {
        if (timer != null) {
            timer.stop();
            timer = null;
        }
    }

    public void resetTime() {
        lastUpdate = 0;
    }
}
