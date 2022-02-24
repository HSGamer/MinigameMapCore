package me.hsgamer.minigamemapcore.spigot.core.common.blockhandler;

import me.hsgamer.minigamemapcore.spigot.core.common.SingleValueFormatHandler;

public abstract class SlabTypeFormatHandler implements SingleValueFormatHandler {
    @Override
    public String getKey() {
        return "type";
    }
}
