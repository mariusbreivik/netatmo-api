package no.breaks.netatmo;

import no.breaks.netatmo.config.NetatmoConfiguration;
import no.breaks.netatmo.resource.weather.StationData;
import no.breaks.netatmo.resource.weather.WeatherResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NetatmoApiClientTest {

    private NetatmoApiClient apiClient;

    @BeforeEach
    void setUp() {
        NetatmoConfiguration configuration = new NetatmoConfiguration(
                "",
                "",
                "",
                "");

        apiClient = new NetatmoApiClient(configuration);
    }

    @Test
    void weatherResource() {
        WeatherResource weatherResource = apiClient.weatherResource();
        StationData stationData = weatherResource.getStationData();
        System.out.println(stationData);
    }
}