public interface WeatherApiService {
    WeatherData retrieveWeather(String cityName);
    void updateWeatherData(String cityName, WeatherData weatherData);
}

