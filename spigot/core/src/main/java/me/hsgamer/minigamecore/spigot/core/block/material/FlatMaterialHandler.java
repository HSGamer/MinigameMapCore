package me.hsgamer.minigamecore.spigot.core.block.material;

import com.cryptomorin.xseries.XMaterial;
import me.hsgamer.minigamecore.spigot.core.block.MaterialHandler;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class FlatMaterialHandler implements MaterialHandler {
    @Override
    public void setType(Block block, XMaterial material, boolean applyPhysics) {
        Material parseMaterial = MaterialHandlerHelper.getBlock(material).parseMaterial();
        if (parseMaterial == null) return;
        block.setType(parseMaterial, applyPhysics);
    }
}
