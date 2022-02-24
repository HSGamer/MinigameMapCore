package me.hsgamer.minigamemapcore.spigot.core.common.adapter;

import me.hsgamer.minigamemapcore.api.data.BlockPosition;
import me.hsgamer.minigamemapcore.api.data.RealPosition;
import org.bukkit.Location;
import org.bukkit.World;

public final class SpigotAdapter {
    private SpigotAdapter() {
        // EMPTY
    }

    public static Location adapt(World world, BlockPosition position) {
        return new Location(world, position.getX(), position.getY(), position.getZ());
    }

    public static Location adapt(World world, RealPosition position) {
        return new Location(world, position.getX(), position.getY(), position.getZ(), position.getYaw(), position.getPitch());
    }
}
