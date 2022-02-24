package me.hsgamer.minigamemapcore.spigot.core.common.blockhandler;

import me.hsgamer.minigamemapcore.spigot.core.common.SingleValueFormatHandler;

public abstract class OpenFormatHandler implements SingleValueFormatHandler {
    @Override
    public String getKey() {
        return "open";
    }
}
