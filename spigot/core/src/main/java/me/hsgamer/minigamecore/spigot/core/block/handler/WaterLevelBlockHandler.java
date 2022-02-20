package me.hsgamer.minigamecore.spigot.core.block.handler;

import com.cryptomorin.xseries.XBlock;
import me.hsgamer.minigamecore.spigot.core.block.BlockDataHandler;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import org.bukkit.block.Block;

public class WaterLevelBlockHandler implements BlockDataHandler {
    @Override
    public void handle(Block block, BlockFormatData data) {
        Object objLevel = data.getProperties().get("level");
        if (objLevel == null) return;
        int level = Integer.parseInt(objLevel.toString());
        XBlock.setFluidLevel(block, level);
    }
}
