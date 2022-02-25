package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamecore.spigot.core.old.material.OldMaterialHandler;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.BlockHandler;
import me.hsgamer.minigamemapcore.api.data.handler.PoweredFormatHandler;
import org.bukkit.block.Block;

public class OldPoweredFormatHandler extends PoweredFormatHandler implements BlockHandler {
    private void handle(Block block, String value, boolean applyPhysics) {
        boolean powered = Boolean.parseBoolean(value);
        String name = block.getType().name();
        if (name.startsWith("REDSTONE_COMPARATOR")) {
            block.setType(powered
                            ? OldMaterialHandler.BlockMaterial.REDSTONE_COMPARATOR_ON.material
                            : OldMaterialHandler.BlockMaterial.REDSTONE_COMPARATOR_OFF.material
                    , applyPhysics
            );
        }
    }

    @Override
    public void handle(Block block, BlockFormatData data, boolean applyPhysics) {
        getValue(data).ifPresent(value -> handle(block, value, applyPhysics));
    }
}
