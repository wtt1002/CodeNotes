import java.util.Stack;

/**
 * Package: PACKAGE_NAME
 * Description： 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * Author: TingTing W
 * Date: Created in 2018/6/20 21:24
 */
public class TreeToDoubleLinked {
    public static void main(String[] args) {
        TreeNode root = buildTree();
        Convert(root);
    }

    /**
     * 建树
     * @return TreeNode
     */
    private static TreeNode buildTree()
    {
        TreeNode rootNode=new TreeNode(8);
        TreeNode node1=new TreeNode(6);
        //10----6
        TreeNode node2=new TreeNode(10);
        TreeNode node3=new TreeNode(5);
        TreeNode node4=new TreeNode(7);
        //9-----7
        TreeNode node5=new TreeNode(9);
        //11----5
        TreeNode node6=new TreeNode(11);
        rootNode.left=node1;
        rootNode.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        return rootNode;

    }
    private static TreeNode Convert(TreeNode pRootOfTree) {

        Stack<TreeNode> stack = new Stack<>();
        //TreeNode node = pRootOfTree;
        TreeNode preNode = null;
        TreeNode qNode = null;
        TreeNode head = null;
        while (pRootOfTree != null || stack.size() > 0){
            while (pRootOfTree != null){
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }
            if (stack.size() > 0){
                pRootOfTree = stack.pop();
                qNode = pRootOfTree;
                if (preNode == null){
                    preNode = qNode;
                    head = qNode;
                }else {
                   preNode.right = qNode;
                   qNode.left = preNode;
                   preNode = qNode;
                }
                pRootOfTree = pRootOfTree.right;
            }
        }
//        while (head != null){
//            System.out.println("自身："+head.val);
//            if (head.left != null){
//                System.out.println("====左孩子"+head.left.val);
//            }
//            if (head.right != null){
//                System.out.println("====右孩子"+head.right.val);
//            }
//
//            head = head.right;
//        }
        return head;
        //return null;
    }

}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
