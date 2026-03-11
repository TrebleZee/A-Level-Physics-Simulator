package fyzzbox.physicsapp.util;

public final class UnitConverter {
    private UnitConverter() {
    }

    public static double metersToPixels(double meters, double metersPerPixel) {
        if (metersPerPixel == 0.0) {
            throw new IllegalArgumentException("metersPerPixel must not be zero.");
        }
        return meters / metersPerPixel;
    }

    public static double pixelsToMeters(double pixels, double metersPerPixel) {
        return pixels * metersPerPixel;
    }
}
