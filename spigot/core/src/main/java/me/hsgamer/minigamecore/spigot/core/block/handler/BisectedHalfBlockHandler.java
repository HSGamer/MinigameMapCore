package me.hsgamer.minigamecore.spigot.core.block.handler;

import com.cryptomorin.xseries.XMaterial;
import me.hsgamer.minigamecore.spigot.core.block.BlockDataHandler;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.BlockData;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Stairs;
import org.bukkit.material.TrapDoor;

import java.util.Locale;

@SuppressWarnings("deprecation")
public class BisectedHalfBlockHandler implements BlockDataHandler {
    @Override
    public void handle(Block block, BlockFormatData data) {
        Object objHalf = data.getProperties().get("half");
        if (objHalf == null) return;
        String half = objHalf.toString();
        if (XMaterial.supports(13)) {
            BlockData blockData = block.getBlockData();
            if (blockData instanceof Bisected) {
                Bisected.Half type = Bisected.Half.valueOf(half.toUpperCase(Locale.ROOT));
                ((Bisected) blockData).setHalf(type);
            }
        } else {
            boolean inverted = half.equalsIgnoreCase("top");
            BlockState blockState = block.getState();
            MaterialData materialData = blockState.getData();
            if (materialData instanceof Stairs) {
                Stairs stairs = (Stairs) materialData;
                stairs.setInverted(inverted);
                blockState.setData(stairs);
                blockState.update(true);
            } else if (materialData instanceof TrapDoor) {
                TrapDoor trapDoor = (TrapDoor) materialData;
                trapDoor.setInverted(inverted);
                blockState.setData(trapDoor);
                blockState.update(true);
            }
        }
    }
}
