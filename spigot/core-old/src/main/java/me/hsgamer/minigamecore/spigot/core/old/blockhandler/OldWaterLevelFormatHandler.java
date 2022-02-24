package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.WaterLevelFormatHandler;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;

@SuppressWarnings("deprecation")
public class OldWaterLevelFormatHandler extends WaterLevelFormatHandler implements BlockStateHandler {
    @Override
    public void modify(BlockState blockState, BlockFormatData formatData) {
        getValue(formatData).ifPresent(value -> {
            int level = Integer.parseInt(value);
            MaterialData materialData = blockState.getData();
            materialData.setData((byte) level);
            blockState.setData(materialData);
        });
    }
}
