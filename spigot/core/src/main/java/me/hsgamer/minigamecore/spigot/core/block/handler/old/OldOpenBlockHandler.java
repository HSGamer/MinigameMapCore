package me.hsgamer.minigamecore.spigot.core.block.handler.old;

import me.hsgamer.minigamecore.spigot.core.block.handler.common.OpenBlockHandler;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Openable;

@SuppressWarnings("deprecation")
public class OldOpenBlockHandler extends OpenBlockHandler {
    @Override
    public void handle(Block block, String value) {
        boolean open = Boolean.parseBoolean(value);
        BlockState state = block.getState();
        if (!(state instanceof Openable)) return;
        Openable openable = (Openable) state.getData();
        openable.setOpen(open);
        state.setData((MaterialData) openable);
        state.update(true, false);
    }
}
