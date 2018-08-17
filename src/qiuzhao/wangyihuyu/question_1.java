package qiuzhao.wangyihuyu;

import java.util.Scanner;

public class question_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int answer = 0, x;
        for(int i = 0; i < num; i++){
            x = sc.nextInt();
            answer = getRes(x);
            System.out.println(answer);
        }

    }

    private static int getRes(int salary){
        int res = 0;
        int temp = 0;
        if(salary < 5000) return res;
        salary = salary - 5000;
        temp = salary - 80000;
        if(temp > 0){
            res = res + (int)Math.round(temp * 0.45);
            salary = 80000;
        }
        temp = salary - 55000;
        if(temp > 0){
            res = res + (int)Math.round(temp * 0.35);
            salary = 55000;
        }
        temp = salary - 35000;
        if(temp > 0){
            res = res + (int)Math.round(temp * 0.3);
            salary = 35000;
        }
        temp = salary - 25000;
        if(temp > 0){
            res = res + (int)Math.round(temp * 0.25);
            salary = 25000;
        }
        temp = salary - 12000;
        if(temp > 0){
            res = res + (int)Math.round(temp * 0.2);
            salary = 12000;
        }
        temp = salary - 3000;
        if(temp > 0){
            res = res + (int)Math.round(temp * 0.1);
            salary = 3000;
        }
        temp = salary - 0;
        if(temp > 0){
            res = res + (int)Math.round(temp * 0.03);
        }
        return res;
    }
}
