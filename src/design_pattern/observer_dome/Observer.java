package design_pattern.observer_dome;

/**
 * Package: design_pattern.observer_dome
 * Description： 观察者接口
 * Author: TingTing W
 * Date: Created in 2018/7/22 11:32
 */
public interface Observer {
    public void update(float temperature, float humidity, float pressure, float avgTemperature, float maxTemperature, float minTemperature);
}
