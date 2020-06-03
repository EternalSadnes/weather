package com.eternal.weatherAPP;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class MainController {

    @GetMapping("/")
    public String showPage(Model model) {
        Cities cities = new Cities();
        model.addAttribute("cities", cities.getCities());
        return "main";
    }

    @PostMapping("/main")
    public String showWeather(@RequestParam(value = "cityId", required = false) String cityId, HttpSession session) throws IOException {
        if (!cityId.equals("")) {
            WeatherService weatherService = new WeatherService(cityId);
            Weather weather = weatherService.getWeather();
            session.setAttribute("weather", weather);
        }
        return "redirect:/";
    }
}
