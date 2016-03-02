package application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import javax.annotation.PostConstruct;

/**
 * Created by Harry on 02/03/2016.
 */
@Service
public class TwitterListenerImpl implements TwitterListener {

    private TwitterNotifier twitterNotifier;

    @Autowired
    public TwitterListenerImpl(TwitterNotifier twitterNotifier) {
        this.twitterNotifier = twitterNotifier;
    }

    //region Public Methods

    @PostConstruct
    @Override
    public void listenToTwitterFeed() {

        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();

        twitterStream.addListener(new StatusListener(twitterNotifier));
        FilterQuery query = new FilterQuery();
        query.follow(705119353952460801L);
        twitterStream.filter(query);
    }

    //endregion

    //region Private Methods

    //endregion

}
