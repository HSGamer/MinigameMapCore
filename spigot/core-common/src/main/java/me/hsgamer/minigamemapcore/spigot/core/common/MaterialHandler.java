package me.hsgamer.minigamemapcore.spigot.core.common;

import com.cryptomorin.xseries.XMaterial;
import org.bukkit.block.Block;

import java.util.Collection;

public interface MaterialHandler {
    Collection<BlockHandler> getHandlers();

    void setType(Block block, XMaterial material, boolean applyPhysics);

    default void setType(Block block, XMaterial material) {
        setType(block, material, false);
    }
}
