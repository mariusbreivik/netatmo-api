package no.breaks.netatmo.config;

import java.util.Objects;

public class NetatmoConfiguration {

    private final String clientId;
    private final String clientSecret;
    private final String username;
    private final String password;

    public NetatmoConfiguration(String clientId, String clientSecret, String username, String password) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.username = username;
        this.password = password;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "NetatmoConfiguration{" +
                "clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetatmoConfiguration that = (NetatmoConfiguration) o;
        return getClientId().equals(that.getClientId()) && getClientSecret().equals(that.getClientSecret()) && getUsername().equals(that.getUsername()) && getPassword().equals(that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientId(), getClientSecret(), getUsername(), getPassword());
    }
}
