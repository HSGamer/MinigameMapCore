package me.hsgamer.minigamecore.spigot.core.block.handler.old;

import me.hsgamer.minigamecore.spigot.core.block.handler.common.BisectedHalfBlockHandler;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Stairs;
import org.bukkit.material.TrapDoor;

@SuppressWarnings("deprecation")
public class OldBisectedHalfBlockHandler extends BisectedHalfBlockHandler {
    @Override
    public void handle(Block block, String value) {
        boolean inverted = value.equalsIgnoreCase("top");
        BlockState blockState = block.getState();
        MaterialData materialData = blockState.getData();
        if (materialData instanceof Stairs) {
            Stairs stairs = (Stairs) materialData;
            stairs.setInverted(inverted);
            blockState.setData(stairs);
            blockState.update(true, false);
        } else if (materialData instanceof TrapDoor) {
            TrapDoor trapDoor = (TrapDoor) materialData;
            trapDoor.setInverted(inverted);
            blockState.setData(trapDoor);
            blockState.update(true, false);
        }
    }
}
