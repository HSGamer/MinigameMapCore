package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.FacingBlockHandler;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.material.Directional;
import org.bukkit.material.MaterialData;

import java.util.Locale;

public class OldFacingBlockHandler extends FacingBlockHandler {
    @Override
    public void handle(Block block, String value) {
        BlockFace blockFace = BlockFace.valueOf(value.toUpperCase(Locale.ROOT));
        BlockState state = block.getState();
        MaterialData materialData = state.getData();
        if (materialData instanceof Directional) {
            ((Directional) materialData).setFacingDirection(blockFace);
            state.update(true, false);
        }
    }
}
