package me.hsgamer.minigamemapcore.spigot.core.common.blockhandler;

public abstract class OpenBlockHandler implements SingleValueBlockHandler {
    @Override
    public String getKey() {
        return "open";
    }
}
