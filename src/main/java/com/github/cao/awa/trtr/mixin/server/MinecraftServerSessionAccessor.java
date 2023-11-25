package com.github.cao.awa.trtr.mixin.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.storage.LevelStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MinecraftServer.class)
public interface MinecraftServerSessionAccessor {
    @Accessor
    LevelStorage.Session getSession();
}