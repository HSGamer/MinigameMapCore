package me.hsgamer.minigamemapcore.spigot.core.common.blockhandler;

public abstract class PoweredBlockHandler implements SingleValueBlockHandler {
    @Override
    public String getKey() {
        return "powered";
    }
}
