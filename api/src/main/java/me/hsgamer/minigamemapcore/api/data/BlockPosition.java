package me.hsgamer.minigamemapcore.api.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlockPosition {
    private int x = 0;
    private int y = 0;
    private int z = 0;

    public static BlockPosition fromString(String string) {
        String[] split = string.split(",", 3);
        BlockPosition blockPosition = new BlockPosition();
        blockPosition.setX(Integer.parseInt(split[0]));
        blockPosition.setY(Integer.parseInt(split[1]));
        blockPosition.setZ(Integer.parseInt(split[2]));
        return blockPosition;
    }

    public String getAsString() {
        return x + "," + y + "," + z;
    }
}
