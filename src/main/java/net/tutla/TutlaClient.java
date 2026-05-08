package net.tutla;

import io.github.itzispyder.improperui.ImproperUIAPI;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutlaClient implements ModInitializer {
	public static final String MOD_ID = "tutlaclient";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ImproperUIAPI.init("tutlaclient", TutlaClient.class,
                "assets/tutlaclient/improperui/menu.ui"
        );
	}
}