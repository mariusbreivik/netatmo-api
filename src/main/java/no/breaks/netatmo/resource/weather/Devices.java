package no.breaks.netatmo.resource.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Devices {

    @JsonProperty("firmware")
    private String firmware;

    @JsonProperty("wifi_status")
    private int wifiStatus;

    @JsonProperty("reachable")
    private boolean reachable;

    @JsonProperty("co2_calibrating")
    private boolean co2Calibrating;


}
