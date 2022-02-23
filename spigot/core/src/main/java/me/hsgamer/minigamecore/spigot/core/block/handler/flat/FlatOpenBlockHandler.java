package me.hsgamer.minigamecore.spigot.core.block.handler.flat;

import me.hsgamer.minigamecore.spigot.core.block.handler.common.OpenBlockHandler;
import org.bukkit.block.Block;
import org.bukkit.block.data.Openable;

public class FlatOpenBlockHandler extends OpenBlockHandler {
    @Override
    public void handle(Block block, String value) {
        boolean open = Boolean.parseBoolean(value);
        if (!(block.getBlockData() instanceof Openable)) return;
        Openable openable = (Openable) block.getBlockData();
        openable.setOpen(open);
        block.setBlockData(openable, false);
    }
}
