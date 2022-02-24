package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamecore.spigot.core.old.material.OldMaterialHandler;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.LitBlockHandler;
import org.bukkit.block.Block;

public class OldLitBlockHandler extends LitBlockHandler {
    @Override
    public void handle(Block block, String value) {
        boolean lit = Boolean.parseBoolean(value);
        String name = block.getType().name();
        if (name.endsWith("FURNACE")) block.setType(OldMaterialHandler.BlockMaterial.BURNING_FURNACE.material);
        else if (name.startsWith("REDSTONE_LAMP"))
            block.setType(OldMaterialHandler.BlockMaterial.REDSTONE_LAMP_ON.material);
        else block.setType(OldMaterialHandler.BlockMaterial.REDSTONE_TORCH_ON.material);
    }
}
