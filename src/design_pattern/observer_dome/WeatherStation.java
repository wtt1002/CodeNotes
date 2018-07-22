package design_pattern.observer_dome;

/**
 * Package: design_pattern.observer_dome
 * Description： 测试
 * Author: TingTing W
 * Date: Created in 2018/7/22 14:54
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherDate weatherDate = new WeatherDate();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherDate);

        weatherDate.setMeasurements(80, 65, 30.4f);
        weatherDate.setMeasurements(82, 70, 29.2f);
        weatherDate.setMeasurements(78, 90, 29.2f);
    }
}
