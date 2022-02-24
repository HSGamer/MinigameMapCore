package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamecore.spigot.core.old.material.OldMaterialHandler;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.LitBlockHandler;
import org.bukkit.block.Block;

public class OldLitBlockHandler extends LitBlockHandler {
    @Override
    public void handle(Block block, String value) {
        boolean lit = Boolean.parseBoolean(value);
        String name = block.getType().name();
        if (name.endsWith("FURNACE")) {
            block.setType(lit
                    ? OldMaterialHandler.BlockMaterial.BURNING_FURNACE.material
                    : OldMaterialHandler.BlockMaterial.FURNACE.material
            );
        } else if (name.startsWith("REDSTONE_LAMP")) {
            block.setType(lit
                    ? OldMaterialHandler.BlockMaterial.REDSTONE_LAMP_ON.material
                    : OldMaterialHandler.BlockMaterial.REDSTONE_LAMP_OFF.material
            );
        } else if (name.startsWith("REDSTONE_TORCH")) {
            block.setType(lit
                    ? OldMaterialHandler.BlockMaterial.REDSTONE_TORCH_ON.material
                    : OldMaterialHandler.BlockMaterial.REDSTONE_TORCH_OFF.material
            );
        }
    }
}
