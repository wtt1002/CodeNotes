package design_pattern.observer_dome;

/**
 * Package: design_pattern.observer_dome
 * Description： 主题接口
 * Author: TingTing W
 * Date: Created in 2018/7/22 11:30
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}
