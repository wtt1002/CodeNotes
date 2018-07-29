package offer;

import java.util.Stack;

/**
 * Package: offer
 * Description： codeNotes
 * Author: TingTing W
 * Date: Created in 2018/7/21 15:24
 */
public class Solution {


    /**
     * 旋转数组的最小元素（未通过，暂未发现原因）
     * @param array 待查找数组
     * @return 最小值
     */
    public int minNumberInRotateArray(int[] array){
        //边界处理
        if (array == null || array.length == 0){
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        // 记录当前元素是否与头元素相同
        boolean isRep = false;
        while (start + 1 < end){
            mid = start + (end - start)/2;
            //System.out.println("mid:" + mid);
            if (array[mid] < array[start]){
                end = mid;
            }else if (array[mid] > array[start]){
                start = mid + 1;
            }else {
                isRep = true;
                break;
            }
        }
        //找到重复元素
        if (isRep){
            //System.out.println("is rep");
            int min = array[0];
            for (int i = 1; i < array.length; i++){
                if (array[i] < min){
                    min = array[i];
                }
            }
            return min;
        } else { // 正常结束循环，比较头尾
            return array[start] < array[end] ? array[start] : array[end];
        }
    }


    /**
     * 利用堆栈实现队列（优化方法）
     */
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * 入队
     * @param node 待入队元素
     */
    public void push(int node){
        stack1.push(node);
    }

    /**
     * 出队
     * @return 出队元素
     */
    public int pop(){
        if (stack1.empty() && stack2.empty()){
            throw new RuntimeException();
        }
        if (stack2.empty() && !stack1.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }

        }
        return stack2.pop();
    }

    /**
     * 根据前序遍历后中序遍历重构二叉树
     * @param pre 先序遍历
     * @param in 中序遍历
     * @return 根结点
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in){
        if (pre == null || in == null){
            return null;
        }
        TreeNode tree = reConstructBinaryTreeCore(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return tree;
    }

    /**
     * 重构二叉树核心循环
     * @param pre 先序遍历
     * @param in 中序遍历
     * @param preStart 先序遍历开始下标
     * @param preEnd 先序遍历结束下标
     * @param inStart 中序遍历开始下标
     * @param inEnd 中序遍历结束下标
     * @return 新节点
     */
    private TreeNode reConstructBinaryTreeCore(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        TreeNode node = new TreeNode(pre[preStart]);
        node.right = null;
        node.left = null;

        if (preStart == preEnd && inStart == inEnd){
            return node;
        }
        int root = 0;
        for (root = inStart; root < inEnd; root++){
            if (pre[preStart] == in[root]){
                break;
            }
        }

        int leftLength = root - inStart;
        int rightLength = inEnd - root;

        if (leftLength > 0){
            node.left = reConstructBinaryTreeCore(pre, in, preStart + 1, preStart + leftLength, inStart, root - 1);
        }
        if (rightLength > 0){
            node.right = reConstructBinaryTreeCore(pre, in, preStart + leftLength + 1, preEnd, root + 1, inEnd);
        }
        return node;
    }


    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore1(str, pattern, strIndex, patternIndex);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
    //str到尾，pattern到尾，匹配成功
     if (strIndex == str.length && patternIndex == pattern.length) {
        return true;
        }
    //str未到尾，pattern到尾，匹配失败
    if (strIndex != str.length && patternIndex == pattern.length) {
        return false;
    }
    //str到尾，pattern未到尾(不一定匹配失败，因为a*可以匹配0个字符)
    if (strIndex == str.length && patternIndex != pattern.length) {
        //只有pattern剩下的部分类似a*b*c*的形式，才匹配成功
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            return matchCore(str, strIndex, pattern, patternIndex + 2);
        }
        return false;
    }

    //str未到尾，pattern未到尾
    if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
        if (pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex, pattern, patternIndex + 2)//*匹配0个，跳过
                    || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//*匹配1个，跳过
                    || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
        } else {
     //直接跳过*（*匹配到0个）
            return matchCore(str, strIndex, pattern, patternIndex + 2);
        }
    }

    if (pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)) {
        return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
    }

    return false;
    }

    public boolean matchCore1(char[] str, char[] pattern, int indexS, int indexP){

        System.out.println("indexs:"+indexS);
        System.out.println("indexp:" + indexP);
        if (indexS == str.length && indexP == pattern.length){
            return true;
        }
        if (indexS < str.length && indexP == pattern.length){
            return false;
        }
        if (indexS == str.length && indexP != pattern.length){
            if (indexP + 1 < pattern.length && pattern[indexP + 1] == '*'){
                return matchCore1(str, pattern, indexS, indexP + 2);
            }
        }
        if ((indexP + 1 < pattern.length) && pattern[indexP + 1] != '*'){
            if (str[indexS] == pattern[indexP] || (indexS < str.length && pattern[indexP] == '.')){
                return matchCore1(str, pattern, indexS + 1, indexP + 1);
            }else {
                return false;
            }
        }else {
            if (str[indexS] == pattern[indexP] || (indexS < str.length && pattern[indexP] == '.')){
                return matchCore1(str, pattern, indexS, indexP + 2)||matchCore1(str, pattern, indexS + 1, indexP);
            }else {
                return matchCore1(str, pattern, indexS, indexP + 2);
            }
        }
    }

    public boolean coreMatch1(char[] str, char[] pattern){

        int indexS = 0;
        int indexP = 0;
        char preChar = str[0];
        boolean flag = true;

        for (; indexS < str.length && indexP < pattern.length;){
            if (pattern[indexP] == '.'){
                preChar = str[indexS];
                System.out.println(pattern[indexP] + "..." + str[indexS]);
                indexP++;
                indexS++;
            }else if (pattern[indexP] == '*'){
                System.out.println(pattern[indexP] + "..." + str[indexS]);
                if (str[indexS] == preChar){
                    indexS++;
                }else {
                    indexP++;
                }
            }else if (pattern[indexP] == str[indexS]){
                System.out.println(pattern[indexP] + "..." + str[indexS]);
                preChar = str[indexS];
                indexP++;
                indexS++;
            }else {
                System.out.println(pattern[indexP] + "..." + str[indexS]);
                if (indexP + 1 < pattern.length && pattern[indexP + 1] == '*'){
                    indexP += 2;
                }else {
                    flag = false;
                    break;
                }
            }
        }
        if (flag){
            if (indexP < pattern.length){
                for (; indexP < pattern.length; indexP++){
                    if (pattern[indexP] != '*'){
                        flag = false;
                    }
                }
            }else if (indexS < str.length){
                flag = false;
            }
        }
            return flag;
    }
}
 // Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
    }
