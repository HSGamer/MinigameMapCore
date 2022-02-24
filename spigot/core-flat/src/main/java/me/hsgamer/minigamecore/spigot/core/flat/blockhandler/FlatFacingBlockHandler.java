package me.hsgamer.minigamecore.spigot.core.flat.blockhandler;

import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.FacingBlockHandler;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;

import java.util.Locale;

public class FlatFacingBlockHandler extends FacingBlockHandler {
    @Override
    public void handle(Block block, String value) {
        BlockFace blockFace = BlockFace.valueOf(value.toUpperCase(Locale.ROOT));
        if (!(block.getBlockData() instanceof Directional)) return;
        Directional direction = (Directional) block.getBlockData();
        direction.setFacing(blockFace);
        block.setBlockData(direction, false);
    }
}