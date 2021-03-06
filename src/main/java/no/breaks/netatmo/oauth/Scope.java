package no.breaks.netatmo.oauth;

public enum Scope {
    WRITE_THERMOSTAT("write_thermostat"),
    READ_THERMOSTAT("read_thermostat"),
    READ_STATION("read_station"),
    READ_CAMERA("read_camera"),
    WRITE_CAMERA("write_camera"),
    ACCESS_CAMERA("access_camera"),
    READ_PRESENCE("read_presence"),
    ACCESS_PRESENCE("access_presence"),
    READ_HOMECOACH("read_homecoach"),
    READ_SMOKEDETECTOR("read_smokedetector"),
    UNKNOWN("unknown");

    private final String name;

    Scope(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
