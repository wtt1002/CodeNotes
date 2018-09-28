package qiuzhao.JD;

/**
 * Package: qiuzhao.JD
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/9/9 0009$ 下午 7:45$
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("A");
        new Main();
        //new Main();
    }
    public Main(){
        System.out.println("构造函数B");
    }
    {
        System.out.println("普通代码块C");
    }
    static {
        System.out.println("静态代码块D");
    }

}
