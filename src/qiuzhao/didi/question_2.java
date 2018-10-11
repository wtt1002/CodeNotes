package qiuzhao.didi;

import java.util.Scanner;
import java.util.Stack;

/**
 * Package: qiuzhao.didi
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/10/10 18:49
 */
public class question_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] out = new int[4];
        int[] in = new int[4];
        for (int i = 0; i < 4; i++){
            out[i] = scanner.nextInt();
            in[i] = i + 1;
        }
        Stack<Integer> stack = new Stack<>();
        int index_i = 0;
        int index_o = 0;
        while (index_i < 4 && index_o < 4){
            if (stack.empty()){
                stack.push(in[index_i]);
                index_i++;
            }else {
                if (stack.peek() == out[index_o]){
                    stack.pop();
                    index_o++;
                }else {
                    stack.push(in[index_i]);
                    index_i++;
                }
            }
        }
        if (!stack.empty()){
            if (stack.peek() == out[index_o]){
                index_o++;
            }
        }
        if (index_o < index_i){
            System.out.println("No");
        }else {
            System.out.println("Yes");
        }
    }
}
