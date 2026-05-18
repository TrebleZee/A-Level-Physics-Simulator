package fyzzbox.physicsapp.model.core;

import java.util.Deque;

public class RewindBuffer {
    private Deque<SimulationState> buffer;
    private int maxCapacity;

    public void push(SimulationState s) {
    }

    public SimulationState pop() {
        return null;
    }

    public boolean isFull() {
        return false;
    }
}
