import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WeatherForecastTest {
    WeatherApiService weatherApiService;
    CacheService cacheService;
    WeatherForecast forecast;

    // set up mocks before each test
    @BeforeEach
    void setup() {
        weatherApiService = mock(WeatherApiService.class);
        cacheService = mock(CacheService.class);

        forecast = new WeatherForecast(weatherApiService, cacheService);
    }

    @Test
    void testEmptyCityName() {
        // set up forecast
        assertNull(forecast.getForecast(null));
        assertNull(forecast.getForecast(""));
    }

    // tests that the cache is called in each request
    @Test
    void testCacheGetsCalledEachTime() {
        String[] cities = {"Zurich", "Geneva", "Basel", "Vancouver", "Seattle"};
        List<ForecastDetails> forecastDetails = new ArrayList<>();

        // get forecast for each city
        for(String city: cities) {
            ForecastDetails details = forecast.getForecast(city);
            forecastDetails.add(details);
        }

        // verify that each city has been looked for exactly once in the cache
        for(String city: cities) {
            verify(cacheService, times(1)).getDetails(city);
        }
    }

    // tests that the API is only called if nothing is in cache
    @Test
    void testAPICalledOnlyIfNothingInCache() {
        String[] cities = {"Zurich", "Geneva", "Zurich", "Vancouver", "Seattle"};

        // here, we mock the cache for Zurich. 1st time: return null, 2nd time: return cached ForecastDetails
        when(cacheService.getDetails("Zurich")).thenReturn(
                null,
                new ForecastDetails("Zurich", new WeatherData("Zurich", "sunny"))
        );

        // get forecast for each city
        for(String city: cities) {
            ForecastDetails details = forecast.getForecast(city);
        }

        // check that the API is only called once for each city (since Zurich should be in cache the 2nd time)
        for(String city: cities) {
            verify(weatherApiService, times(1)).retrieveWeather(city);
        }
    }

    // tests that the API is down -> throw exception
    @Test
    void testAPIDown() {
        // throw an exception when the API retrieve weather function is called
        when(weatherApiService.retrieveWeather(anyString())).thenThrow(new RuntimeException());

        // check that a RuntimeException is thrown with the message "Failed to retrieve weather forecast"
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> forecast.getForecast("Zurich")
        );
        assertEquals("Failed to retrieve weather forecast", exception.getMessage());
    }

    // doubles the API
    @Test
    void testAPIWorks() {
        // set up weather data & return these via API
        WeatherData zurich = new WeatherData("Zurich", "sunny");
        WeatherData basel = new WeatherData("Basel", "cloudy");

        when(weatherApiService.retrieveWeather("Zurich")).thenReturn(zurich);
        when(weatherApiService.retrieveWeather("Basel")).thenReturn(basel);

        // check the returned values
        assertEquals("Zurich", forecast.getForecast("Zurich").getWeatherData().getCityName());
        assertEquals("sunny", forecast.getForecast("Zurich").getWeatherData().getForecast());

        assertEquals("Basel", forecast.getForecast("Basel").getWeatherData().getCityName());
        assertEquals("cloudy", forecast.getForecast("Basel").getWeatherData().getForecast());
    }
}
