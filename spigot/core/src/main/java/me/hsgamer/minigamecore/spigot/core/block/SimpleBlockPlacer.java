package me.hsgamer.minigamecore.spigot.core.block;

import com.cryptomorin.xseries.XBlock;
import com.cryptomorin.xseries.XMaterial;
import me.hsgamer.minigamecore.spigot.core.block.handler.*;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.api.data.BlockPosition;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleBlockPlacer implements BlockPlacer {
    private static final List<BlockDataHandler> BLOCK_DATA_HANDLERS = new ArrayList<>();

    static {
        addBlockDataHandler(new FacingBlockHandler());
        addBlockDataHandler(new WaterLevelBlockHandler());
        addBlockDataHandler(new OpenBlockHandler());
        addBlockDataHandler(new PoweredBlockHandler());
        addBlockDataHandler(new LitBlockHandler());
        addBlockDataHandler(new SlabTypeBlockHandler());
        addBlockDataHandler(new WoodAxisBlockHandler());
        addBlockDataHandler(new BisectedHalfBlockHandler());
    }

    public static void addBlockDataHandler(BlockDataHandler blockDataHandler) {
        BLOCK_DATA_HANDLERS.add(blockDataHandler);
    }

    @Override
    public void place(World world, BlockPosition position, BlockFormatData data) {
        Block block = world.getBlockAt(position.getX(), position.getY(), position.getZ());
        String rawMaterial = data.getMaterial();
        if (!rawMaterial.startsWith("minecraft:")) {
            XBlock.setType(block, XMaterial.STONE);
            return;
        }
        rawMaterial = rawMaterial.replace("minecraft:", "");
        Optional<XMaterial> optionalXMaterial = XMaterial.matchXMaterial(rawMaterial);
        if (optionalXMaterial.isEmpty()) {
            XBlock.setType(block, XMaterial.STONE);
            return;
        }
        XMaterial xMaterial = optionalXMaterial.get();
        XBlock.setType(block, xMaterial);
        for (BlockDataHandler blockDataHandler : BLOCK_DATA_HANDLERS) {
            blockDataHandler.handle(block, data);
        }
    }
}
