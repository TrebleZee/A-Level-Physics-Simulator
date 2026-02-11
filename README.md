# A-Level Physics Simulator

An interactive JavaFX simulation tool designed to support **secondary school science learning** by making abstract mechanics concepts visual, testable, and discussion-friendly.

## Project scope and goals

### Educational scope
This project targets learners in a secondary school setting (including A-Level / upper secondary classes) and supports teachers with a visual demonstration environment for core physics ideas.

### Core goals
- Turn difficult-to-visualise concepts (motion, force, acceleration, and orbit-like interactions) into visible behaviour.
- Encourage inquiry-based learning: students can ask "what happens if…" and immediately test ideas.
- Bridge maths and physics by showing numeric values (position, velocity, acceleration, force) alongside motion.
- Provide a classroom-friendly simulation loop with pause, speed control, and step-by-step updates.

### Current functional scope
The current implementation includes:
- A 2D simulation plane with particles/celestial bodies.
- Real-time rendering of moving bodies and their trails.
- Keyboard controls for pausing, slowing/speeding time, resetting speed, and frame stepping.
- Live info panel values for selected particle state.

## Use case guide (secondary school)

## 1) Teacher-led demonstration: "What is orbit-like motion?"
**Lesson objective:** Connect force and velocity direction to curved trajectories.

Suggested flow:
1. Run the app with default bodies.
2. Ask students to predict the path before unpausing.
3. Use **Space** to pause at key moments and discuss vectors.
4. Use **,** and **.** to slow down/speed up time so students can observe changes.
5. Use **Right Arrow** to advance frame-by-frame while discussing the force readout.

**Discussion prompts:**
- Why does the object keep changing direction?
- Is speed constant while velocity changes?
- How does the force direction compare with path curvature?

## 2) Student inquiry activity: "Cause and effect in motion"
**Lesson objective:** Build scientific reasoning from observation.

Students can:
- Observe trails as evidence of past motion.
- Compare acceleration and force outputs over time.
- Form hypotheses (e.g., "higher mass means less acceleration under same force") and test by editing initial conditions in `PhysicsApp.java`.

## 3) Assessment support
Use the simulator as a quick formative assessment:
- Pause and ask students to estimate direction of velocity/force.
- Step one frame and verify against displayed values.
- Ask for short written explanations linking equations to the simulation.

## Controls
- **Space**: Pause / Resume
- **,**: Slow down simulation time (×0.5)
- **.**: Speed up simulation time (×2)
- **/**: Reset speed to 1×
- **Right Arrow**: Step forward one frame
- **Left Arrow**: Step backward one frame

## Setup instructions

## Prerequisites
- **JDK 25** (project is configured with source/target 25 in Maven).
- **Maven** installed locally (`mvn`).

## 1) Clone repository
```bash
git clone <your-repo-url>
cd A-Level-Physics-Simulator
```

## 2) Build the project
```bash
mvn clean compile
```

## 3) Run the simulator
```bash
mvn javafx:run
```

## 4) Adjust simulation scenario (optional)
To create custom classroom scenarios, edit particle initial values in:
- `src/main/java/com/rober/physicssim/PhysicsApp.java`

For example, you can change:
- initial positions (`x`, `y`)
- initial velocities (`vx`, `vy`)
- mass and radius

Then rebuild/run to test the new setup.

## Suggested classroom implementation
- Start with a 5-minute demonstration.
- Move into pair-based prediction tasks.
- Use frame-step mode for whole-class reasoning.
- End with an "explain the motion" reflection using displayed physics quantities.

## Roadmap ideas
Potential improvements that align with the educational goal:
- UI controls for adding/changing particles without editing code.
- Preset scenarios (projectile motion, circular motion, gravitational systems).
- Data export for graphing (position-time, velocity-time).
- Guided worksheets integrated with simulator tasks.

## Contributing
Contributions that improve pedagogy, usability, or scientific accuracy are welcome. Please open an issue describing:
- the educational need,
- the proposed change,
- and how it can be validated in classroom use.
