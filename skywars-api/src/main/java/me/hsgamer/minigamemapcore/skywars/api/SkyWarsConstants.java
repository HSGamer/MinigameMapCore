package me.hsgamer.minigamemapcore.skywars.api;

@SuppressWarnings("unused")
public final class SkyWarsConstants {
    private SkyWarsConstants() {
        // EMPTY
    }

    public static class Option {
        public static final String TEAM_SIZE = "team-size";
        public static final String MIN_TEAMS = "min-teams";
        public static final String MAX_TEAMS = "max-teams";
        public static final String DISPLAY_NAME = "display-name";
        public static final String MIN_POINT = "min-point";
        public static final String MAX_POINT = "max-point";

        private Option() {
            // EMPTY
        }
    }

    public static class Spawn {
        public static final String PLAYER_SPAWN = "player-spawn";
        public static final String SPECTATOR_SPAWN = "spectator-spawn";

        private Spawn() {
            // EMPTY
        }
    }
}
