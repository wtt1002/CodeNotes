package qiuzhao.JD;

/**
 * Package: qiuzhao.JD
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/9/9 0009$ 下午 7:50$
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(B.c);
    }
}
class A{
    static {
        System.out.println("A");
    }
}
class B extends A{
    //public final static String c = new String("C");
    static {
        System.out.println("B");
    }
    public final static String c = new String("C");
}