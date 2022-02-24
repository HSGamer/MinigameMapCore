package me.hsgamer.minigamecore.spigot.core.flat.blockhandler;

import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.WoodAxisBlockHandler;
import org.bukkit.Axis;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Orientable;

import java.util.Locale;

public class FlatWoodAxisBlockHandler extends WoodAxisBlockHandler {
    @Override
    public void handle(Block block, String value) {
        BlockData blockData = block.getBlockData();
        if (blockData instanceof Orientable) {
            Axis type = Axis.valueOf(value.toUpperCase(Locale.ROOT));
            ((Orientable) blockData).setAxis(type);
            block.setBlockData(blockData, false);
        }
    }
}
