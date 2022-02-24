package me.hsgamer.minigamecore.spigot.core.impl;

import com.cryptomorin.xseries.XMaterial;
import me.hsgamer.minigamecore.spigot.core.flat.material.FlatMaterialHandler;
import me.hsgamer.minigamecore.spigot.core.old.material.OldMaterialHandler;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.api.data.BlockPosition;
import me.hsgamer.minigamemapcore.spigot.core.common.BlockHandler;
import me.hsgamer.minigamemapcore.spigot.core.common.BlockPlacer;
import me.hsgamer.minigamemapcore.spigot.core.common.MaterialHandler;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleBlockPlacer implements BlockPlacer {
    private static final MaterialHandler MATERIAL_HANDLER;
    private static final List<BlockHandler> BLOCK_HANDLERS = new ArrayList<>();

    static {
        if (XMaterial.supports(13)) {
            MATERIAL_HANDLER = new FlatMaterialHandler();
        } else {
            MATERIAL_HANDLER = new OldMaterialHandler();
        }
    }

    public static void addBlockHandler(BlockHandler blockDataHandler) {
        BLOCK_HANDLERS.add(blockDataHandler);
    }

    @Override
    public void place(World world, BlockPosition position, BlockFormatData data) {
        Block block = world.getBlockAt(position.getX(), position.getY(), position.getZ());
        String rawMaterial = data.getMaterial();
        if (!rawMaterial.startsWith("minecraft:")) {
            MATERIAL_HANDLER.setType(block, XMaterial.STONE);
            return;
        }
        rawMaterial = rawMaterial.replace("minecraft:", "");
        Optional<XMaterial> optionalXMaterial = XMaterial.matchXMaterial(rawMaterial);
        if (optionalXMaterial.isEmpty()) {
            MATERIAL_HANDLER.setType(block, XMaterial.STONE);
            return;
        }
        XMaterial xMaterial = optionalXMaterial.get();
        MATERIAL_HANDLER.setType(block, xMaterial);
        MATERIAL_HANDLER.modifyBlock(block, data);

        for (BlockHandler blockHandler : BLOCK_HANDLERS) {
            blockHandler.handle(block, data, false);
        }
    }
}
