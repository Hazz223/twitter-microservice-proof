package application.services;

import application.domain.WeatherRepository;
import application.web.dto.WeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Harry on 02/03/2016.
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    private WeatherRepository weatherRepository;
    private WeatherToDoConverter converter;

    //region Public Methods

    @Autowired
    public WeatherServiceImpl(WeatherRepository weatherRepository, WeatherToDoConverter converter) {
        this.weatherRepository = weatherRepository;
        this.converter = converter;
    }

    @Override
    public WeatherDto getCurrentWeather() {

        return this.converter.convert(this.weatherRepository.findAll().get(0)); // todo: fix this!!!!
    }

    @Override
    public List<WeatherDto> getAllWeather() {

        return this.weatherRepository.findAll().stream().map(weather -> this.converter.convert(weather)).collect(Collectors.toList());
    }

    //endregion

}
