package me.hsgamer.minigamemapcore.api.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RealPosition {
    private double x = 0;
    private double y = 0;
    private double z = 0;
    private double yaw = 0;
    private double pitch = 0;

    public static RealPosition fromString(String string) {
        String[] split = string.split(",", 5);
        RealPosition position = new RealPosition();
        position.setX(Double.parseDouble(split[0].trim()));
        position.setY(Double.parseDouble(split[1].trim()));
        position.setZ(Double.parseDouble(split[2].trim()));
        position.setYaw(Double.parseDouble(split[3].trim()));
        position.setPitch(Double.parseDouble(split[4].trim()));
        return position;
    }

    public String getAsString() {
        return x + "," + y + "," + z + "," + yaw + "," + pitch;
    }
}
