package fyzzbox.physicsapp.model.core;

import fyzzbox.physicsapp.model.core.rigidbodies.Body;
import fyzzbox.physicsapp.model.core.rules.RuleConfig;
import fyzzbox.physicsapp.model.world.EnvSettings;

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
