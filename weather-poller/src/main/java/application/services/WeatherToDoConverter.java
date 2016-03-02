package application.services;

import application.domain.Weather;
import application.web.dto.WeatherDto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Harry on 02/03/2016.
 */
@Component
public class WeatherToDoConverter implements Converter<Weather, WeatherDto> {

    //region Public Methods

    @Override
    public WeatherDto convert(Weather source) {
        WeatherDto weatherDto = new WeatherDto();

        weatherDto.setMain(source.getMain());
        weatherDto.setDescription(source.getDescription());
        weatherDto.setTemperature(source.getTemperature());
        weatherDto.setUpdateDate(source.getUpdateDate());
        weatherDto.setWindDirection(source.getWindDirection());
        weatherDto.setWindSpeed(source.getWindSpeed());

        return weatherDto;
    }


    //endregion

    //region Private Methods

    //endregion

}
