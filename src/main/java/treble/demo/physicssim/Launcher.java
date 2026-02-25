package treble.demo.physicssim;

public class Launcher {
    static void main(String[] args) {
        double scrWidth = 1000;
        double scrHeight = 1000;
        double simWidth = 20000;
        double simHeight = 20000;

        String[] params = {
                String.valueOf(scrWidth),
                String.valueOf(scrHeight),
                String.valueOf(simWidth),
                String.valueOf(simHeight)
        };
        PhysicsApp.launchApp(params);
    }
}
