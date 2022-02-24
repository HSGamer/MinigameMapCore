package me.hsgamer.minigamemapcore.spigot.core.common;

import com.cryptomorin.xseries.XMaterial;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.Optional;

public interface MaterialHandler {
    void setType(Block block, XMaterial material, boolean applyPhysics);

    void modifyBlock(Block block, BlockFormatData formatData, boolean applyPhysics);

    default boolean isSolid(XMaterial material) {
        return Optional.ofNullable(material.parseMaterial()).map(Material::isSolid).orElse(false);
    }

    default void setType(Block block, XMaterial material) {
        setType(block, material, false);
    }

    default void modifyBlock(Block block, BlockFormatData formatData) {
        modifyBlock(block, formatData, false);
    }
}
