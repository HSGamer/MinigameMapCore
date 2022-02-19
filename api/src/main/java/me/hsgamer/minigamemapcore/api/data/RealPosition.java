package me.hsgamer.minigamemapcore.api.data;

import lombok.Data;

@Data
public class RealPosition {
    private double x = 0;
    private double y = 0;
    private double z = 0;
    private double yaw = 0;
    private double pitch = 0;

    public static RealPosition fromString(String string) {
        String[] split = string.split(",", 5);
        RealPosition position = new RealPosition();
        position.setX(Double.parseDouble(split[0]));
        position.setY(Double.parseDouble(split[1]));
        position.setZ(Double.parseDouble(split[2]));
        position.setYaw(Double.parseDouble(split[3]));
        position.setPitch(Double.parseDouble(split[4]));
        return position;
    }

    public String getAsString() {
        return x + "," + y + "," + z + "," + yaw + "," + pitch;
    }
}
