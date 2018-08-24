package qiuzhao.wangyi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 牛客网
 排列组合，n个'a'和m个'z'，只能组成$C_{n+m}^n$，记为count(n+m,n) 个单词。
 思路：
 1.假设第一个字符为a，则剩下n-1个'a'和m个'z'组成的子序列只能构成count(n-1+m,n-1)个单词，且是字典中前count(n-1+m,n-1)个单词。
 2.比较k和count(n-1+m,n-1)，若k小，说明k是前count(n-1+m,n-1)个单词，则第一个字符必为'a'。子问题化为在子序列(n-1个'a'和m个'z')找到第k个单词
 3.若k大，则说明第一个字符必为'z',单词是以'z'开头的单词中的第k-count(n-1+m,n-1)个。子问题化为在子序列(n个'a'和m-1个'z')找到第k-count(n+m-1,m-1)个单词。
 eg:n=2,m=2,k=5
 1.假设第一个字符为a,则剩下1个a,2个z只能构成3个单词，且是字典中前3个单词(aamm,amam,amma)
 2.k>3，则第一个字符必为z。原问题化为在n=2,m=1,k=2，即在剩下2个a，1个z中找到第2个单词
 */
public class question_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long k = scanner.nextInt();
        solve(n, m, k);


    }

    private static void solve(int n, int m, long k) {
        ArrayList<Character> list = new ArrayList<>();

        while (m > 0 && n > 0){
            long count = 1;
            for (int i = 0; i < n - 1; i++){
                count *= n - 1 + m - i;
                count /= n - 1 - i;
                if (count > k){
                    break;
                }
            }
            // 左半边
            if (k <= count){
                list.add('a');
                n--;
            }else {
                list.add('z');
                m--;
                k -= count;
            }
        }
        if (k != 1){
            System.out.println(-1);
            return;
        }
        while (n > 0){
            list.add('a');
            n--;
        }
        while (m > 0){
            list.add('z');
            m--;
        }
        for (char c :
                list) {
            System.out.print(c);
        }
    }
}
