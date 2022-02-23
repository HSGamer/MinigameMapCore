package me.hsgamer.minigamecore.spigot.core.block;

import com.cryptomorin.xseries.XMaterial;
import org.bukkit.block.Block;

public interface MaterialHandler {
    void setType(Block block, XMaterial material, boolean applyPhysics);

    default void setType(Block block, XMaterial material) {
        setType(block, material, false);
    }
}
