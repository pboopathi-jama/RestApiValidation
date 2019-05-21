package client;

import api.OpenWeatherMap;
import bean.openweathermap.OpenWeatherMapWeather;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;

public class RestClient {

    public static RestClient instance = new RestClient();

    private RestClient() {}

    public OpenWeatherMapWeather getOpeWeatherMapByCity(String city) {
        return getInvocationBuilder(OpenWeatherMap.instance.getCurrentWeatherUrl(city))
                .get(OpenWeatherMapWeather.class);
    }

    private Invocation.Builder getInvocationBuilder(String url) {
        return ClientBuilder.newClient()
                .target(url)
                .request(MediaType.APPLICATION_JSON);
    }
}
