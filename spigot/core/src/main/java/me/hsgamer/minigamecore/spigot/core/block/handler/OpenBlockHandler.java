package me.hsgamer.minigamecore.spigot.core.block.handler;

import com.cryptomorin.xseries.XBlock;
import me.hsgamer.minigamecore.spigot.core.block.BlockDataHandler;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import org.bukkit.block.Block;

public class OpenBlockHandler implements BlockDataHandler {
    @Override
    public void handle(Block block, BlockFormatData data) {
        Object objOpen = data.getProperties().get("open");
        if (objOpen == null) return;
        boolean open = Boolean.parseBoolean(objOpen.toString());
        XBlock.setOpened(block, open);
    }
}
