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
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherDate);

        weatherDate.setMeasurements(80, 65, 30.4f, 80, 82,78);
        weatherDate.setMeasurements(82, 70, 29.2f,82,85,80);
        weatherDate.setMeasurements(78, 90, 29.2f,78,80,76);
    }
}
