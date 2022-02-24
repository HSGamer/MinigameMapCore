package me.hsgamer.minigamemapcore.spigot.core.common.blockhandler;

public abstract class WaterLevelBlockHandler implements SingleValueBlockHandler {
    @Override
    public String getKey() {
        return "level";
    }
}
