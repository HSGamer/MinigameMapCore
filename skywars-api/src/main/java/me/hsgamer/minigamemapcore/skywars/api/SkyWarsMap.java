package me.hsgamer.minigamemapcore.skywars.api;

import lombok.Getter;
import me.hsgamer.minigamemapcore.api.handler.BlockPositionMapHandler;
import me.hsgamer.minigamemapcore.api.handler.BlockSchematicHandler;
import me.hsgamer.minigamemapcore.api.handler.RealPositionMapHandler;
import me.hsgamer.minigamemapcore.api.handler.StringMapHandler;
import me.hsgamer.minigamemapcore.api.map.AbstractMap;
import me.hsgamer.universaldatafile.TagSettings;
import me.hsgamer.universaldatafile.api.FormatReader;
import me.hsgamer.universaldatafile.api.FormatWriter;

import java.util.List;

@Getter
public class SkyWarsMap extends AbstractMap {
    public static final TagSettings TAG_SETTINGS = TagSettings.create("skywars");
    private final BlockSchematicHandler mapHandler = new BlockSchematicHandler("BlockSchematic");
    private final BlockPositionMapHandler chestHandler = new BlockPositionMapHandler("Chest");
    private final RealPositionMapHandler spawnHandler = new RealPositionMapHandler("Spawn");
    private final StringMapHandler optionHandler = new StringMapHandler("Option");

    public SkyWarsMap() {
        super(TAG_SETTINGS);
    }

    @Override
    protected List<FormatWriter> getFormatWriters() {
        return List.of(mapHandler, chestHandler, spawnHandler, optionHandler);
    }

    @Override
    protected List<FormatReader> getFormatReaders() {
        return List.of(mapHandler, chestHandler, spawnHandler, optionHandler);
    }
}
