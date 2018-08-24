/**
 * Package: PACKAGE_NAME
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/6/25 20:05
 */
public class RegMatch {
    public boolean match(char [] str, char [] pattern){
        if (str == null || pattern == null){
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return coreMatch(str, strIndex, pattern, patternIndex);
    }

    private boolean coreMatch(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //完全匹配
        if (strIndex == str.length && patternIndex == pattern.length){
            return true;
        }
        //pattern先结束
        if (strIndex != str.length && patternIndex == pattern.length){
            return false;
        }
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*'){
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return coreMatch(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                || coreMatch(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                || coreMatch(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
        } else {
            return coreMatch(str, strIndex, pattern, patternIndex + 2);
            }
        }
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return coreMatch(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

}
