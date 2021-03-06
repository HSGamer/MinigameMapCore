package me.hsgamer.minigamemapcore.api.handler;

import lombok.Getter;
import me.hsgamer.minigamemapcore.api.data.BlockFormatData;
import me.hsgamer.minigamemapcore.api.data.BlockPosition;
import me.hsgamer.universaldatafile.api.FormatReader;
import me.hsgamer.universaldatafile.api.FormatWriter;

import java.util.*;

public class BlockSchematicHandler implements FormatWriter, FormatReader {
    private final String name;
    @Getter
    private final Map<BlockPosition, BlockFormatData> map = new HashMap<>();

    public BlockSchematicHandler(String name) {
        this.name = name;
    }

    @Override
    public void read(List<String> list) {
        map.clear();
        List<String> palette = new ArrayList<>();
        boolean isPalette = true;
        for (String string : list) {
            if (string.equals("~")) {
                isPalette = false;
                continue;
            }
            if (isPalette) {
                palette.add(string);
            } else {
                String[] split = string.split(":", 2);
                BlockPosition blockPosition = BlockPosition.fromString(split[0]);
                String paletteData = palette.get(Integer.parseInt(split[1]));
                BlockFormatData blockFormatData = BlockFormatData.fromString(paletteData);
                map.put(blockPosition, blockFormatData);
            }
        }
    }

    @Override
    public List<String> write() {
        List<String> strings = new ArrayList<>();
        HashSet<String> filtered = new HashSet<>();
        Map<String, Integer> palette = new HashMap<>();
        map.values().forEach(blockFormatData -> filtered.add(blockFormatData.getAsString()));
        int index = 0;
        for (String string : filtered) {
            palette.put(string, index);
            strings.add(string);
            index++;
        }
        strings.add("~");
        map.forEach((blockPosition, blockFormatData) -> strings.add(blockPosition.getAsString() + ":" + palette.get(blockFormatData.getAsString())));
        return strings;
    }

    @Override
    public String getName() {
        return name;
    }
}
