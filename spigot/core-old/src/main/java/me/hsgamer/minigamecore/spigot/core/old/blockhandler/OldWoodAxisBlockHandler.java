package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.WoodAxisBlockHandler;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Tree;

public class OldWoodAxisBlockHandler extends WoodAxisBlockHandler {
    @Override
    public void handle(Block block, String value) {
        BlockState blockState = block.getState();
        MaterialData materialData = blockState.getData();
        if (materialData instanceof Tree) {
            Tree tree = (Tree) materialData;
            if (value.equalsIgnoreCase("x")) {
                tree.setDirection(BlockFace.NORTH);
            } else if (value.equalsIgnoreCase("y")) {
                tree.setDirection(BlockFace.WEST);
            } else {
                return;
            }
            blockState.setData(tree);
            blockState.update(true, false);
        }
    }
}
