package me.hsgamer.minigamemapcore.api.utils;

import me.hsgamer.hscore.collections.map.CaseInsensitiveStringHashMap;
import me.hsgamer.hscore.common.Pair;

import java.util.Map;

public final class LegacyCompatibility {
    private static final Pair<Integer, Integer> DEFAULT_LEGACY_ID = Pair.of(0, 0);
    private static final Map<String, Pair<Integer, Integer>> materialLegacyIdMap = new CaseInsensitiveStringHashMap<>();

    private LegacyCompatibility() {
        // EMPTY
    }

    public static void addMaterialLegacyId(String material, int legacyId, int legacyData, boolean override) {
        if (override) {
            materialLegacyIdMap.put(material, Pair.of(legacyId, legacyData));
        } else {
            materialLegacyIdMap.computeIfAbsent(material, k -> Pair.of(legacyId, legacyData));
        }
    }

    public static void addMaterialLegacyId(String material, int legacyId, int legacyData) {
        addMaterialLegacyId(material, legacyId, legacyData, false);
    }

    public static boolean containsMaterialLegacyId(String material) {
        return materialLegacyIdMap.containsKey(material);
    }

    public static Pair<Integer, Integer> getMaterialLegacyId(String material) {
        return materialLegacyIdMap.getOrDefault(material, DEFAULT_LEGACY_ID);
    }
}
