package qiuzhao.jinritoutiao4;
import java.util.Scanner;
import java.util.Stack;

/**
 * Package: qiuzhao.jinritoutiao4
 * Description： 第一题
 * Author: TingTing W
 * Date: Created in 2018/9/20 0020$ 下午 6:42$
 */
public class question_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(getSimpleName(str));

    }
    private static String getSimpleName(String str){
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < str.length();i++){
            while(i < str.length() && str.charAt(i) == '/') {
                i++;    //该操作跳过斜线'/'
            }
            StringBuilder sb = new StringBuilder();
            while(i<str.length() && str.charAt(i)!='/') {
                sb.append(str.charAt(i));
                i++;
            }
            if (!sb.toString().equals(".") && !sb.toString().equals("..")){
                stack.push(sb.toString());
            }
            if (sb.toString().equals("..") && !stack.isEmpty()){
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            System.out.print("/");
        }
        String result = "";
        while(!stack.isEmpty()){
            result = "/"+stack.peek()+result;
            stack.pop();
        }
        return result;
    }
}
