package offer;

/**
 * Package: offer
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/7/21 15:50
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        char[] str = {'a', 'a', 'a', 'a', 'b'};
//        char[] pattern = {'a', '.', '*', 'b'};
        char[] str = {};
        char[] pattern = {'.'};
//        boolean flag = solution.match(str, pattern);
//        System.out.println(flag);
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        solution.reConstructBinaryTree(pre,in);
    }
}
