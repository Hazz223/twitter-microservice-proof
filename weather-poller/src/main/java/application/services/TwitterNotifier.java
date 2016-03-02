package application.services;

import twitter4j.TwitterException;

/**
 * Created by Harry on 02/03/2016.
 */
public interface TwitterNotifier {

    void tweetWeatherChange() throws TwitterException;
}
