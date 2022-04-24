package no.breaks.netatmo.oauth;

import com.github.scribejava.core.builder.api.DefaultApi20;

public class NetatmoApi extends DefaultApi20 {
    public NetatmoApi() {
    }

    private static class InstanceHolder {
        private static final NetatmoApi INSTANCE = new NetatmoApi();
    }

    public static NetatmoApi instance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return "https://api.netatmo.com/oauth2/token";
    }

    @Override
    protected String getAuthorizationBaseUrl() {
        return "https://api.netatmo.com/api/";
    }
}
