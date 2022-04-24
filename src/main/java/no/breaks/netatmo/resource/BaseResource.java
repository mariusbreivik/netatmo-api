package no.breaks.netatmo.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Verb;
import no.breaks.netatmo.NetatmoApiClient;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class BaseResource {

    protected static final String URL_BASE = "https://api.netatmo.com";
    private final NetatmoApiClient apiClient;

    private static final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    protected BaseResource(final NetatmoApiClient apiClient) {
        this.apiClient = apiClient;
    }

    protected <T> T getFromApi(String url, Verb verb, Class<T> clazz) {
        try {
            OAuthRequest request = new OAuthRequest(verb, url);

            apiClient.getOAuthService().signRequest(apiClient.getToken(), request);
            String body = apiClient.getOAuthService().execute(request).getBody();

            System.out.println(body);
            return mapper.readValue(body, clazz);

        } catch (InterruptedException | ExecutionException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
