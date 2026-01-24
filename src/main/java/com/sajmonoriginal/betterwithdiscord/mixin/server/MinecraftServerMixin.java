package com.sajmonoriginal.betterwithdiscord.mixin.server;

import com.sajmonoriginal.betterwithdiscord.server.ConsoleAppender;
import com.sajmonoriginal.betterwithdiscord.server.DiscordChatRelay;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = MinecraftServer.class, remap = false)
public class MinecraftServerMixin {

    @Inject(
            method = "initiateShutdown",
            at = @At("HEAD")
    )
    public void sendStopMessage(CallbackInfo ci) {
        DiscordChatRelay.sendServerStoppedMessage();
        ConsoleAppender.unregister();
    }
}
