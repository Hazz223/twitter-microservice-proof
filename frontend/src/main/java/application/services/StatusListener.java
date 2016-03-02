package application.services;

import twitter4j.HashtagEntity;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;

/**
 * Created by Harry on 02/03/2016.
 */
public class StatusListener implements twitter4j.StatusListener{

    private TwitterNotifier twitterNotifier;

    public StatusListener(TwitterNotifier twitterNotifier) {
        this.twitterNotifier = twitterNotifier;
    }

    @Override
    public void onStatus(Status status) {

        HashtagEntity[] hashtagEntities = status.getHashtagEntities();
        for (HashtagEntity hashtagEntity : hashtagEntities) {
            if("wp_u".contains(hashtagEntity.getText())){
                this.twitterNotifier.messageWeather();
            }
        }
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

    }

    @Override
    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {

    }

    @Override
    public void onScrubGeo(long userId, long upToStatusId) {

    }

    @Override
    public void onStallWarning(StallWarning warning) {

    }

    @Override
    public void onException(Exception ex) {

    }
}
