package treble.demo.physicssim;

public class Launcher {
    static void main(String[] args) {
        double scrWidth = 1920;
        double scrHeight = 1080;
        double simWidth = 192;
        double simHeight = 108;

        String[] params = {
                String.valueOf(scrWidth),
                String.valueOf(scrHeight),
                String.valueOf(simWidth),
                String.valueOf(simHeight)
        };
        PhysicsApp.launchApp(params);
    }
}
