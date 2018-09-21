package qiuzhao.jinritoutiao4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Package: qiuzhao.jinritoutiao4
 * Description： 第五题(暴力，过60%)
 * Author: TingTing W
 * Date: Created in 2018/9/20 0020$ 下午 6:44$
 */
public class question_5 {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(coreFunc(a,b));

    }
    private static long coreFunc(int a, int b){
        long num = 0;
        if(a >= 1 && b >= a){
            if(b<=10) {
                num = b+1-a;
            }else {
                for(int i=a;i<=b;i++) {
                    ArrayList<Integer> list = new ArrayList<>();
                    int tempi = i;
                    while(tempi!=0) {
                        list.add(tempi%10);
                        tempi /=10;
                    }
                    int m = 0;
                    if(list.size()%2==0) {
                        for(int j=0;j<=(list.size()/2-1);j++) {
                            if(list.get(j)==list.get(list.size()-1-j)) {
                                break;
                            }
                            m++;
                        }
                    }else {
                        for(int j=0;j<(list.size()/2);j++) {
                            if(list.get(j)==list.get(list.size()-1-j)) {
                                break;
                            }
                            m++;
                        }
                    }

                    if(m==list.size()/2) {
                        num++;
                    }
                }
            }
        }
        return num;
    }

}
