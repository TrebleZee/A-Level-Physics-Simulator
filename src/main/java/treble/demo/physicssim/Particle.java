package treble.demo.physicssim;

public class Particle {

    protected double x, y;
    protected double vx, vy;
    protected double ax, ay;
    protected double fx, fy;
    protected double lastFx, lastFy;
    protected double mass, radius;
    protected double elasticity;

    // Enum to define what can be reset
    public enum ResetType {
        POSITION, VELOCITY, ACCELERATION, FORCE, MOTION, ALL
    }

    // Constructor
    public Particle(double x, double y, double vx, double vy, double mass, double radius) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.ax = 0;
        this.ay = 0;
        this.mass = mass;
        this.fx = 0;
        this.fy = 0;
        this.radius = radius;
        this.elasticity = 1;
    }



    // ---Physics methods---

    // Updates position based on an amount of time
    public void move(double dt) {
        // Calculate acceleration
        ax = fx / mass;
        ay = fy / mass;

        // update velocity
        vx += ax * dt;
        vy += ay * dt;

        // update position
        x += vx * dt;
        y += vy * dt;

        // Reset forces
        lastFx = fx;
        lastFy = fy;
        reset(ResetType.FORCE);
        //System.out.println(x + " " + y + " " + vx + " " + vy);
    }


    // Add an external force (accumulates)

    // Using x and y components
    public void applyForce(double fx, double fy) {
        this.fx += fx;
        this.fy += fy;
    }

    // Using direction and magnitude [force, angle]
    public void applyForce(double[] force) {
        this.fx += force[0] * Math.cos(Math.toRadians(force[1]));
        this.fy += force[0] * Math.sin(Math.toRadians(force[1]));
    }



    // ---Output methods---

    // Prints Pos, Vel
    public void printPosition() {
        System.out.printf("Particle at: (%.2f,%.2f) Velocity: (%.2f, %.2f)%n", x, y, vx, vy);
    }


    // ---Class methods---

    // Reset method using Enum
    public void reset(ResetType... resetTypes) {
        for (ResetType resetType : resetTypes) {
            switch (resetType) {
                case POSITION:
                   x = 0;
                   y = 0;
                   break;
                case VELOCITY:
                    vx = 0;
                    vy = 0;
                    break;
                case ACCELERATION:
                    ax = 0;
                    ay = 0;
                    break;
                case FORCE:
                    fx = 0;
                    fy = 0;
                    break;
                case MOTION:
                    vx = vy = ax =  ay = fx = fy = 0;
                    break;
                case ALL:
                    x = y = vx = vy = ax = ay = fx = fy = 0;
                    break;
            }
        }
    }


    // -Getters-

    public double getX() { return x; }
    public double getY() { return y; }
    public double getVx() { return vx; }
    public double getVy() { return vy; }
    public double getAx() { return ax; }
    public double getAy() { return ay; }
    public double getFx() { return fx; }
    public double getFy() { return fy; }
    public double getMass() { return mass; }
    public double getRadius() { return radius; }
    public double getElasticity() { return elasticity; }

    public double getAScalar() { return Math.sqrt(Math.pow(ax, 2) + Math.pow(ay, 2)); }

    public double getAAngle() { return Math.toDegrees(Math.atan2(ax, ay)); }

    public double getSpeed() {
        return Math.sqrt(Math.pow(vx, 2) + Math.pow(vy, 2));
    }

    public double getVAngle() {
        return Math.toDegrees(Math.atan2(vy, vx));
    }

    // Returns [speed (m/s), angle (degrees)]
    public double[] getVelocity() {
        double speed = getSpeed();
        double angle = getVAngle();
        return new double[]{speed, angle};
    }

    // -Setters-

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Sets velocity with direction and magnitude [speed, angle]
    public void setVelocity(double[] velocity) {
        this.vx = velocity[0] * Math.cos(Math.toRadians(velocity[1]));
        this.vy = velocity[0] * Math.sin(Math.toRadians(velocity[1]));
    }

    // Sets velocity using x and y components
    public void setVelocity(double vx, double vy) {
        this.vx = vx;
        this.vy = vy;
    }

    // Sets acceleration with x and y components
    public void setAcceleration(double ax, double ay) {
        this.ax = ax;
        this.ay = ay;
    }

    // Sets acceleration with direction and magnitude [change in speed, angle]
    public void setAcceleration(double[] acceleration) {
        this.ax = acceleration[0] * Math.cos(Math.toRadians(acceleration[1]));
        this.ay = acceleration[0] * Math.sin(Math.toRadians(acceleration[1]));
    }

    public void setElasticity(double elasticity) {
        this.elasticity = elasticity;
    }
}
