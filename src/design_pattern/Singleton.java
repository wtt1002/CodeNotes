package design_pattern;

/**
 * Package: design_pattern
 * Description： 单例模式
 * Author: TingTing W
 * Date: Created in 2018/7/22 10:35
 */
public class Singleton {
    // 使用volatile确保多线程访问时，可以正确处理uniqueInstance
    private volatile static Singleton uniqueInstance;
    // 必须为私有的空参构造器
    private Singleton(){}
    // 必须为public static 确保在类的外面可以被访问到
    public static Singleton getInstance() {
        // 第一重检查
        if (uniqueInstance == null){
            // 加锁
            synchronized (Singleton.class){
                // 第二重检查
                if (uniqueInstance == null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
