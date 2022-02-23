package me.hsgamer.minigamecore.spigot.core.block.handler;

import me.hsgamer.minigamecore.spigot.core.block.BlockDataHandler;
import me.hsgamer.minigamecore.spigot.core.block.BlockDataHandlerFactory;
import me.hsgamer.minigamecore.spigot.core.block.handler.old.*;

import java.util.Collection;
import java.util.List;

public class OldBlockDataHandlerFactory implements BlockDataHandlerFactory {
    @Override
    public Collection<BlockDataHandler> getHandlers() {
        return List.of(
                new OldBisectedHalfBlockHandler(),
                new OldFacingBlockHandler(),
                new OldLitBlockHandler(),
                new OldOpenBlockHandler(),
                new OldPoweredBlockHandler(),
                new OldSlabTypeBlockHandler(),
                new OldWaterLevelBlockHandler(),
                new OldWoodAxisBlockHandler()
        );
    }
}
