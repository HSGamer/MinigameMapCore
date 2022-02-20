package me.hsgamer.minigamecore.spigot.core.block.handler;

import com.cryptomorin.xseries.XMaterial;
import me.hsgamer.minigamecore.spigot.core.block.BlockDataHandler;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Slab;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Step;

import java.util.Locale;

@SuppressWarnings("deprecation")
public class SlabTypeBlockHandler implements BlockDataHandler {
    @Override
    public void handle(Block block, BlockFormatData data) {
        Object objType = data.getProperties().get("type");
        if (objType == null) return;
        String type = objType.toString();

        if (XMaterial.supports(13)) {
            BlockData blockData = block.getBlockData();
            if (blockData instanceof Slab) {
                Slab.Type slabType = Slab.Type.valueOf(type.toUpperCase(Locale.ROOT));
                ((Slab) blockData).setType(slabType);
                block.setBlockData(blockData, false);
            }
        } else {
            if (type.equalsIgnoreCase("double")) {
                String materialType = block.getType().name();
                if (materialType.equalsIgnoreCase("STEP")) {
                    block.setType(Material.valueOf("DOUBLE_STEP"));
                } else if (materialType.equalsIgnoreCase("WOOD_STEP")) {
                    block.setType(Material.valueOf("WOOD_DOUBLE_STEP"));
                } else if (materialType.equalsIgnoreCase("STONE_SLAB2")) {
                    block.setType(Material.valueOf("DOUBLE_STONE_SLAB2"));
                }
            } else {
                BlockState blockState = block.getState();
                MaterialData materialData = blockState.getData();
                if (materialData instanceof Step) {
                    Step step = (Step) materialData;
                    step.setInverted(type.equalsIgnoreCase("top"));
                    blockState.setData(step);
                    blockState.update(true);
                }
            }
        }
    }
}
