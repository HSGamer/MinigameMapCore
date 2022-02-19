package me.hsgamer.minigamemapcore.skywars.api;

import lombok.Getter;
import me.hsgamer.minigamemapcore.api.handler.BlockPositionMapHandler;
import me.hsgamer.minigamemapcore.api.handler.BlockSchematicHandler;
import me.hsgamer.minigamemapcore.api.handler.RealPositionMapHandler;
import me.hsgamer.minigamemapcore.api.handler.StringMapHandler;
import me.hsgamer.universaldatafile.TagSettings;
import me.hsgamer.universaldatafile.UniversalDataReader;
import me.hsgamer.universaldatafile.UniversalDataWriter;

import java.io.File;
import java.util.concurrent.CompletableFuture;

@Getter
public class SkyWarsMap {
    public static final TagSettings TAG_SETTINGS = TagSettings.create("skywars");
    private final String name;
    private final BlockSchematicHandler mapHandler = new BlockSchematicHandler("BlockSchematic");
    private final BlockPositionMapHandler chestHandler = new BlockPositionMapHandler("Chest");
    private final RealPositionMapHandler spawnHandler = new RealPositionMapHandler("Spawn");
    private final StringMapHandler optionHandler = new StringMapHandler("Option");

    public SkyWarsMap(String name) {
        this.name = name;
    }

    protected void apply(UniversalDataReader reader) {
        reader.setFile(new File(name + ".skywarsmap"));
    }

    protected void apply(UniversalDataWriter writer) {
        writer.setFile(new File(name + ".skywarsmap"));
    }

    public CompletableFuture<Void> write() {
        UniversalDataWriter writer = TAG_SETTINGS.newWriter();
        apply(writer);
        return writer
                .addFormatWriter(mapHandler)
                .addFormatWriter(chestHandler)
                .addFormatWriter(spawnHandler)
                .addFormatWriter(optionHandler)
                .setLimitRunningPool(1)
                .write();
    }

    public CompletableFuture<Void> read() {
        UniversalDataReader reader = TAG_SETTINGS.newReader();
        apply(reader);
        return reader
                .addFormatReader(mapHandler)
                .addFormatReader(chestHandler)
                .addFormatReader(spawnHandler)
                .addFormatReader(optionHandler)
                .setLimitRunningPool(1)
                .read();
    }
}
