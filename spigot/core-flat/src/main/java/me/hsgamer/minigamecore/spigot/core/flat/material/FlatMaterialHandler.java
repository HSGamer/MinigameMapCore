package me.hsgamer.minigamecore.spigot.core.flat.material;

import com.cryptomorin.xseries.XMaterial;
import me.hsgamer.minigamecore.spigot.core.flat.blockhandler.*;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.MaterialHandler;
import me.hsgamer.minigamemapcore.spigot.core.common.helper.MaterialHandlerHelper;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;

import java.util.Collection;
import java.util.List;

public class FlatMaterialHandler implements MaterialHandler {
    private static final Collection<BlockDataHandler> HANDLERS = List.of(
            new FlatBisectedHalfFormatHandler(),
            new FlatFacingFormatHandler(),
            new FlatLitFormatHandler(),
            new FlatOpenFormatHandler(),
            new FlatPoweredFormatHandler(),
            new FlatSlabTypeFormatHandler(),
            new FlatWaterLevelFormatHandler(),
            new FlatWoodAxisFormatHandler(),
            new FlatShapeFormatHandler()
    );

    @Override
    public void setType(Block block, XMaterial material, boolean applyPhysics) {
        Material parseMaterial = MaterialHandlerHelper.getBlock(material).parseMaterial();
        if (parseMaterial == null) return;
        block.setType(parseMaterial, applyPhysics);
    }

    @Override
    public void modifyBlock(Block block, BlockFormatData formatData, boolean applyPhysics) {
        BlockData blockData = block.getBlockData();
        HANDLERS.forEach(handler -> handler.modify(blockData, formatData));
        block.setBlockData(blockData, applyPhysics);
    }
}
