package in.mohammadfaizan.mods.permanentdamage;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PermanentDamage implements ModInitializer {
	public static final String MOD_ID = "permanentdamage";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Permanent Damage Mod");

		ServerTickEvents.START_SERVER_TICK.register(server -> {
			for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
				if (player.hasStatusEffect(StatusEffects.REGENERATION)) {
					player.removeStatusEffect(StatusEffects.REGENERATION);
				}
				server.getGameRules().get(GameRules.NATURAL_REGENERATION).set(false, server);
			}
		});
	}
}