package no.breaks.netatmo.resource.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.jvm.JvmOverloads;

import java.util.List;

public class StationBody {

    @JsonProperty("devices")
    private List<Devices> devices;
}
