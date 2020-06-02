package com.eternal.weatherAPP;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class MainController {
    private Session session;

    @GetMapping("/")
    public String showPage() {
        return "main";
    }

    @PostMapping("/main")
    public String showWeather(@RequestParam(value = "cityId", required = false) String cityId, HttpSession session) throws IOException {
        if (!cityId.equals("")) {
            WeatherService weatherService = new WeatherService(cityId);
            Weather weather = weatherService.getWeather();
            weather.retrieveData();
            session.setAttribute("weather",weather);
        }
        return "redirect:/";
    }
}
