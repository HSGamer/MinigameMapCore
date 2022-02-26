package me.hsgamer.minigamecore.spigot.core.impl;

import com.cryptomorin.xseries.XMaterial;
import me.hsgamer.minigamecore.spigot.core.flat.material.FlatMaterialHandler;
import me.hsgamer.minigamecore.spigot.core.old.material.OldMaterialHandler;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.api.data.BlockPosition;
import me.hsgamer.minigamemapcore.spigot.core.common.BlockPlacer;
import me.hsgamer.minigamemapcore.spigot.core.common.MaterialHandler;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

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

    private final Plugin plugin;

    public SimpleBlockPlacer(Plugin plugin) {
        this.plugin = plugin;
    }

    public SimpleBlockPlacer() {
        this(JavaPlugin.getProvidingPlugin(SimpleBlockPlacer.class));
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
        CompletableFuture<Void> future = new CompletableFuture<>();
        Bukkit.getScheduler().runTask(plugin, () -> {
            Block block = world.getBlockAt(position.getX(), position.getY(), position.getZ());
            Optional<XMaterial> optionalXMaterial = getMaterial(data.getMaterial());
            if (optionalXMaterial.isEmpty()) {
                MATERIAL_HANDLER.setType(block, XMaterial.STONE);
                future.complete(null);
                return;
            }
            XMaterial xMaterial = optionalXMaterial.get();
            MATERIAL_HANDLER.setType(block, xMaterial);
            MATERIAL_HANDLER.modifyBlock(block, data);
            future.complete(null);
        });
        return future;
    }
}
