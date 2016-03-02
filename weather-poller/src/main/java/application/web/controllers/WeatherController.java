package application.web.controllers;

import application.services.WeatherService;
import application.web.dto.WeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Harry on 29/12/2015.
 */
@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    //region Public Methods

    @RequestMapping(value = "/weather", method = RequestMethod.GET)
    public WeatherDto getCurrentWeather() {

        return this.weatherService.getCurrentWeather();
    }

    @RequestMapping(value = "/weather/all", method = RequestMethod.GET)
    public List<WeatherDto> getAllWeather() {

        return this.weatherService.getAllWeather();
    }

    //endregion

    //region Private Methods

    //endregion

}
