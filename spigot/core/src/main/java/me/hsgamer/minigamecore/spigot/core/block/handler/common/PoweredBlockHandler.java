package me.hsgamer.minigamecore.spigot.core.block.handler.common;

public abstract class PoweredBlockHandler implements SingleValueBlockDataHandler {
    @Override
    public String getKey() {
        return "powered";
    }
}
