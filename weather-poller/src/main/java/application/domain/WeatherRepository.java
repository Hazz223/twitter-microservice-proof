package application.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Harry on 02/03/2016.
 */
public interface WeatherRepository extends MongoRepository<Weather, String> {

}
