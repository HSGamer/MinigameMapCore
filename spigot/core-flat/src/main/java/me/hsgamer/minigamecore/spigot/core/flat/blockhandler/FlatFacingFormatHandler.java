package me.hsgamer.minigamecore.spigot.core.flat.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.FacingFormatHandler;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;

import java.util.Locale;

public class FlatFacingFormatHandler extends FacingFormatHandler implements BlockDataHandler {
    @Override
    public void modify(BlockData blockData, BlockFormatData formatData) {
        getValue(formatData).ifPresent(value -> {
            if (!(blockData instanceof Directional)) return;
            BlockFace blockFace = BlockFace.valueOf(value.toUpperCase(Locale.ROOT));
            Directional direction = (Directional) blockData;
            direction.setFacing(blockFace);
        });
    }
}
