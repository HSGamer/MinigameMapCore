package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.WoodAxisFormatHandler;
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
                    tree.setDirection(BlockFace.NORTH);
                } else if (value.equalsIgnoreCase("y")) {
                    tree.setDirection(BlockFace.WEST);
                } else {
                    return;
                }
                blockState.setData(tree);
            }
        });
    }
}
