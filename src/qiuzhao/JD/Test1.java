package qiuzhao.JD;

/**
 * Package: qiuzhao.JD
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/9/9 0009$ 下午 7:53$
 */
public class Test1
{
    public static void main(String[] args) {
        System.out.println(Test2.a);
        Object o = new Object();
    }

}
class  Test2{

    public static final String a = "JD";
    static {
        System.out.println("OK");
    }


}
