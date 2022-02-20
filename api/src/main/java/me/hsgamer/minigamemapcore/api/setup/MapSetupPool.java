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
    private final AbstractMapSetup<T> setup;
    @Setter
    private int clonePerMap = 1;

    public MapSetupPool(UUID uuid, AbstractMapSetup<T> setup) {
        this.uuid = uuid;
        this.setup = setup;
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
