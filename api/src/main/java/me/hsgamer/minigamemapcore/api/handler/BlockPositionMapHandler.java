package me.hsgamer.minigamemapcore.api.handler;

import lombok.Getter;
import me.hsgamer.minigamemapcore.api.data.BlockPosition;
import me.hsgamer.universaldatafile.api.FormatReader;
import me.hsgamer.universaldatafile.api.FormatWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BlockPositionMapHandler implements FormatWriter, FormatReader {
    private final String name;
    @Getter
    private final Map<BlockPosition, String> map = new HashMap<>();

    public BlockPositionMapHandler(String name) {
        this.name = name;
    }

    @Override
    public void read(List<String> list) {
        map.clear();
        list.forEach(s -> {
            String[] split = s.split(":", 2);
            if (split.length != 2) return;
            map.put(BlockPosition.fromString(split[0]), split[1]);
        });
    }

    @Override
    public List<String> write() {
        return map.entrySet().stream()
                .map(entry -> entry.getKey().getAsString() + ":" + entry.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public String getName() {
        return name;
    }
}
