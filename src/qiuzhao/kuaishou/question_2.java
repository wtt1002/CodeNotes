package qiuzhao.kuaishou;

import java.util.Scanner;

/**
 * Package: qiuzhao.kuaishou
 * Description： 第二题
 * Author: TingTing W
 * Date: Created in 2018/9/10 0010$ 下午 5:54$
 */
public class question_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String preStr = scanner.nextLine();
        String inStr = scanner.nextLine();
        int[] pre = strToInts(preStr);
        int[] in = strToInts(inStr);
        if(pre == null || in == null){
            return;
        }
        getInSum(in, 0, in.length - 1);
        for (int i = 0; i < in.length; i++){
            System.out.print(in[i] + " ");
        }

    }
    private static void getInSum(int[] inArr, int i, int j){
        if (i == j || i > j){
            inArr[i] = 0;
            return;
        }
        int mid = (i + j)/2;
        int sum = 0;
        for (int k = i; k <= j; k++){
            sum += inArr[k];
        }
        sum -= inArr[mid];
        inArr[mid] = sum;
        getInSum(inArr, i , mid - 1);
        getInSum(inArr, mid + 1, j);

    }
    private static int[] strToInts(String str){
        String[] strs = str.split(" ");
        int[] array = new int[strs.length];
        for (int i = 0; i < array.length; i++){
            array[i] = Integer.parseInt(strs[i]);
        }
        return array;
    }
    private static TreeNode reConstructBinaryTreeCore(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        TreeNode tree = new TreeNode(pre[preStart]);
        tree.left = null;
        tree.right = null;
        if (preStart == preEnd && inStart == inEnd) {
            return tree;
        }
        int root = 0;
        for(root= inStart; root < inEnd; root++){
            if (pre[preStart] == in[root]) {
                break;
            }
        }
        int leifLength = root - inStart;
        int rightLength = inEnd - root;
        if (leifLength > 0) {
            tree.left = reConstructBinaryTreeCore(pre, in, preStart+1, preStart+leifLength, inStart, root-1);
        }
        if (rightLength > 0) {
            tree.right = reConstructBinaryTreeCore(pre, in, preStart+1+leifLength, preEnd, root+1, inEnd);
        }
        return tree;
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}