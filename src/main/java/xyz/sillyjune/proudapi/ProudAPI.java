package xyz.sillyjune.proudapi;

import net.fabricmc.api.ModInitializer;
import xyz.sillyjune.proudapi.api.Flag;

import static xyz.sillyjune.proudapi.api.Util.createFlag;

public class ProudAPI implements ModInitializer {
    /**
     * Runs the mod initializer.
     */

    public static final Flag TEST_FLAG = createFlag("test", false);
    @Override
    public void onInitialize() {

    }
}
