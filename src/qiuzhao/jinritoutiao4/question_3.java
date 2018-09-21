package qiuzhao.jinritoutiao4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Package: qiuzhao.jinritoutiao4
 * Description： 第三题（题意理解出错，过40%）
 * Author: TingTing W
 * Date: Created in 2018/9/20 0020$ 下午 6:43$
 */
public class question_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < K; i++){
            words.add(scanner.next());
        }
        char[][] map = new char[M][N];
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                map[i][j] = scanner.next().charAt(0);
            }
        }
        for (int t = 0; t < words.size(); t++){
            String myWord = words.get(t);
            boolean isMatch = false;
            int[][] mark = new int[M][N];
            for (int i = 0; i < M && isMatch == false; i++){
                for (int j = 0; j < N && isMatch == false; j++){
                    if (map[i][j] == myWord.charAt(0)){
                        if (getMatch(map, i, j, mark, myWord, 0) == true){
                            System.out.println(myWord);
                            isMatch = true;
                        }
                    }
                }
            }

        }
    }
    private static boolean getMatch(char[][] map, int i, int j, int[][] mark, String myWord, int index){
        if (i >= map.length || i < 0 || j >= map[0].length || j < 0 || index >= myWord.length()){
            return false;
        }
        if (index == myWord.length() - 1){
            if (mark[i][j] == 0 && map[i][j] == myWord.charAt(index)){
                mark[i][j] = 1;
                return true;
            }
            return false;
        }else {
            if (mark[i][j] == 0 && map[i][j] == myWord.charAt(index)){
                mark[i][j] = 1;

                return getMatch(map,i - 1, j, mark, myWord, index + 1) ||
                        getMatch(map,i + 1, j, mark, myWord, index + 1)||
                        getMatch(map,i , j - 1, mark, myWord, index + 1)||
                        getMatch(map, i, j + 1, mark, myWord, index + 1);
            }else {
                return false;
            }
        }
    }
}
