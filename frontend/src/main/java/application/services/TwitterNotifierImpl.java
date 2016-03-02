package application.services;

import application.dto.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.DirectMessage;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * Created by Harry on 02/03/2016.
 */
@Service
public class TwitterNotifierImpl implements TwitterNotifier {

    private WeatherClient weatherClient;

    @Autowired
    public TwitterNotifierImpl(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @Override
    public void messageWeather() {

        Weather weather = weatherClient.getWeather();

        Twitter twitter = new TwitterFactory().getInstance();

        try {
            DirectMessage message = twitter.sendDirectMessage("Hazz223", weather.toString());
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

}
