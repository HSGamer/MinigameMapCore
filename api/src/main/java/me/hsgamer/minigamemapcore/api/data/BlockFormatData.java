package me.hsgamer.minigamemapcore.api.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.hsgamer.hscore.common.Pair;
import me.hsgamer.minigamemapcore.api.utils.LegacyCompatibility;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlockFormatData {
    private String material = "minecraft:stone";
    private Map<String, Object> properties = Collections.emptyMap();

    public static BlockFormatData fromString(String string) {
        String[] split = string.split(";", 2);
        BlockFormatData data = new BlockFormatData();
        data.setMaterial(split[0]);
        if (split.length > 1 && !split[1].isBlank()) {
            data.setProperties(
                    Arrays.stream(split[1].split(","))
                            .map(property -> property.split("=", 2))
                            .collect(Collectors.toMap(property -> property[0], property -> property[1]))
            );
        }
        return data;
    }

    public Pair<Integer, Integer> getLegacyId() {
        return LegacyCompatibility.getMaterialLegacyId(material);
    }

    public String getPropertiesAsString() {
        return properties.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue().toString().toLowerCase(Locale.ROOT))
                .collect(Collectors.joining(","));
    }

    public String getAsString() {
        String propertiesString = getPropertiesAsString();
        return material + (propertiesString.isBlank() ? "" : ";" + propertiesString);
    }
}
