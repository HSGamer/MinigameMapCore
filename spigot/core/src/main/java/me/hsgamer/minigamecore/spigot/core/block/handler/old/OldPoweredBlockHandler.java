package me.hsgamer.minigamecore.spigot.core.block.handler.old;

import me.hsgamer.minigamecore.spigot.core.block.handler.common.PoweredBlockHandler;
import me.hsgamer.minigamecore.spigot.core.block.material.OldMaterialHandler;
import org.bukkit.block.Block;

public class OldPoweredBlockHandler extends PoweredBlockHandler {
    @Override
    public void handle(Block block, String value) {
        boolean powered = Boolean.parseBoolean(value);
        String name = block.getType().name();
        if (name.startsWith("REDSTONE_COMPARATOR"))
            block.setType(OldMaterialHandler.BlockMaterial.REDSTONE_COMPARATOR_ON.material);
    }
}
