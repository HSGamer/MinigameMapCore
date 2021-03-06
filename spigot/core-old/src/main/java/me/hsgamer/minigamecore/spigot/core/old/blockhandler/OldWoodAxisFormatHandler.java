package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.api.data.handler.WoodAxisFormatHandler;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Tree;

public class OldWoodAxisFormatHandler extends WoodAxisFormatHandler implements BlockStateHandler {
    @Override
    public void modify(BlockState blockState, BlockFormatData formatData) {
        getValue(formatData).ifPresent(value -> {
            MaterialData materialData = blockState.getData();
            if (materialData instanceof Tree) {
                Tree tree = (Tree) materialData;
                if (value.equalsIgnoreCase("x")) {
                    tree.setDirection(BlockFace.WEST);
                } else if (value.equalsIgnoreCase("y")) {
                    tree.setDirection(BlockFace.UP);
                } else if (value.equalsIgnoreCase("z")) {
                    tree.setDirection(BlockFace.NORTH);
                } else {
                    return;
                }
                blockState.setData(tree);
            }
        });
    }
}
