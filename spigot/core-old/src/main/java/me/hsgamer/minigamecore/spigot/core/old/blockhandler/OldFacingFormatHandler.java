package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.FacingFormatHandler;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.material.Directional;
import org.bukkit.material.MaterialData;

import java.util.Locale;

public class OldFacingFormatHandler extends FacingFormatHandler implements BlockStateHandler {
    @Override
    public void modify(BlockState blockState, BlockFormatData formatData) {
        getValue(formatData).ifPresent(value -> {
            MaterialData materialData = blockState.getData();
            if (materialData instanceof Directional) {
                BlockFace blockFace = BlockFace.valueOf(value.toUpperCase(Locale.ROOT));
                ((Directional) materialData).setFacingDirection(blockFace);
                blockState.setData(materialData);
            }
        });
    }
}
