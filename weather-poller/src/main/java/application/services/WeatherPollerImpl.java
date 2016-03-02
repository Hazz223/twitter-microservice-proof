package application.services;

import application.domain.Weather;
import application.domain.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import twitter4j.TwitterException;

import java.util.Date;

/**
 * Created by Harry on 02/03/2016.
 */
@Service
public class WeatherPollerImpl implements WeatherPoller {

    private WeatherRepository weatherRepository;
    private TwitterNotifier twitterNotifier;

    //region Public Methods

    @Autowired
    public WeatherPollerImpl(WeatherRepository weatherRepository, TwitterNotifier twitterNotifier) {
        this.weatherRepository = weatherRepository;
        this.twitterNotifier = twitterNotifier;
    }

    @Scheduled(fixedDelay = 120000) // updates once every 2 minutes
    @Override
    public void pollWeather() {

        System.out.println("Polling...");

        Weather weather = new Weather();

        weather.setMain("Sunny");
        weather.setDescription("It's rather nice outside...");
        weather.setWindDirection("Sideways");
        weather.setWindSpeed("All the speed");
        weather.setUpdateDate(new Date());
        weather.setTemperature("Depends on the A/C");

        this.weatherRepository.save(weather);

        System.out.println("...Finished polling");

        try {
            this.twitterNotifier.tweetWeatherChange();
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    //endregion
}
