package fyzzbox.physicsapp.controller;

public class TimeController {
    private boolean paused;
    private double timeScale = 1.0;

    public boolean isPaused() {
        return paused;
    }

    public void togglePause() {
        paused = !paused;
    }

    public double getTimeScale() {
        return timeScale;
    }

    public void setTimeScale(double timeScale) {
        this.timeScale = Math.max(0.0, timeScale);
    }

    public double toSimulationDelta(double realDeltaSeconds) {
        return paused ? 0.0 : realDeltaSeconds * timeScale;
    }
}
