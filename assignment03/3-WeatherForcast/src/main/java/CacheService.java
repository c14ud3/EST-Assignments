public interface CacheService {
    ForecastDetails getDetails(String cityName);
    void cacheDetails(String cityName, ForecastDetails details);
    void refreshCache(String cityName, WeatherData weatherData);
}

