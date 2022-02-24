package me.hsgamer.minigamecore.spigot.core.flat.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.WoodAxisFormatHandler;
import org.bukkit.Axis;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Orientable;

import java.util.Locale;

public class FlatWoodAxisFormatHandler extends WoodAxisFormatHandler implements BlockDataHandler {
    @Override
    public void modify(BlockData blockData, BlockFormatData formatData) {
        getValue(formatData).ifPresent(value -> {
            if (!(blockData instanceof Orientable)) return;
            Axis type = Axis.valueOf(value.toUpperCase(Locale.ROOT));
            ((Orientable) blockData).setAxis(type);
        });
    }
}
