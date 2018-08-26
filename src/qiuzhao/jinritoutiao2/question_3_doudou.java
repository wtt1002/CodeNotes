package qiuzhao.jinritoutiao2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 未修改，输入有问题
 */
public class question_3_doudou {
    public static void main(String[] args) {
        List<List<String>> lists=input();
        System.out.println(lists);

        for(int i=0;i<lists.size();i++) {
            List<String> list=lists.get(i);
            String string=list.get(0)+list.get(0);
            String string2=array(string);
            String result="Yeah";
            for(int j=0;j<list.size();j++) {
                String s=list.get(j);
                if(s.length()*2!=string.length()||(!string.contains(s)&&!string2.contains(s))) {
                    result="Sad";
                    break;
                }
            }
            System.out.println(result);
        }
    }

    private static String array(String s){
        int length=s.length();
        char[] array=s.toCharArray();
        for(int i=0;i<length/2;i++){
            array[i]=s.charAt(length-1-i);
            array[length-1-i]=s.charAt(i);
        }
        return new String(array);
    }

    private static List<List<String>> input(){
        List<List<String>> lists=new ArrayList<>();
        List<String> list1=Arrays.asList("helloworld","hdlrowolle");
        List<String> list2=Arrays.asList("helloworld","worldhello");
        List<String> list3=Arrays.asList("abcde","acbde");
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        return lists;
    }
}