public class WeatherData {
    private String cityName;
    private String forecast;

    // Constructor
    public WeatherData(String cityName, String forecast) {
        this.cityName = cityName;
        this.forecast = forecast;
    }

    public String getCityName() {
        return cityName;
    }

    public String getForecast() {
        return forecast;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }
}
