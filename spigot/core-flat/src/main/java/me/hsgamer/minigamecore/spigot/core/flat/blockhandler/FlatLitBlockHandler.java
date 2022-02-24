package me.hsgamer.minigamecore.spigot.core.flat.blockhandler;

import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.LitBlockHandler;
import org.bukkit.block.Block;
import org.bukkit.block.data.Lightable;

public class FlatLitBlockHandler extends LitBlockHandler {
    @Override
    public void handle(Block block, String value) {
        boolean lit = Boolean.parseBoolean(value);
        if (!(block.getBlockData() instanceof Lightable)) return;
        Lightable lightable = (Lightable) block.getBlockData();
        lightable.setLit(lit);
        block.setBlockData(lightable, false);
    }
}
