package treble.demo.physicssim;

public class ChargedParticle extends Particle {
    private double charge;
    private double Ex;
    private double Ey;

    public ChargedParticle(double x, double y, double vx, double vy, double mass, double radius, double charge) {
        super(x, y, vx, vy, mass, radius);
        this.charge = charge;

    }

    public void setField(double Ex, double Ey) {
        this.Ex = Ex;
        this.Ey = Ey;
    }

    public double getCharge() { return charge; }

    @Override
    public void move(double dt) {
        // Apply electric force before movement
        double Fx = charge * Ex;
        double Fy = charge * Ey;
        applyForce(Fx, Fy);

        super.move(dt);

    }

    @Override
    public void printPosition() {
        System.out.printf("ChargedParticle at (%.2f, %.2f), charge: %.2e C%n", x, y, charge);
    }
}
