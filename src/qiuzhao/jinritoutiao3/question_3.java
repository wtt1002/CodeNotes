package qiuzhao.jinritoutiao3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Package: qiuzhao.jinritoutiao3
 * Description： 第三题
 * Author: TingTing W
 * Date: Created in 2018/9/9 9:33
 */
public class question_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ipAddress = scanner.nextLine();
        System.out.println(getIp(ipAddress));

    }
    private static int getIp(String ipStr) {
        // vector<string> ret;
        ArrayList<String> ans = new ArrayList<>();
        for (int a = 1; a <= 3; a++)
            for (int b = 1; b <= 3; b++)
                for (int c = 1; c <= 3; c++)
                    for (int d = 1; d <= 3; d++)
                        if (a + b + c + d == ipStr.length()) {
                            try {

                                int one = Integer.parseInt(ipStr.substring(0, a));
                                int two = Integer.parseInt(ipStr.substring(a, a + b));
                                int three = Integer.parseInt(ipStr.substring(a + b, a + b + c));
                                int four = Integer.parseInt(ipStr.substring(a + b + c, a +b + c + d));
                                if (one <= 255 && two <= 255 && three <= 255 && four <= 255) {
                                    StringBuffer buffer = new StringBuffer();
                                    buffer.append(one);
                                    buffer.append(".");
                                    buffer.append(two);
                                    buffer.append(".");
                                    buffer.append(three);
                                    buffer.append(".");
                                    buffer.append(four);
                                    ans.add(buffer.toString());
                                }
                            }catch (NumberFormatException e){

                            }
                        }

        return ans.size();
    }

}
