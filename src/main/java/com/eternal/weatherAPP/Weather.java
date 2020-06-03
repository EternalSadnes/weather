package com.eternal.weatherAPP;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Weather {
    @SerializedName("weather")
    private final List<Map<String, String>> weather = new ArrayList<>();
    @SerializedName("main")
    private final Map<String, String> mainData = new HashMap<>();
    @SerializedName("wind")
    private final Map<String, String> windData = new HashMap<>();
    @SerializedName("clouds")
    private final Map<String, String> cloudsData = new HashMap<>();
    private String visibility;
    @SerializedName("name")
    private String city;

    public String getVisibility() {
        return visibility;
    }

    public String getCity() {
        return city;
    }

    public String getWind() {
        return windData.get("speed");
    }

    public String getClouds() {
        return cloudsData.get("all");
    }

    public String getDescription() {
        return weather.get(0).get("description");
    }

    public String getTemperature() {
        return mainData.get("temp");
    }

    public String getPressure() {
        return mainData.get("pressure");
    }

    public String getHumidity() {
        return mainData.get("humidity");
    }


}
