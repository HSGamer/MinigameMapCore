package me.hsgamer.minigamecore.spigot.core.block.handler.common;

public abstract class WaterLevelBlockHandler implements SingleValueBlockDataHandler {
    @Override
    public String getKey() {
        return "level";
    }
}
