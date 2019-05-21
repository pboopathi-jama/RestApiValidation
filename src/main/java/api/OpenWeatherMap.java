package api;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class OpenWeatherMap {

    private static final Object API_KEY = "be89a2b8fe4c119e386b348dda4c250c";
    public static final String OPEN_WEATHER_MAP_GET_WEATHER = "OpenWeatherMapGetWeather";
    public static OpenWeatherMap instance = new OpenWeatherMap();

    private static final String END_POINT = "http://api.openweathermap.org";

    private static final String WEATHER_DATA = "data/2.5";

    private static final String CURRENT_WEATHER = "weather";
   // private static final String FORECAST = "forecast";

    private OpenWeatherMap() {}

    private UriBuilder getWeatherMapDataBaseUrl(String queryType){
        return  UriBuilder.fromPath(END_POINT)
                .path(WEATHER_DATA)
                .path(queryType)
                .queryParam("APPID", API_KEY);
    }

    private String buildSearchQuery(UriBuilder builder, String query)
    {
        return builder
                .queryParam("q", query)
                .build()
                .toString();
    }

    public String getCurrentWeatherUrl(String city)
    {
        return buildSearchQuery(getWeatherMapDataBaseUrl(CURRENT_WEATHER), city);
    }
}
