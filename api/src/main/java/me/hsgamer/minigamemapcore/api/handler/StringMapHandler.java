package me.hsgamer.minigamemapcore.api.handler;

import lombok.Getter;
import me.hsgamer.hscore.collections.map.CaseInsensitiveStringHashMap;
import me.hsgamer.universaldatafile.api.FormatReader;
import me.hsgamer.universaldatafile.api.FormatWriter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringMapHandler implements FormatWriter, FormatReader {
    private final String name;
    @Getter
    private final Map<String, String> map = new CaseInsensitiveStringHashMap<>();

    public StringMapHandler(String name) {
        this.name = name;
    }

    @Override
    public void read(List<String> list) {
        map.clear();
        list.stream()
                .map(s -> s.split(":", 2))
                .filter(split -> split.length == 2)
                .forEach(split -> map.put(split[0], split[1]));
    }

    @Override
    public List<String> write() {
        return map.entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public String getName() {
        return name;
    }
}
