package us.danielpmc.ecotropolis.config;

import us.danielpmc.ecotropolis.Ecotropolis;

public class BanConfig extends Config {
    public BanConfig(Ecotropolis instance) {
        super(instance);
    }

    @Override
    public String getName() {
        return "banned";
    }
}
