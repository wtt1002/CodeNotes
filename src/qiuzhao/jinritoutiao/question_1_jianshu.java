package qiuzhao.jinritoutiao;

import java.util.Scanner;

/**
 * 10,10
 0,0,0,0,0,0,0,0,0,0
 0,0,0,1,1,0,1,0,0,0
 0,1,0,0,0,0,0,1,0,1
 0,1,0,0,0,0,0,0,1,1
 0,0,0,1,1,1,0,0,0,1
 0,0,0,0,0,0,1,0,1,1
 0,1,1,0,0,0,0,0,0,0
 0,0,0,1,0,1,0,0,0,0
 0,0,1,0,0,1,0,0,0,0
 0,1,0,0,0,0,0,0,0,0
 */
public class question_1_jianshu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] arr = str.split(",");
        int row = Integer.parseInt(arr[0]);
        int col = Integer.parseInt(arr[1]);
        int[][] seat = new int[row][col];
        for (int i = 0; i < row; i++){
            str = scan.nextLine();
            arr = str.split(",");
            for (int j = 0; j < col; j++){
                seat[i][j] = Integer.parseInt(arr[j]);
//                if (seat[i][j] != 0 || seat[i][j] != 1)  // 防止输入除0或1之外的数字
//                    return;
            }
        }
        resolve(row, col, seat);
    }

    private static void resolve(int row, int col, int[][] seat) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (seat[i][j] == 0) continue;
                int temp = connect(seat, i, j, row, col);
                if (temp > max) max = temp;
                count++;
            }
        }
        System.out.println(count+","+max);
    }
    //深度优先搜索,被扫到就置0
    private static int connect(int[][] seat, int i, int j, int row, int col){
        if (i < 0 || i >= row || j <0 || j >= col) return 0;
        if (seat[i][j] == 0) return 0;
        seat[i][j] = 0;
        return 1 + connect(seat, i, j+1, row, col) + connect(seat, i, j-1, row, col) +
                connect(seat, i-1, j-1, row, col) + connect(seat, i-1, j+1, row, col) +
                connect(seat, i-1, j, row, col) + connect(seat, i+1, j+1, row, col) +
                connect(seat, i+1, j-1, row, col) + connect(seat, i+1, j, row, col);
    }
}
