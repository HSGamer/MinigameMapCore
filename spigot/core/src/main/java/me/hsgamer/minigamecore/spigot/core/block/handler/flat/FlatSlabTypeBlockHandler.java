package me.hsgamer.minigamecore.spigot.core.block.handler.flat;

import me.hsgamer.minigamecore.spigot.core.block.handler.common.SlabTypeBlockHandler;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Slab;

import java.util.Locale;

public class FlatSlabTypeBlockHandler extends SlabTypeBlockHandler {
    @Override
    public void handle(Block block, String value) {
        BlockData blockData = block.getBlockData();
        if (blockData instanceof Slab) {
            Slab.Type slabType = Slab.Type.valueOf(value.toUpperCase(Locale.ROOT));
            ((Slab) blockData).setType(slabType);
            block.setBlockData(blockData, false);
        }
    }
}
