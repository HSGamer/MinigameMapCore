package me.hsgamer.minigamecore.spigot.core.flat.blockhandler;

import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.PoweredBlockHandler;
import org.bukkit.block.Block;
import org.bukkit.block.data.Powerable;

public class FlatPoweredBlockHandler extends PoweredBlockHandler {
    @Override
    public void handle(Block block, String value) {
        boolean powered = Boolean.parseBoolean(value);
        if (!(block.getBlockData() instanceof Powerable)) return;
        Powerable powerable = (Powerable) block.getBlockData();
        powerable.setPowered(powered);
        block.setBlockData(powerable, false);
    }
}
