package me.hsgamer.minigamecore.spigot.core.block;

import com.cryptomorin.xseries.XMaterial;
import me.hsgamer.minigamecore.spigot.core.block.handler.FlatBlockDataHandlerFactory;
import me.hsgamer.minigamecore.spigot.core.block.handler.OldBlockDataHandlerFactory;
import me.hsgamer.minigamecore.spigot.core.block.material.FlatMaterialHandler;
import me.hsgamer.minigamecore.spigot.core.block.material.OldMaterialHandler;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.api.data.BlockPosition;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleBlockPlacer implements BlockPlacer {
    private static final MaterialHandler MATERIAL_HANDLER;
    private static final List<BlockDataHandler> BLOCK_DATA_HANDLERS = new ArrayList<>();

    static {
        if (XMaterial.supports(13)) {
            MATERIAL_HANDLER = new FlatMaterialHandler();
            BLOCK_DATA_HANDLERS.addAll(new FlatBlockDataHandlerFactory().getHandlers());
        } else {
            MATERIAL_HANDLER = new OldMaterialHandler();
            BLOCK_DATA_HANDLERS.addAll(new OldBlockDataHandlerFactory().getHandlers());
        }
    }

    public static void addBlockDataHandler(BlockDataHandler blockDataHandler) {
        BLOCK_DATA_HANDLERS.add(blockDataHandler);
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
        for (BlockDataHandler blockDataHandler : BLOCK_DATA_HANDLERS) {
            blockDataHandler.handle(block, data);
        }
    }
}
