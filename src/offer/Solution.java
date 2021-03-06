package offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
/**
 * Package: offer
 * Description： codeNotes
 * Author: TingTing W
 * Date: Created in 2018/7/21 15:24
 */
public class Solution {

    ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> path = new ArrayList<>();

    /**
     * 二叉树中和为某一值的路径
     * @param root 根节点
     * @param target 目标和
     * @return 所有路径
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null)return paths;
        //添加当前节点
        path.add(root.val);
        // 找到一条路径
        if (target - root.val == 0 && root.left == null && root.right == null){
            // 传入path新建一个ArrayList，添加到paths
            paths.add(new ArrayList<>(path));
        }
        // 左孩子
        FindPath(root.left, target - root.val);
        // 右孩子
        FindPath(root.right, target - root.val);
        // 将刚刚加入的元素剔除
        path.remove(path.size() - 1);
        return paths;

    }
    /**
     * 二叉搜索树的后序遍历序列
     * @param sequence 后序序列
     * @return true/false
     */
    public  boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length <= 0)return false;
        if (sequence.length == 1)return true;
        int start = 0;
        int end = sequence.length - 1;
        return VerifySquenceOfBSTCore(sequence, start, end);
    }

    private boolean VerifySquenceOfBSTCore(int[] sequence, int start, int end) {
        if (start == end){
            return true;
        }
        int root = sequence[end];
        int leftLength = 0;
        for (int i = start; i < end; i++){
            if (sequence[i] < root){
                leftLength++;
            }else {
                break;
            }
        }
        for (int j = leftLength + start; j < end; j++){
            if (sequence[j] < end){
                return false;
            }
        }
        // 无左子树或无右子树
        if (leftLength == 0 || start + leftLength == end){
            return VerifySquenceOfBSTCore(sequence, start, end - 1);
        }else {
            return VerifySquenceOfBSTCore(sequence, start, start + leftLength - 1) && VerifySquenceOfBSTCore(sequence, start + leftLength, end - 1);
        }
    }

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
     * @param root 根节点
     * @return ArrayList
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null){
            return arrayList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp = null;
        while (!queue.isEmpty()){
            temp = queue.poll();
            arrayList.add(temp.val);
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null){
                queue.add(temp.right);
            }
        }
        return arrayList;
    }
    /**
     * 栈的压入、弹出序列
     * @param pushA 压栈数组
     * @param popA 出站数组
     * @return true/false
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        boolean flag = true;
        for (int i = 0; i < pushA.length;){
            if (pushA[i] == popA[index]){
                index++;
                i++;
                //System.out.println(i + "...yi..." + index);
            }else if (!stack.empty() && stack.peek() == popA[index]){
                index++;
                //System.out.println(i + "...er..." + index);
            }else {
                stack.push(pushA[i]);
                i++;
                //System.out.println(i + "...san..." + index);
            }
        }
        while (!stack.empty()){
            //System.out.println("。。。");
            if (stack.peek() == popA[index]){
                stack.pop();
                index++;
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }
    /**
     * 镜像树
     * @param root 根节点
     */
    public void Mirror(TreeNode root) {
        if (root == null)return;
        TreeNode temp = null;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * @param root1 A树
     * @param root2 B树
     * @return boolean
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        return hasSubtreeCore(root1, root2) || hasSubtreeCore(root1.left, root2) || hasSubtreeCore(root1.right, root2);
    }

    private boolean hasSubtreeCore(TreeNode root1, TreeNode root2) {
        if (root2 == null){
            return true;
        }else if (root1 == null){
            return false;
        }else {
            if (root1.val == root2.val){
                return hasSubtreeCore(root1.left, root2.left) && hasSubtreeCore(root1.right, root2.right);
            }else {
                return false;
            }
        }
    }

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     * @param list1 链表1
     * @param list2 链表2
     * @return 新链表
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null && list2 == null){
            return null;
        }
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                p.next = list1;
                list1 = list1.next;
                p = p.next;
            }else {
                p.next = list2;
                list2 = list2.next;
                p = p.next;
            }
        }
        while (list1 != null){
            p.next = list1;
            list1 = list1.next;
            p = p.next;
        }
        while (list2 != null){
            p.next = list2;
            list2 = list2.next;
            p = p.next;
        }
        return head.next;
    }

    /**
     * 输入一个链表，反转链表后，输出新链表的表头。（未考虑环）
     * @param head 原链表的头
     * @return 新链表的头
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null)return null;
        ListNode p = null;
        while (head != null){
            ListNode node = new ListNode(head.val);
            node.next = p;
            p = node;
            head = head.next;
        }
        return p;
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个结点。（未考虑环）
     * @param head 头结点
     * @param k 序号
     * @return 节点
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0)return null;
        ListNode pre = head;
        ListNode tal = head;
        for (int i = 0; i < k - 1; i++){
            if (pre.next != null){
                pre = pre.next;
            }else {
                return null;
            }
        }
        while (pre.next != null){
            pre = pre.next;
            tal = tal.next;
        }
        return tal;
    }
    /**
     * 奇数放在前，偶数放在后(要求稳定)
     * @param array 待排序数组
     */
    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0)return;
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 == 0){
                int j = i;
                for (j = i + 1; j < array.length; j++){
                    if (array[j] % 2 == 1)break;
                }
                if (j < array.length){
                    int temp = array[j];
                    for (int k = j - 1; k >= i; k--){
                        array[k + 1] = array[k];
                    }
                    array[i] = temp;
                }

            }

        }
        for (Integer i :
                array) {
            System.out.print(i + " ");
        }

    }


    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * @param base 底数
     * @param exponent 指数
     * @return double结果
     */
    public double Power(double base, int exponent) {
        if (exponent == 0) return 1.0;
        if (exponent > 0){
            return powerCore(base, exponent);
        }else {
            return 1.0/powerCore(base, -exponent);
        }
    }

    private double powerCore(double base, int exponent) {
        if (exponent == 0)return 1.0;
        if (exponent == 1)return base;
        if (exponent % 2 == 0){
            return powerCore(base, exponent/2) * powerCore(base, exponent/2);
        }else {
            return powerCore(base, exponent - 1) * base;
        }
    }

    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
     * @param n 数字
     * @return 1的个数
     */
    public int NumberOf1(int n) {
        int count = 0;
        // 要用 n ！= 0 而不是 n > 0 ,因为可能是负数
        while (n != 0){
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    /**
     * 非递归 斐波那契
     * @param n 第n个数
     * @return 第n个斐波那契数列值
     */
    public int Fibonacci_next(int n) {
        if (n == 0){
            return 0;
        }else if (n == 1 || n == 2){
            return 1;
        }else {
            int one = 1;
            int two = 1;
            for (int i = 3; i <= n; i++){
                int temp = two;
                two = one + two;
                one = temp;
            }
            return two;
        }
    }
    /**
     *  斐波那契数列
     * @param n 第n个数
     * @return 第n个斐波那契数列值
     */
    public int Fibonacci(int n) {
        if (n == 0){
            return 0;
        }else if (n == 1 || n == 2){
            return 1;
        }else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }

    /**
     * 旋转数组的最小元素（未通过，暂未发现原因）
     * 已发现原因，将start = mid + 1;改为start = mid;以此确保在跳出while循环时前，数组时旋转的不是递增的
     * @param array 待查找数组
     * @return 最小值
     */
    public int minNumberInRotateArray(int[] array){
        //边界处理
        if (array == null || array.length == 0){
            return 0;
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
                start = mid;
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
                    break;
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

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}