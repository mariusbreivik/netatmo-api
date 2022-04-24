# netatmo-api


- [📖 describe()](#-describe)
- [📜 prerequisites()](#-prerequisites)
- [💾 use()](#-use)

## 📖 describe()
`netatmo-api` is a lightweight api written in java. It's mostly just for fun, but the purpose is retrieving from netatmo apis.


 </br>

## 📜 prerequisites()
* You need to have your own [Netatmo Weather Station](https://www.netatmo.com/en-eu/weather/weatherstation) in order to use this CLI
* Sign up at [netatmo](https://dev.netatmo.com/apps/) and create an app to get `clientId` and `clientSecret` in order to retrieve data from your Netatmo Weateher Station through the API.

</br>

## 💾 use()

```java
final NetatmoConfiguration config = new NetatmoConfiguration(
        "YOUR_NETATMO_CLIENTID",
        "YOUR_NETATM_CLIENTSECRET",
        "YOUR_NETATMO_USERNAME",
        "YOUR_NETATMO_PASSWORD");

final NetatmoApiClient client = new NetatmoApiClient(config);

final WeatherResource weatherResource = apiClient.weatherResource();
final StationData stationData = weatherResource.getStationData();

```