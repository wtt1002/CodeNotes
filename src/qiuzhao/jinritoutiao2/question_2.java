package qiuzhao.jinritoutiao2;

import java.util.Scanner;

/**
 * 通过20%
 */
public class question_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;
        if(num == 0) count = 0;
        else{
            int sign = (num-1)/2;
            for(int i = sign; i >= 0; i--){
                count += get_num(i, num);
                count = count % 1000000007;
            }
        }
        System.out.println(count);
    }
    private static int pow(int x, int n){
        int sum = 1;
        while(n-- > 0){
            sum *= x;
            sum = sum % 1000000007;
        }
        return sum;
    }
    private static int jiecheng(int x, int n){
        int sum = 1;
        while(n-- > 0){
            sum *= x--;
            sum = sum % 1000000007;
        }
        return sum;
    }
    private static int c_m_n(int m, int n){
        return jiecheng(m, n) / jiecheng(n, n) ;
    }
    private static int brack_num(int brack, int num){
        int sum = 0;
        for(int i = num; i >= 1; -- i)
            sum += i;
        sum = pow(sum, brack);
        return sum;
    }
    private static int get_num(int sign, int n){
        int count = 0;
        int loc_num = sign + 1;
        int temp_num = 0;
        int brack = (n - sign - loc_num) / 2;
        for(int i = 0; i <= brack; ++ i){
            temp_num = n - sign - 2 * i;
            //cout << i <<temp_num << endl;
            //count += c_m_n(temp_num-1,loc_num-1) * pow(10, temp_num) * pow(2, sign) * brack_num(i, sign+loc_num);
            int temp = c_m_n(temp_num-1,loc_num-1) * pow(10, temp_num) % 1000000007;
            temp = temp * pow(2, sign) % 1000000007;
            temp = temp *  brack_num(i, sign+loc_num)% 1000000007;
            count += temp;
            count %= 1000000007;
        }
        return count;
    }
}
