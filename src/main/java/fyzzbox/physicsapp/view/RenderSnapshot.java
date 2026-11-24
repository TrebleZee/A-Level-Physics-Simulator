package fyzzbox.physicsapp.view;

import java.util.List;

public final class RenderSnapshot {
    private final List<BodyRenderData> bodies;

    public RenderSnapshot(List<BodyRenderData> bodies) {
        this.bodies = List.copyOf(bodies);
    }

    public List<BodyRenderData> getBodies() {
        return bodies;
    }
}
