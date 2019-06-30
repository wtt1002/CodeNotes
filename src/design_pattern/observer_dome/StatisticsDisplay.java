package design_pattern.observer_dome;

/**
 * Package: design_pattern.observer_dome
 * Description： 气象统计
 * Author: TingTing W
 * Date: Created in 2019/6/30 0030$ 下午 9:08$
 */
public class StatisticsDisplay implements Observer,DisplayElement {
    private float avgTemperature;
    private float maxTemperature;
    private float minTemperature;
    private Subject weatherData;
    public StatisticsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        System.out.println("StatisticDisplay: ----Avg/Max/Min:"+ avgTemperature + "/" + maxTemperature + "/" + minTemperature);
    }

    @Override
    public void update(float temperature, float humidity, float pressure, float avgTemperature, float maxTemperature, float minTemperature) {
        this.avgTemperature = avgTemperature;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        display();
    }
}
