package me.hsgamer.minigamecore.spigot.core.block.handler;

import me.hsgamer.minigamecore.spigot.core.block.BlockDataHandler;
import me.hsgamer.minigamecore.spigot.core.block.BlockDataHandlerFactory;
import me.hsgamer.minigamecore.spigot.core.block.handler.flat.*;

import java.util.Collection;
import java.util.List;

public class FlatBlockDataHandlerFactory implements BlockDataHandlerFactory {
    @Override
    public Collection<BlockDataHandler> getHandlers() {
        return List.of(
                new FlatBisectedHalfBlockHandler(),
                new FlatFacingBlockHandler(),
                new FlatLitBlockHandler(),
                new FlatOpenBlockHandler(),
                new FlatPoweredBlockHandler(),
                new FlatSlabTypeBlockHandler(),
                new FlatWaterLevelBlockHandler(),
                new FlatWoodAxisBlockHandler()
        );
    }
}
