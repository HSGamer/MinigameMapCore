package me.hsgamer.minigamecore.spigot.core.flat.material;

import com.cryptomorin.xseries.XMaterial;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.MaterialHandler;
import me.hsgamer.minigamemapcore.spigot.core.common.helper.MaterialHandlerHelper;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class FlatMaterialHandler implements MaterialHandler {
    @Override
    public void setType(Block block, XMaterial material, boolean applyPhysics) {
        Material parseMaterial = MaterialHandlerHelper.getBlock(material).parseMaterial();
        if (parseMaterial == null) return;
        block.setType(parseMaterial, applyPhysics);
    }

    @Override
    public void modifyBlock(Block block, BlockFormatData formatData, boolean applyPhysics) {
        String data = formatData.getPropertiesAsString();
        if (!data.isBlank()) {
            block.setBlockData(Bukkit.createBlockData(block.getType(), "[" + data + "]"), applyPhysics);
        }
    }
}
