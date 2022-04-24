package no.breaks.netatmo.resource.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class StationData {

    @JsonProperty("status")
    private String status;

    @JsonProperty("time_server")
    private String timer_server;

    @JsonProperty("body")
    private StationBody body;
}
