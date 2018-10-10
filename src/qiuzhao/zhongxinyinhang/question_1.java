package qiuzhao.zhongxinyinhang;

/**
 * Package: qiuzhao.zhongxinyinhang
 * Description： 1
 * Author: TingTing W
 * Date: Created in 2018/10/9 20:02
 */
public class question_1 {
    public static void main(String[] args) {
        int[] array = {4, 3, 2, 6};
        System.out.println(retate(array));
    }
    public static int retate(int[] a){
        int k = 0;
        int max = getUnit(a,0);
        for (k = 1; k < a.length; k++){
            int temp = getUnit(a,k);
            if (temp > max){
                max = temp;
            }
        }
        return max;
    }
    private static int getUnit(int[] a, int k){
        int sum = 0;
        for (int index = 0; index < a.length; index++){
            sum += index * a[(index + k)%a.length];
        }
        return sum;
    }
}
