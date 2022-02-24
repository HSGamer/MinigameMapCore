package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamecore.spigot.core.old.material.OldMaterialHandler;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.BlockHandler;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.LitFormatHandler;
import org.bukkit.block.Block;

public class OldLitFormatHandler extends LitFormatHandler implements BlockHandler {
    private void handle(Block block, String value, boolean applyPhysics) {
        boolean lit = Boolean.parseBoolean(value);
        String name = block.getType().name();
        if (name.endsWith("FURNACE")) {
            block.setType(lit
                    ? OldMaterialHandler.BlockMaterial.BURNING_FURNACE.material
                    : OldMaterialHandler.BlockMaterial.FURNACE.material
                    , applyPhysics
            );
        } else if (name.startsWith("REDSTONE_LAMP")) {
            block.setType(lit
                    ? OldMaterialHandler.BlockMaterial.REDSTONE_LAMP_ON.material
                    : OldMaterialHandler.BlockMaterial.REDSTONE_LAMP_OFF.material
                    , applyPhysics
            );
        } else if (name.startsWith("REDSTONE_TORCH")) {
            block.setType(lit
                    ? OldMaterialHandler.BlockMaterial.REDSTONE_TORCH_ON.material
                    : OldMaterialHandler.BlockMaterial.REDSTONE_TORCH_OFF.material
                    , applyPhysics
            );
        }
    }

    @Override
    public void handle(Block block, BlockFormatData data, boolean applyPhysics) {
        getValue(data).ifPresent(value -> handle(block, value, applyPhysics));
    }
}
