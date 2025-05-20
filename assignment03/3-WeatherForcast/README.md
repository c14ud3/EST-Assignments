# WeatherForcast

The `WeatherForecast` class manages operations for an online weather forecast dashboard.
It interacts with an external weather API service (`WeatherApiService`) to retrieve forecast data for cities.
The system also integrates a local caching service (`CacheService`) to optimize forecast retrieval and reduce API calls.
The method `getForecast` retrieves the weather forecast for a city, either from the cache or if not available, fetches it from the weather API.

Write unit tests for the `getForecast` method in the `WeatherForecast` class, considering the following:

- Use of Doubles for WeatherApiService and CacheService. Identify external dependencies and implement tests using stubs to simulate API and cache responses for different cities and weather conditions and different caching behaviors.

- Simulate API downtimes and cache misses to test the system's resilience and fallback mechanisms. Verify that proper error handling and fallback logic are triggered when external services are unavailable.

Automate the test cases using the **JUnit5** plugin.
