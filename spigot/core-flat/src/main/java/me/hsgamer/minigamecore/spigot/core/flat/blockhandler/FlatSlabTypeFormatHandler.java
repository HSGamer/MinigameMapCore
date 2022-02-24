package me.hsgamer.minigamecore.spigot.core.flat.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.SlabTypeFormatHandler;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Slab;

import java.util.Locale;

public class FlatSlabTypeFormatHandler extends SlabTypeFormatHandler implements BlockDataHandler {
    @Override
    public void modify(BlockData blockData, BlockFormatData formatData) {
        getValue(formatData).ifPresent(value -> {
            if (!(blockData instanceof Slab)) return;
            Slab.Type slabType = Slab.Type.valueOf(value.toUpperCase(Locale.ROOT));
            ((Slab) blockData).setType(slabType);
        });
    }
}
