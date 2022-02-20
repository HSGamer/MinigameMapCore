package me.hsgamer.minigamemapcore.api.setup;

import lombok.Getter;
import lombok.Setter;
import me.hsgamer.minigamemapcore.api.map.AbstractMap;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public abstract class AbstractMapSetupPool<T extends AbstractMap> {
    private final UUID uuid;
    private final List<T> maps = new ArrayList<>();
    @Setter
    private int clonePerMap = 1;

    protected AbstractMapSetupPool(UUID uuid) {
        this.uuid = uuid;
    }

    protected abstract AbstractMapSetup<T> createSetup();

    public void execute() {
        AbstractMapSetup<T> setup = createSetup();
        for (T map : maps) {
            for (int i = 0; i < clonePerMap; i++) {
                setup.setup(uuid, map, i);
            }
        }
    }
}
