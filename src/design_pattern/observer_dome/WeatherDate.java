package design_pattern.observer_dome;

import java.util.ArrayList;

/**
 * Package: design_pattern.observer_dome
 * Description： 主题实现类
 * Author: TingTing W
 * Date: Created in 2018/7/22 11:34
 */
public class WeatherDate implements Subject {
    private ArrayList observers;
    private float temperture;
    private float humidity;
    private float pressure;
    private float avgTemperature;
    private float maxTemperature;
    private float minTemperature;
    public WeatherDate(){
        observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0){
            observers.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++){
            Observer observer = (Observer) observers.get(i);
            observer.update(temperture, humidity, pressure, avgTemperature, maxTemperature, minTemperature);
        }
    }
    public void measurementsChanged(){
        notifyObserver();
    }
    public void setMeasurements(float temperture, float humidity, float pressure, float avgTemperature, float maxTemperature
                                , float minTemperature){
        this.temperture = temperture;
        this.humidity = humidity;
        this.pressure = pressure;
        this.avgTemperature = avgTemperature;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        measurementsChanged();
    }
}
