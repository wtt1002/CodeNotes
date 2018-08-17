package qiuzhao.huawei;

import java.util.HashMap;
import java.util.Scanner;

public class question_3 {
    public static void main(String[] args) {
        // typedef int INT; typedef INT** INTP; typedef INTP* INTSP;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String target = scanner.nextLine();
        String[] strs = lineToStrs(str);
        HashMap<String, String> map = new HashMap();
        for (int i = 0; i < strs.length; i++){
            String s = strs[i];
            String[] items = s.split(" ");
            if (isLegel(items)){
                map.put(items[2], items[1]);
            }
        }
        String[] model = {"bool", "char", "int", "float", "double","wchar_t","void"};
        for (int i = 0; i < model.length; i++){
            map.put(model[i], "#");
        }
//        for (String key : map.keySet()) {
//
//            System.out.println("key= "+key+" and value= "+map.get(key));
//
//        }
        String out = judgeCore(target, map);
        if (out == null){
            System.out.println("none");
        }else {
            System.out.println(out);
        }


    }

    /**
     * 递归判断函数
     * @param target 待匹配str
     * @param map hashmap
     * @return 最终匹配
     */
    private static String judgeCore(String target, HashMap map) {
        // 判断map中有无此类型
        if (map.containsKey(target)){
            // 已查找到基本类型，返回当前target
            if (map.get(target) == "#"){
                return target;
            }else {
                int len = target.length();
                // 获取当前key对应value
                String value_str = (String )map.get(target);
                String strZero = judgeCore(value_str, map);
                // 在不考虑指针的情况下有匹配项，直接返回
                if (strZero != null){
                    return strZero;
                }
                else {
                    // 直接匹配不行，考虑存在指针情况
                    int index = len - 1;
                    // 确定*的个数
                    while (value_str.charAt(index) == '*') {
                        index--;
                    }
                    // 如果真的存在指针
                    if (index != len - 1) {
                        // 判断去掉指针能否匹配，如果可以返回匹配值加指针符号
                        String strP = judgeCore(value_str.substring(0, index + 1), map);
                        if (strP != null){
                            return strP + value_str.substring(index + 1);
                        }
                    }
                }
            }

        }
        // 以上条件均不能满足
        return null;

    }


    /**
     *  判断字符串是否合法
     * @param items 待测试数组
     * @return 合法与否
     */
    private static boolean isLegel(String[] items) {
        String[] model = {"bool", "char", "int", "float", "double","wchar_t","void"};
        if (items == null || items.length < 3){
            System.out.println("非法1");
            return false;
        }else if (!"typedef".equals(items[0])){
            return false;
        }else {
            return true;
        }

    }

    /**
     * 输入解析，分号、分号空格分割
     * @param str 待处理字符串
     * @return String数组
     */
    private static String[] lineToStrs(String str) {
        if (str == null || str.length() == 0)return null;
        String[] strs = str.split(";");
        for (int i = 0; i < strs.length; i++){
            //去掉前后空格
            strs[i] = strs[i].trim();
        }
        return strs;
    }
}
