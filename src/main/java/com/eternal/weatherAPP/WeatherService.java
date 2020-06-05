package com.eternal.weatherAPP;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WeatherService {
    private URL weatherAPI;
    private final String apiKey = "44fcd990d8a0bb63023f305ef3ed9894";

    public WeatherService(String cityCode) throws MalformedURLException {
        initiateURI(cityCode);
    }

    private void initiateURI(String cityCode) throws MalformedURLException {
        weatherAPI = UriComponentsBuilder.fromUriString("https://api.openweathermap.org/data/2.5/weather")
                .queryParam("id", cityCode)
                .queryParam("units", "metric")
                .queryParam("appid", apiKey)
                .build().toUri().toURL();
    }

    private String getWeatherData() throws IOException {
        URLConnection conn = weatherAPI.openConnection();
        String response = "";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            response = bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public Weather getWeather() throws IOException {
        String weatherData = getWeatherData();
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(weatherData, Weather.class);
    }
}
