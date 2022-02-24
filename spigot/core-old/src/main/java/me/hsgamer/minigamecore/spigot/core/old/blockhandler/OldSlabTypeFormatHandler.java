package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.SlabTypeFormatHandler;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Step;

public class OldSlabTypeFormatHandler extends SlabTypeFormatHandler implements BlockStateHandler {
    @Override
    public void modify(BlockState blockState, BlockFormatData formatData) {
        getValue(formatData).ifPresent(value -> {
            if (!value.equalsIgnoreCase("double")) {
                MaterialData materialData = blockState.getData();
                if (materialData instanceof Step) {
                    Step step = (Step) materialData;
                    step.setInverted(value.equalsIgnoreCase("top"));
                    blockState.setData(step);
                }
            }
        });
    }
}
