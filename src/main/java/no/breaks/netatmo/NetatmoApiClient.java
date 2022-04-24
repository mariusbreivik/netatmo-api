package no.breaks.netatmo;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.github.scribejava.httpclient.okhttp.OkHttpHttpClient;
import no.breaks.netatmo.config.NetatmoConfiguration;
import no.breaks.netatmo.oauth.NetatmoApi;
import no.breaks.netatmo.resource.weather.WeatherResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class NetatmoApiClient {

    private Logger logger = LoggerFactory.getLogger(NetatmoApiClient.class);

    private final WeatherResource weatherResource;
    private final OkHttpHttpClient httpClient;
    private final OAuth20Service oAuthService;
    private final OAuth2AccessToken token;

    public NetatmoApiClient(NetatmoConfiguration configuration) {
        this.httpClient = generateHttpClient();
        this.oAuthService = createOAuthService(configuration);
        this.token = getTokenFromNetatmo(configuration);

        weatherResource = new WeatherResource(this);
    }

    public WeatherResource weatherResource() {
        return weatherResource;
    }

    public String getToken() {
        return token.getAccessToken();
    }

    public OAuth20Service getOAuthService() {
        return oAuthService;
    }

    private OAuth2AccessToken getTokenFromNetatmo(NetatmoConfiguration configuration) {
        try {
            return oAuthService.getAccessTokenPasswordGrant(configuration.getUsername(), configuration.getPassword());
        } catch (IOException | InterruptedException | ExecutionException e) {
            logger.error("An error occurred while retrieving a token from netatmo: - {}", e.getMessage());
        }
        return null;
    }

    private OAuth20Service createOAuthService(NetatmoConfiguration configuration) {
        return new ServiceBuilder(configuration.getClientId())
                .httpClient(httpClient)
                .debug()
                .apiSecret(configuration.getClientSecret())
                .defaultScope("read_station")
                .build(NetatmoApi.instance());
    }

    private OkHttpHttpClient generateHttpClient() {
        return new OkHttpHttpClient();
    }
}
