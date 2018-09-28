package qiuzhao.JD;

/**
 * Package: qiuzhao.JD
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/9/9 0009$ 下午 7:50$
 */
public class Test {
    /**
     * notes:直接调用某个类的静态成员变量，
     * 如果该成员变量直接被赋值一个字符串，则直接得到这个字符串，应该是从常量池中直接取得。
     * 如果是其它类型，甚至是new String("C"),也会调用父子类的静态代码块
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(B.c);
        //System.out.println(B.bb);
        new B();
    }
}
class A{
    public A(){
        System.out.println("父类构造方法");
    }
    static {
        System.out.println("父类静态代码块A");
    }
    {
        System.out.println("父类普通代码块");
    }
}
class B extends A{
    //public final static String c = new String("C");
    public final static String c = "ASSHOIHP(WUP(UHDPUJS{D)U{S";
    //public static Integer bb = 9;
    public B(){
        System.out.println("子类构造函数");
    }
    static {
        System.out.println("子类静态代码块B");
    }
    {
        System.out.println("子类普通代码块");
    }
    //public final static String c = new String("C");
}