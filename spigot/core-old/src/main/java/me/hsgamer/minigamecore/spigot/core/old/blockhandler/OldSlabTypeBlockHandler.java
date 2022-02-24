package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.SlabTypeBlockHandler;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Step;

public class OldSlabTypeBlockHandler extends SlabTypeBlockHandler {
    @Override
    public void handle(Block block, String value) {
        if (value.equalsIgnoreCase("double")) {
            String materialType = block.getType().name();
            if (materialType.equalsIgnoreCase("STEP")) {
                block.setType(Material.valueOf("DOUBLE_STEP"));
            } else if (materialType.equalsIgnoreCase("WOOD_STEP")) {
                block.setType(Material.valueOf("WOOD_DOUBLE_STEP"));
            } else if (materialType.equalsIgnoreCase("STONE_SLAB2")) {
                block.setType(Material.valueOf("DOUBLE_STONE_SLAB2"));
            }
        } else {
            BlockState blockState = block.getState();
            MaterialData materialData = blockState.getData();
            if (materialData instanceof Step) {
                Step step = (Step) materialData;
                step.setInverted(value.equalsIgnoreCase("top"));
                blockState.setData(step);
                blockState.update(true, false);
            }
        }
    }
}
