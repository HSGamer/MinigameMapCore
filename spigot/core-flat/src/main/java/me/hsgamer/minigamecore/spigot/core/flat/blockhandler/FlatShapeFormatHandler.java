package me.hsgamer.minigamecore.spigot.core.flat.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.ShapeFormatHandler;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Rail;

import java.util.Locale;

public class FlatShapeFormatHandler extends ShapeFormatHandler implements BlockDataHandler {
    @Override
    public void modify(BlockData blockData, BlockFormatData formatData) {
        getValue(formatData).ifPresent(value -> {
            if (!(blockData instanceof Rail)) return;
            Rail.Shape shape = Rail.Shape.valueOf(value.toUpperCase(Locale.ROOT));
            ((Rail) blockData).setShape(shape);
        });
    }
}
