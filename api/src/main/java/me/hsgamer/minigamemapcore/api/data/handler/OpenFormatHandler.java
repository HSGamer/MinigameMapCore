package me.hsgamer.minigamemapcore.api.data.handler;

public abstract class OpenFormatHandler implements SingleValueFormatHandler {
    @Override
    public String getKey() {
        return "open";
    }
}
