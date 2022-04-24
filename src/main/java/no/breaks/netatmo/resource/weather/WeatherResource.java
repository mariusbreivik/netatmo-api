package no.breaks.netatmo.resource.weather;

import no.breaks.netatmo.NetatmoApiClient;
import no.breaks.netatmo.resource.BaseResource;

import static com.github.scribejava.core.model.Verb.GET;

public class WeatherResource extends BaseResource {

    private static final String URL_GET_STATIONS_DATA = URL_BASE + "/api/getstationsdata?get_favorites=false";

    public WeatherResource(NetatmoApiClient netatmoApiClient) {
        super(netatmoApiClient);
    }

    public StationData getStationData() {
        return getFromApi(URL_GET_STATIONS_DATA, GET, StationData.class);
    }
}
