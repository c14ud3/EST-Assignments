public class ForecastDetails {
    private String cityName;
    private WeatherData weatherData;

    // Constructor
    public ForecastDetails(String cityName, WeatherData weatherData) {
        this.cityName = cityName;
        this.weatherData = weatherData;
    }

    public String getCityName() {
        return cityName;
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }
}
