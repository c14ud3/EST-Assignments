public class WeatherForecast {
    private WeatherApiService weatherApiService;
    private CacheService cacheService;

    // Constructor to inject the API and cache services
    public WeatherForecast(WeatherApiService weatherApiService, CacheService cacheService) {
        this.weatherApiService = weatherApiService;
        this.cacheService = cacheService;
    }

    // Method to get the forecast for a city
    public ForecastDetails getForecast(String cityName) {
        if (cityName == null || cityName.isEmpty()) {
            return null;
        }

        ForecastDetails details = cacheService.getDetails(cityName);

        if (details == null) {
            try {
                WeatherData weatherData = weatherApiService.retrieveWeather(cityName);
                details = new ForecastDetails(cityName, weatherData);
                cacheService.cacheDetails(cityName, details);
            } catch (Exception e) {
                throw new RuntimeException("Failed to retrieve weather forecast", e);
            }
        }
        return details;
    }
}
