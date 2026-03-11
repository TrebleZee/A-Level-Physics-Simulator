package treble.demo.physicssim;

public class Launcher {
    static void main(String[] args) {
        double scrWidth = 1000;
        double scrHeight = 500;
        double simWidth = 100;
        double simHeight = 50;

        String[] params = {
                String.valueOf(scrWidth),
                String.valueOf(scrHeight),
                String.valueOf(simWidth),
                String.valueOf(simHeight)
        };
        PhysicsApp.launchApp(params);
    }
}
