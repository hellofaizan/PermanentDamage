package in.mohammadfaizan.mods.permanentdamage;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PermanentDamageClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(PermanentDamage.MOD_ID + "-client");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Permanent Damage Client");
        // Client-side initialization - heart textures are loaded automatically
        // from the resources folder if placed correctly
    }
}