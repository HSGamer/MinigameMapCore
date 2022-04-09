package me.hsgamer.minigamecore.spigot.core.old.blockhandler;

import com.cryptomorin.xseries.XBlock;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.api.data.handler.LitFormatHandler;
import me.hsgamer.minigamemapcore.spigot.core.common.BlockHandler;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class OldLitFormatHandler extends LitFormatHandler implements BlockHandler {
    private void handle(Block block, String value, boolean applyPhysics) {
        boolean lit = Boolean.parseBoolean(value);
        String name = block.getType().name();
        XBlock.setLit(block, lit);
        if (name.endsWith("FURNACE")) {
            block.setType(Material.valueOf(lit ? "BURNING_FURNACE" : "FURNACE"), applyPhysics);
        } else if (name.startsWith("REDSTONE_LAMP")) {
            block.setType(Material.valueOf(lit ? "REDSTONE_LAMP_ON" : "REDSTONE_LAMP_OFF"), applyPhysics);
        } else if (name.startsWith("REDSTONE_TORCH")) {
            block.setType(Material.valueOf(lit ? "REDSTONE_TORCH_ON" : "REDSTONE_TORCH_OFF"), applyPhysics);
        }
    }

    @Override
    public void handle(Block block, BlockFormatData data, boolean applyPhysics) {
        getValue(data).ifPresent(value -> handle(block, value, applyPhysics));
    }
}
