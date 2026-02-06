package com.rober.physicssim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AxesPlane {
    private final List<Particle> particles  =  new ArrayList<>();

    final double width;
    final double height;

    private double globalEx = 0.0;
    private double globalEy = 0.0;
    private boolean enableEField = false;

    private double globalGravity = -9.81;
    private boolean enableGravity = false;

    private double globalAirDensity = 0.0;
    private boolean enableAirResistance = false;

    private double globalViscosity = 0.0;
    private boolean enableViscousDrag = false;

    private double wallElasticity = 0.98;

    // Constructor
    public AxesPlane(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // ---Getters---

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }



    // ---Particle management---

    public void addParticle(Particle p) {
        if (p != null) particles.add(p);
    }

    public boolean removeParticle(Particle p) {
        return particles.remove(p);
    }

    public void clearParticles() {
        particles.clear();
    }

    public List<Particle> getParticles() {
        return Collections.unmodifiableList(particles);
    }


    // ---Global field setters---

    public void setGlobalEField(double Ex,  double Ey) {
        this.globalEx = Ex;
        this.globalEy = Ey;
        this.enableEField = true;
    }

    public void toggleEField() {
        this.enableEField = !enableEField;
    }

    public void setGlobalGravity(double gravity) {
        this.globalGravity = gravity;
        this.enableGravity = true;
    }

    public void toggleGravity() {
       this.enableGravity = !enableGravity;
    }

    public void setGlobalAirDensity(double airDensity) {
        this.globalAirDensity = airDensity;
        this.enableAirResistance = true;
    }

    public void toggleAirResistance() {
        this.enableAirResistance = !enableAirResistance;
    }

    public void setGlobalViscosity(double viscosity) {
        this.globalViscosity = viscosity;
        this.enableViscousDrag = true;
    }

    public void setWallElasticity(double e) {
        this.wallElasticity = Math.max(0, Math.min(1, e));
    }

    // ---Particle interactions---

//    public void checkDead() {
//        for (Particle p : particles) {
//            double vx = p.getVx();
//            double vy = p.getVy();
//            double ax = p.getAx();
//            double ay = p.getAy();
//            double fx =  p.getFx();
//            double fy =  p.getFy();
//            int count = 0;
//            double[] motion = new double[] {vx, vy, ax, ay, fx, fy};
//            for (double d : motion) {
//                if (d < 0.0001) { count++; }
//            }
//            if (count == 6) { p.reset(Particle.ResetType.MOTION); }
//        }
//    }

    // Particle and wall collisions
    public void handleWallCollisions(Particle p) {
        double radius = p.getRadius();
        double X = p.getX();
        double Y = p.getY();
        double Vx = p.getVx();
        double Vy = p.getVy();
        double pElast = p.getElasticity();
        double coeRest = pElast * wallElasticity;

        // -Update Pos and Vel-
        // Right wall
        if (X + radius > width) {
            X = width -  radius;
            Vx = -Vx * coeRest;
        }

        // Left wall
        if (X - radius < 0) {
            X = radius;
            Vx = -Vx * coeRest;
        }

        // Ceiling
        if (Y + radius > height) {
            Y = height -  radius;
            Vy = -Vy * coeRest;
        }

        // Floor
        if (Y - radius < 0) {
            Y = radius;
            Vy = -Vy * coeRest;
        }

        // Set new Pos and Vel
        p.setPosition(X, Y);
        p.setVelocity(Vx, Vy);
    }

    // Particle and particle collisions
    private void handleParticleCollisions() {
        int n = particles.size();
        for (int i = 0; i < n; i++) {
            Particle a = particles.get(i);
            for (int j = i + 1; j < n; j++) {
                Particle b = particles.get(j);

                double dx = b.getX() - a.getX();
                double dy = b.getY() - a.getY();
                double dist = Math.sqrt(dx * dx + dy * dy);

                double radiusA = a.getRadius();
                double radiusB = b.getRadius();
                double minDist = radiusA + radiusB;

                // If colliding
                if (dist < minDist && dist > 0) {
                    // -1. Separate them slightly to avoid sticking-
                    double overlap = 0.5 * (minDist - dist);
                    double nx = dx / dist;
                    double ny = dy / dist;
                    a.setPosition(a.getX() - overlap * nx, a.getY() - overlap * ny);
                    b.setPosition(b.getX() + overlap * nx, b.getY() + overlap * ny);

                    // -2. Compute new velocities using 1D elastic collision formula along normal-
                    double vxA = a.getVx();
                    double vyA = a.getVy();
                    double vxB = b.getVx();
                    double vyB = b.getVy();

                    // Normal velocity components
                    double va = vxA * nx + vyA * ny;
                    double vb = vxB * nx + vyB * ny;

                    double ma = a.getMass();
                    double mb = b.getMass();

                    // Compute effective elasticity (average of both particles)
                    double e = 0.5 * (a.getElasticity() + b.getElasticity());

                    // Relative normal velocity before collision
                    double vRel = vb - va;

                    // Apply restitution (elasticity)
                    double rest = -(1 + e) * vRel / (1 / ma + 1 / mb);

                    // Apply impulses
                    double impulseX = rest * nx;
                    double impulseY = rest * ny;

                    a.setVelocity(vxA - impulseX / ma, vyA - impulseY / ma);
                    b.setVelocity(vxB + impulseX / mb, vyB + impulseY / mb);
                }
            }
        }
    }

    public void handleLocalGravity() {
        final double G = 6.674e-6;
        int n = particles.size();

        for (int i = 0; i < n; i++) {
            Particle a = particles.get(i);

            for (int j = i + 1; j < n; j++) {
                Particle b = particles.get(j);

                if (a instanceof Celestial && b instanceof Celestial) {
                    double ma = a.getMass();
                    double mb = b.getMass();

                    double dx = b.getX() - a.getX();
                    double dy = b.getY() - a.getY();
                    double dist = Math.sqrt(dx * dx + dy * dy);

                    long F = (long) (G * (ma * mb) / (dist * dist));

                    double degrees = Math.toDegrees(Math.asin(dy / dist));
                    double aa = (dx >= 0) ? degrees : 180 - degrees;
                    double ab = aa - 180;

                    a.applyForce(new double[]{F, aa});
                    b.applyForce(new double[]{F, ab});
                    //System.out.println("g force: " + F + " angle: " + aa);
                } else { return; }
            }
        }
    }


    // ---Environment Main Update---
    public void update(double dt) {
        // Apply force of gravitational attraction between masses
        handleLocalGravity();

        for (Particle p : particles) {
            // Apply global gravity
            if (enableGravity) {
                double fy = p.getMass() * globalGravity;
                p.applyForce(0.0, fy);
                //System.out.println("applied gravity " + fy);
            }

            // Apply electric field to charged particles
            if (enableEField && p instanceof ChargedParticle) {
                ChargedParticle cp = (ChargedParticle) p;
                double q = cp.getCharge();
                double fx = q * globalEx;
                double fy = q * globalEy;
                p.applyForce(fx, fy);
                //System.out.println("applied charge " + fx + " " + fy);
            }

            // Apply air resistance
            if (enableAirResistance) {
                double Area = Math.pow(p.getRadius(), 2) * Math.PI;
                double vx = p.getVx();
                double vy = p.getVy();
                double Cd = 0.3;
                double fx = Math.max(0.0001, 0.5 * globalAirDensity * Math.pow(vx, 2) * Cd * Area);
                double fy = Math.max(0.0001, 0.5 * globalAirDensity * Math.pow(vy, 2) * Cd * Area);
                fx = (vx >= 0) ? -fx : fx;
                fy = (vy >= 0) ? -fx : fy;
                p.applyForce(fx, fy);
                //System.out.println("applied air resistance " + fx + " " + fy);

            }

            if (enableViscousDrag) {
                double r = p.getRadius();
                double vx = p.getVx();
                double vy = p.getVy();
                double n = globalViscosity;
                double fx = (vx > 0) ? Math.max(0.0001, 6 * Math.PI * r * n * vx) : 0;
                double fy = (vy > 0) ? Math.max(0.0001, 6 * Math.PI * r * n * vy) : 0;
                p.applyForce(-fx, -fy);
            }



            // Move based on global forces
            p.move(dt);

            // Bounce off walls
            handleWallCollisions(p);
        }


        // Particle collisions last
        handleParticleCollisions();

        // Check if any particles have negligible velocity
        //checkDead();


    }
}
