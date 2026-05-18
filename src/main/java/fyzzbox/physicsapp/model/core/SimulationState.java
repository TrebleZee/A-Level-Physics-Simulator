package fyzzbox.physicsapp.model.core;

import java.util.List;

public class SimulationState {
    private List<Body> entities;
    private EnvSettings settings;
    private List<RuleConfig> ruleConfigs;

    public String toJSON() {
        return null;
    }

    public void fromJSON(String json) {
    }

    public List<Body> getEntities() {
        return null;
    }
}
