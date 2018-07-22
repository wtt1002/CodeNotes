package design_pattern.observer_dome;

/**
 * Package: design_pattern.observer_dome
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/7/22 14:48
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;
    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        System.out.println("current condition:" + temperature + " degree and " + humidity + "% humidity");

    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
}
