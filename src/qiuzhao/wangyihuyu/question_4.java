package qiuzhao.wangyihuyu;

import java.util.ArrayList;
import java.util.Scanner;

public class question_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        ArrayList<String> mode = new ArrayList<>();
        ArrayList<String> test = new ArrayList<>();
        while(num-- > 0){
            int m = scanner.nextInt();
            while(m-- > 0){
                String temp1 = scanner.next();
                String temp2 = scanner.next();
                mode.add(temp1);
                mode.add(temp2);
            }
            int n = scanner.nextInt();
            while(n-- > 0){
                String temp = scanner.next();
                test.add(temp);
            }
            matchCore(mode, test);
            mode.removeAll(mode);
            test.removeAll(test);

        }
    }

    public static boolean ifMatch(String s1, String s2){

        boolean flag = true;
        for(int i = 0; i < s1.length(); ++ i){
            if(s1.charAt(i) == 'x')
                break;
            if(s1.charAt(i) != s2.charAt(i)){
                flag = false;
                break;
            }
        }
        return flag;
    }
    public static int matchCore(ArrayList<String> mode, ArrayList<String> test){
        String output ;
        for(int i = 0; i < test.size(); i += 1){
            output = "unknown";
            for(int j = 0; j < mode.size(); j += 2){
                if(ifMatch(mode.get(j), test.get(i)))
                    output = mode.get(j + 1);
            }
            System.out.println(output);
        }
        return 0;
    }
}
