package com.sajmonoriginal.betterwithdiscord;

import com.sajmonoriginal.betterwithdiscord.server.DiscordChatRelay;
import com.sajmonoriginal.betterwithdiscord.server.DiscordClient;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterWithDiscordMod implements ModInitializer {
    public static final String MOD_ID = "better_with_discord";
    public static final Logger LOGGER = LoggerFactory.getLogger("Better With Discord");

    @Override
    public void onInitialize() {
        LOGGER.info("Better With Discord initializing!");
        new Thread(() -> {
            LOGGER.info("Starting Discord client...");
            if (DiscordClient.init()) {
                LOGGER.info("Discord client started successfully!");
                DiscordChatRelay.sendServerStartMessage();
            } else {
                LOGGER.warn("Discord client failed to start or is disabled.");
            }
        }).start();
        LOGGER.info("Better With Discord initialized!");
    }

    public static void info(String s) {
        LOGGER.info(s);
    }
}
