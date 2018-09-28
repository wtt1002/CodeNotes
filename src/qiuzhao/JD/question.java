package qiuzhao.JD;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: qiuzhao.JD
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/9/15 11:06
 */
public class question {

    public static void main(String[] args) {
        List<String> outPut = findAllMsg("11100??11");
        for (String str :
                outPut) {
            System.out.println(str);
        }

    }
    public static List<String> findAllMsg(String message){

        List<String> res = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < message.length(); i++){
            if (message.charAt(i) == '?'){
                index.add(i);
            }
        }
        int len = (int)Math.pow(2,index.size());
        String[] subStr = new String[len];
        for (int i = 0; i < len; i++){
            char[] temp = new char[index.size()];
            int a = i;
            for (int j = 0; j < index.size(); j++){
                temp[index.size() - j - 1] = (char)(a%2 + 48);
                a /= 2;
            }
            subStr[i] = char2Str(temp);

        }
        for (int i = 0; i < len; i++){
            //String temp = message;
            char[] temp = message.toCharArray();
            for (int j = 0; j < index.size(); j++){
                temp[index.get(j)] = subStr[i].charAt(j);
            }

            res.add(char2Str(temp));
        }
        return res;
    }
    public static String char2Str(char[] chars){
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++){
            buffer.append(chars[i]);
        }
        return buffer.toString();
    }
}
