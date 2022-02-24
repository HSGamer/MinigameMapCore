package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.ShapeFormatHandler;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Rails;

import java.util.Locale;

public class OldShapeFormatHandler extends ShapeFormatHandler implements BlockStateHandler {
    @Override
    public void modify(BlockState blockState, BlockFormatData formatData) {
        getValue(formatData).ifPresent(value -> {
            MaterialData materialData = blockState.getData();
            if (materialData instanceof Rails) {
                boolean onSlope = false;
                if (value.toLowerCase(Locale.ROOT).startsWith("ascending_")) {
                    value = value.substring("ascending_".length());
                    onSlope = true;
                }
                BlockFace blockFace;
                if (value.equalsIgnoreCase("EAST_WEST")) {
                    blockFace = BlockFace.EAST;
                } else if (value.equalsIgnoreCase("NORTH_SOUTH")) {
                    blockFace = BlockFace.NORTH;
                } else {
                    blockFace = BlockFace.valueOf(value.toUpperCase(Locale.ROOT));
                }
                Rails rails = (Rails) materialData;
                rails.setDirection(blockFace, onSlope);
                blockState.setData(rails);
            }
        });
    }
}
