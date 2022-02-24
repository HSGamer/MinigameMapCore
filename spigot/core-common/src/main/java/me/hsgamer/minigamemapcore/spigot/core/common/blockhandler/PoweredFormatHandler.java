package me.hsgamer.minigamemapcore.spigot.core.common.blockhandler;

import me.hsgamer.minigamemapcore.spigot.core.common.SingleValueFormatHandler;

public abstract class PoweredFormatHandler implements SingleValueFormatHandler {
    @Override
    public String getKey() {
        return "powered";
    }
}