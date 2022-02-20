package me.hsgamer.minigamecore.spigot.core.block.handler;

import com.cryptomorin.xseries.XBlock;
import me.hsgamer.minigamecore.spigot.core.block.BlockDataHandler;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import org.bukkit.block.Block;

public class PoweredBlockHandler implements BlockDataHandler {
    @Override
    public void handle(Block block, BlockFormatData data) {
        Object objPowered = data.getProperties().get("powered");
        if (objPowered == null) return;
        boolean powered = Boolean.parseBoolean(objPowered.toString());
        XBlock.setPowered(block, powered);
    }
}
