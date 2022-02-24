package me.hsgamer.minigamemapcore.spigot.core.common.blockhandler;

import me.hsgamer.minigamemapcore.spigot.core.common.SingleValueBlockHandler;

public abstract class LitBlockHandler implements SingleValueBlockHandler {
    @Override
    public String getKey() {
        return "lit";
    }
}
