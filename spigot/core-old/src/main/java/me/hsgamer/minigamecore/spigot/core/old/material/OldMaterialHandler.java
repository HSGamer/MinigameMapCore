package me.hsgamer.minigamecore.spigot.core.old.material;

import me.hsgamer.minigamecore.spigot.core.old.blockhandler.*;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.BlockHandler;
import me.hsgamer.minigamemapcore.spigot.core.common.MaterialHandler;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;

import java.util.Collection;
import java.util.List;

public class OldMaterialHandler implements MaterialHandler {
    private static final Collection<BlockHandler> BLOCK_HANDLERS = List.of(
            new OldLitFormatHandler(),
            new OldPoweredFormatHandler(),
            new OldDoubleSlabTypeFormatHandler()
    );
    private static final Collection<BlockStateHandler> STATE_HANDLERS = List.of(
            new OldBisectedHalfFormatHandler(),
            new OldFacingFormatHandler(),
            new OldOpenFormatHandler(),
            new OldWaterLevelFormatHandler(),
            new OldWoodAxisFormatHandler(),
            new OldSlabTypeFormatHandler(),
            new OldShapeFormatHandler()
    );

    @Override
    public void modifyBlock(Block block, BlockFormatData formatData, boolean applyPhysics) {
        BLOCK_HANDLERS.forEach(blockHandler -> blockHandler.handle(block, formatData, applyPhysics));
        BlockState blockState = block.getState();
        STATE_HANDLERS.forEach(blockStateHandler -> blockStateHandler.modify(blockState, formatData));
        blockState.update(false, applyPhysics);
    }
}
