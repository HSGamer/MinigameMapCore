package me.hsgamer.minigamecore.spigot.core.block.handler;

import com.cryptomorin.xseries.XMaterial;
import me.hsgamer.minigamecore.spigot.core.block.BlockDataHandler;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import org.bukkit.Axis;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Orientable;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Tree;

import java.util.Locale;

@SuppressWarnings("deprecation")
public class WoodAxisBlockHandler implements BlockDataHandler {
    @Override
    public void handle(Block block, BlockFormatData data) {
        Object objAxis = data.getProperties().get("axis");
        if (objAxis == null) return;
        String axis = objAxis.toString();
        if (XMaterial.supports(13)) {
            BlockData blockData = block.getBlockData();
            if (blockData instanceof Orientable) {
                Axis type = Axis.valueOf(axis.toUpperCase(Locale.ROOT));
                ((Orientable) blockData).setAxis(type);
            }
        } else {
            BlockState blockState = block.getState();
            MaterialData materialData = blockState.getData();
            if (materialData instanceof Tree) {
                Tree tree = (Tree) materialData;
                if (axis.equalsIgnoreCase("x")) {
                    tree.setDirection(BlockFace.NORTH);
                } else if (axis.equalsIgnoreCase("y")) {
                    tree.setDirection(BlockFace.WEST);
                } else {
                    return;
                }
                blockState.setData(tree);
                blockState.update(true);
            }
        }
    }
}
