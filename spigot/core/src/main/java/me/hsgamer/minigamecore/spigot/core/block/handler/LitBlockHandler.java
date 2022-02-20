package me.hsgamer.minigamecore.spigot.core.block.handler;

import com.cryptomorin.xseries.XBlock;
import me.hsgamer.minigamecore.spigot.core.block.BlockDataHandler;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import org.bukkit.block.Block;

public class LitBlockHandler implements BlockDataHandler {
    @Override
    public void handle(Block block, BlockFormatData data) {
        Object objLit = data.getProperties().get("lit");
        if (objLit == null) return;
        boolean lit = Boolean.parseBoolean(objLit.toString());
        XBlock.setLit(block, lit);
    }
}
