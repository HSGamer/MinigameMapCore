package me.hsgamer.minigamecore.spigot.core.block.handler;

import com.cryptomorin.xseries.XBlock;
import me.hsgamer.minigamecore.spigot.core.block.BlockDataHandler;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import java.util.Locale;

public class FacingBlockHandler implements BlockDataHandler {
    @Override
    public void handle(Block block, BlockFormatData data) {
        Object objFacing = data.getProperties().get("facing");
        if (objFacing == null) return;
        String facing = objFacing.toString();
        BlockFace blockFace = BlockFace.valueOf(facing.toUpperCase(Locale.ROOT));
        XBlock.setDirection(block, blockFace);
    }
}
