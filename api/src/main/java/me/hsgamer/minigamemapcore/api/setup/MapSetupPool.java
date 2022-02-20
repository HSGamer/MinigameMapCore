package me.hsgamer.minigamemapcore.api.setup;

import lombok.Getter;
import lombok.Setter;
import me.hsgamer.minigamemapcore.api.map.AbstractMap;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class MapSetupPool<T extends AbstractMap> {
    private final UUID uuid;
    private final List<T> maps = new ArrayList<>();
    @Setter
    private int clonePerMap = 1;
    @Setter
    private AbstractMapSetup<T> setup;

    public MapSetupPool(UUID uuid) {
        this.uuid = uuid;
    }

    public void execute() {
        if (setup == null) {
            throw new NullPointerException("Setup is null");
        }
        for (T map : maps) {
            for (int i = 0; i < clonePerMap; i++) {
                setup.setup(uuid, map, i);
            }
        }
    }
}
