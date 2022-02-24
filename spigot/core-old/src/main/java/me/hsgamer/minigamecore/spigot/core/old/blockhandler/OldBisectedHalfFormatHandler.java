package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.spigot.core.common.blockhandler.BisectedHalfFormatHandler;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Stairs;
import org.bukkit.material.TrapDoor;

public class OldBisectedHalfFormatHandler extends BisectedHalfFormatHandler implements BlockStateHandler {
    @Override
    public void modify(BlockState blockState, BlockFormatData formatData) {
        getValue(formatData).ifPresent(value -> {
            boolean inverted = value.equalsIgnoreCase("top");
            MaterialData materialData = blockState.getData();
            if (materialData instanceof Stairs) {
                Stairs stairs = (Stairs) materialData;
                stairs.setInverted(inverted);
                blockState.setData(stairs);
            } else if (materialData instanceof TrapDoor) {
                TrapDoor trapDoor = (TrapDoor) materialData;
                trapDoor.setInverted(inverted);
                blockState.setData(trapDoor);
            }
        });
    }
}
