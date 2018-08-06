package qiuzhao.yuanfudao;

import java.util.List;

public class question_11 {
    public static int getLuckyPrice(int price,List<Integer> unlucky_numbers){
        int[] unlucky = new int[10];
        unlucky[0] = 1;
        for (int i = 0; i < unlucky_numbers.size(); i++){
            unlucky[unlucky_numbers.get(i)] = 1;
        }
        String priceStr = String.valueOf(price);
        int[] prices = new int[priceStr.length()];
        boolean isInc = false;
        for (int i = 0; i < prices.length; i++){
            if (unlucky[prices[i]] == 1) {
                // 有增
                if (isInc) {
                    for (int k = 0; k <= 9; k++) {
                        if (unlucky[k] != 1) {
                            prices[i] = k;
                            break;
                        }
                    }
                } else {
                    for (int k = prices[i]; k <= 9; k++) {
                        if (unlucky[k] != 1) {
                            prices[i] = k;
                            isInc = true;
                            break;
                        }
                    }
                }
            }
        }
        int outCome = 0;
        for (int i = 0; i < prices.length; i++){
            outCome = outCome * 10 + prices[i];
        }
        return outCome;
    }
}
