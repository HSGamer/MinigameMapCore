package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.OpenFormatHandler;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Openable;

public class OldOpenFormatHandler extends OpenFormatHandler implements BlockStateHandler {
    @Override
    public void modify(BlockState blockState, BlockFormatData formatData) {
        getValue(formatData).ifPresent(value -> {
            if (!(blockState instanceof Openable)) return;
            boolean open = Boolean.parseBoolean(value);
            Openable openable = (Openable) blockState.getData();
            openable.setOpen(open);
            blockState.setData((MaterialData) openable);
        });
    }
}
