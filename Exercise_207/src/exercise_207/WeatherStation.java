

package exercise_207;

/**
 * @author Kilian Stöckler
 */
public class WeatherStation {
    
    private String place;
    private int seaLevel;
    private double temperature;
    private int humidity;

    public WeatherStation(String place, int seaLevel, double temperature, int humidity) {
        this.place = place;
        this.seaLevel = seaLevel;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getPlace() {
        return place;
    }

    public int getSeaLevel() {
        return seaLevel;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setSeaLevel(int seaLevel) {
        this.seaLevel = seaLevel;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    
    

}
