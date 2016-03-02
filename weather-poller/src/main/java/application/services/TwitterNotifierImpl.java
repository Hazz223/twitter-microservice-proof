package application.services;

import org.springframework.stereotype.Service;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.Date;

/**
 * Created by Harry on 02/03/2016.
 */
@Service
public class TwitterNotifierImpl implements TwitterNotifier {


    //region Public Methods

    @Override
    public void tweetWeatherChange() throws TwitterException {

        Twitter twitter = TwitterFactory.getSingleton();
        Status status = twitter.updateStatus("#wp_u - Weather has received update " + new Date());
        System.out.println("Updated Twitter");
    }

    //endregion

}
