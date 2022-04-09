package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.api.data.handler.PoweredFormatHandler;
import me.hsgamer.minigamemapcore.spigot.core.common.BlockHandler;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class OldPoweredFormatHandler extends PoweredFormatHandler implements BlockHandler {
    private void handle(Block block, String value, boolean applyPhysics) {
        boolean powered = Boolean.parseBoolean(value);
        String name = block.getType().name();
        if (name.startsWith("REDSTONE_COMPARATOR")) {
            block.setType(Material.valueOf(powered ? "REDSTONE_COMPARATOR_ON" : "REDSTONE_COMPARATOR_OFF"), applyPhysics);
        }
    }

    @Override
    public void handle(Block block, BlockFormatData data, boolean applyPhysics) {
        getValue(data).ifPresent(value -> handle(block, value, applyPhysics));
    }
}
