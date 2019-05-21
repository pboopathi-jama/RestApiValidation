package Util;

import bean.openweathermap.OpenWeatherMapWeather;
import client.RestClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class RestClientUtil {

    public static void writeOpenWeatherMapByCity(String outputFilePath, String city)
    {
        OpenWeatherMapWeather portlandWeather = RestClient.instance.getOpeWeatherMapByCity(city);
        writeToFile(outputFilePath, portlandWeather);
    }

    private static void writeToFile(String outputFilePath, Object object)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String output = objectMapper.writeValueAsString(object);
            System.out.println(output);
            objectMapper.writeValue
                    (new File(outputFilePath), object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
