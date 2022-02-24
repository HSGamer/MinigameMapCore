package me.hsgamer.minigamemapcore.spigot.core.common;

import com.cryptomorin.xseries.XMaterial;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import org.bukkit.block.Block;

public interface MaterialHandler {
    void setType(Block block, XMaterial material, boolean applyPhysics);

    void modifyBlock(Block block, BlockFormatData formatData, boolean applyPhysics);

    default void setType(Block block, XMaterial material) {
        setType(block, material, false);
    }

    default void modifyBlock(Block block, BlockFormatData formatData) {
        modifyBlock(block, formatData, false);
    }
}
