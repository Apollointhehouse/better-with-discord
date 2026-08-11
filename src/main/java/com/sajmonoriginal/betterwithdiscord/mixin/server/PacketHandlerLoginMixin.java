package com.sajmonoriginal.betterwithdiscord.mixin.server;

import com.llamalad7.mixinextras.sugar.Local;
import com.sajmonoriginal.betterwithdiscord.server.DiscordChatRelay;
import net.minecraft.core.net.packet.PacketLogin;
import net.minecraft.server.entity.player.PlayerServer;
import net.minecraft.server.net.handler.PacketHandlerLogin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PacketHandlerLogin.class, remap = false)
public class PacketHandlerLoginMixin {
    @Inject(
            method = "doLogin",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/net/PlayerList;sendPacketToAllPlayers(Lnet/minecraft/core/net/packet/Packet;)V",
                    shift = At.Shift.BEFORE,
                    ordinal = 0
            )
    )
    void sendJoinMessage(PacketLogin packetLogin, CallbackInfo ci, @Local(name = "player") PlayerServer player) {
        String username = player.username;
        DiscordChatRelay.sendJoinLeaveMessage(username, true);
    }
}
