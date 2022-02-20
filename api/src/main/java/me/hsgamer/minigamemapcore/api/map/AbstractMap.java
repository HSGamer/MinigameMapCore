package me.hsgamer.minigamemapcore.api.map;

import me.hsgamer.universaldatafile.TagSettings;
import me.hsgamer.universaldatafile.UniversalDataReader;
import me.hsgamer.universaldatafile.UniversalDataWriter;
import me.hsgamer.universaldatafile.api.FormatReader;
import me.hsgamer.universaldatafile.api.FormatWriter;

import java.util.List;

public abstract class AbstractMap {
    private final TagSettings settings;

    protected AbstractMap(TagSettings settings) {
        this.settings = settings;
    }

    protected abstract List<FormatWriter> getFormatWriters();

    protected abstract List<FormatReader> getFormatReaders();

    public UniversalDataWriter createWriter() {
        return settings.newWriter()
                .addFormatWriter(getFormatWriters())
                .setLimitRunningPool(1);
    }

    public UniversalDataReader createReader() {
        return settings.newReader()
                .addFormatReader(getFormatReaders())
                .setLimitRunningPool(1);
    }
}
