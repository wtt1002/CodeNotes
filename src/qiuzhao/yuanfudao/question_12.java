package qiuzhao.yuanfudao;

import java.util.List;

public class question_12 {

    /**
     * dp[i][j]：从array[i] 到 array[j]的和
     * 递推式：
     * dp[i][j] = dp[i + 1][j - 1] + array[i] + array[j]
     * @param array
     * @return
     */
    public int getLongestLength(List<Integer> array){
        if (array == null || array.size() == 0){
            return 0;
        }
        int[][] dp = new int[array.size()][array.size()];
        // 记录最大长度
        int max = 0;
        // 初始化dp
        // 求两两相邻的和，作为下一步的边界条件
        for (int i = 1; i < array.size(); i++){
            dp[i - 1][i] = array.get(i - 1) + array.get(i);
            // 若有相邻异号，则长度最短为2
            if (array.get(i - 1) == -array.get(i)){
                max = 2;
            }
        }

        // len += 2 ：和为0，必须为偶数个
        for (int len = 3; len < array.size(); len += 2){
            for(int i = 0, j; (j = i + len) < array.size(); i++) {
                dp[i][j] = array.get(i) + array.get(j) + dp[i + 1][j - 1];
                if(dp[i][j] == 0) {
                    max = Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }
}
