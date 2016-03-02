package application.services;

import application.web.dto.WeatherDto;

import java.util.List;

/**
 * Created by Harry on 02/03/2016.
 */
public interface WeatherService {

    WeatherDto getCurrentWeather();

    List<WeatherDto> getAllWeather();

}
