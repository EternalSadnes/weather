package com.eternal.weatherAPP;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Weather {
    @SerializedName("weather")
    private List<Map<String, String>> weather = new ArrayList<>();
    @SerializedName("main")
    private Map<String, String> mainData = new HashMap<>();
    private String description;
    private String temperature;
    private String pressure;
    private String humidity;

    public void retrieveData(){
        description = weather.get(0).get("description");
        temperature = mainData.get("temp");
        pressure = mainData.get("pressure");
        humidity = mainData.get("humidity");
    }

    public String getDescription() {
        return description;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setWeather(List<Map<String, String>> weather) {
        this.weather = weather;
    }

    public void setMainData(Map<String, String> mainData) {
        this.mainData = mainData;
    }

}
