package me.hsgamer.minigamecore.spigot.core.flat.material;

import com.cryptomorin.xseries.XMaterial;
import me.hsgamer.minigamecore.spigot.core.flat.blockhandler.*;
import me.hsgamer.minigamemapcore.spigot.core.common.BlockHandler;
import me.hsgamer.minigamemapcore.spigot.core.common.MaterialHandler;
import me.hsgamer.minigamemapcore.spigot.core.common.helper.MaterialHandlerHelper;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.Collection;
import java.util.List;

public class FlatMaterialHandler implements MaterialHandler {
    private static final Collection<BlockHandler> HANDLERS = List.of(
            new FlatBisectedHalfBlockHandler(),
            new FlatFacingBlockHandler(),
            new FlatLitBlockHandler(),
            new FlatOpenBlockHandler(),
            new FlatPoweredBlockHandler(),
            new FlatSlabTypeBlockHandler(),
            new FlatWaterLevelBlockHandler(),
            new FlatWoodAxisBlockHandler()
    );

    @Override
    public Collection<BlockHandler> getHandlers() {
        return HANDLERS;
    }

    @Override
    public void setType(Block block, XMaterial material, boolean applyPhysics) {
        Material parseMaterial = MaterialHandlerHelper.getBlock(material).parseMaterial();
        if (parseMaterial == null) return;
        block.setType(parseMaterial, applyPhysics);
    }
}
