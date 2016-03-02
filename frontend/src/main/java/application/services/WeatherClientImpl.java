package application.services;

import application.dto.Weather;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

/**
 * Created by Harry on 02/03/2016.
 */
@Component
public class WeatherClientImpl implements WeatherClient {


    //region Public Methods

    @Override
    public Weather getWeather() {

        Invocation.Builder weatherRequest = this.createWeatherRequest();

        Optional<Weather> weather = Optional.empty();
        try{
            weather = Optional.of(weatherRequest.get(Weather.class));
        }catch (WebApplicationException ex){
            ex.printStackTrace();
        }

        return weather.orElseThrow(()-> new IllegalStateException("No weather found"));
    }

    //endregion


    private Invocation.Builder createWeatherRequest() {
        Client client = ClientBuilder.newBuilder()
                .register(JacksonFeature.class)
                .build();

        String hostAndPort = "http://localhost:80";
        WebTarget webTarget = client.target(hostAndPort);
        WebTarget weatherTarget = webTarget.path("weather");

        return weatherTarget.request(MediaType.APPLICATION_JSON);
    }
}
