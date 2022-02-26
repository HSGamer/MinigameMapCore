package me.hsgamer.minigamecore.spigot.core.impl;

import com.cryptomorin.xseries.XMaterial;
import me.hsgamer.minigamecore.spigot.core.flat.material.FlatMaterialHandler;
import me.hsgamer.minigamecore.spigot.core.old.material.OldMaterialHandler;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.api.data.BlockPosition;
import me.hsgamer.minigamemapcore.spigot.core.common.BlockPlacer;
import me.hsgamer.minigamemapcore.spigot.core.common.MaterialHandler;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class SimpleBlockPlacer implements BlockPlacer {
    private static final MaterialHandler MATERIAL_HANDLER;

    static {
        if (XMaterial.supports(13)) {
            MATERIAL_HANDLER = new FlatMaterialHandler();
        } else {
            MATERIAL_HANDLER = new OldMaterialHandler();
        }
    }

    private Optional<XMaterial> getMaterial(String rawMaterial) {
        if (!rawMaterial.startsWith("minecraft:")) {
            return Optional.empty();
        }
        rawMaterial = rawMaterial.replace("minecraft:", "");
        return XMaterial.matchXMaterial(rawMaterial);
    }

    @Override
    public boolean isSolid(String material) {
        return getMaterial(material).map(MATERIAL_HANDLER::isSolid).orElse(false);
    }

    @Override
    public CompletableFuture<Void> place(World world, BlockPosition position, BlockFormatData data) {
        Block block = world.getBlockAt(position.getX(), position.getY(), position.getZ());
        Optional<XMaterial> optionalXMaterial = getMaterial(data.getMaterial());
        if (optionalXMaterial.isEmpty()) {
            MATERIAL_HANDLER.setType(block, XMaterial.STONE);
            return CompletableFuture.completedFuture(null);
        }
        XMaterial xMaterial = optionalXMaterial.get();
        MATERIAL_HANDLER.setType(block, xMaterial);
        MATERIAL_HANDLER.modifyBlock(block, data);
        return CompletableFuture.completedFuture(null);
    }
}
