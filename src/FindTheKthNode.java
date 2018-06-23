import java.util.Stack;

/**
 * Package: PACKAGE_NAME
 * Description： 给定一颗二叉搜索树，请找出其中的第k小的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 * Author: TingTing W
 * Date: Created in 2018/6/23 10:55
 */
public class FindTheKthNode {

    public static void main(String[] args) {
        TreeNode root = buildTree();
        // 1:5 2:6 3:7 4:8 5:9 6:10 7:11
        TreeNode outRoot = KthNode(root,8);
        if (outRoot == null){
            System.out.println("不存在");
        }else {
            System.out.println("节点："+outRoot.val);
        }

    }

    /**
     * 建树
     *        8
     *      /   \
     *     6    10
     *    / \   / \
     *   5  7  9   11
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
    //全局变量统计节点遍历的序号
    private static int index = 0;

    /**
     * 中序遍历找出第k个节点
     * @param pRoot 根节点
     * @param k 序号
     * @return
     */
    private static TreeNode KthNode(TreeNode pRoot, int k)
    {
        //边界处理：树为空；k值不合法
        if (pRoot == null || k <= 0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        //非递归中序遍历
        while (pRoot != null || stack.size() > 0){
            while (pRoot != null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            if (stack.size() > 0){
                pRoot = stack.pop();
                index ++;
                if (index == k){
                    return pRoot;
                }
                pRoot = pRoot.right;
            }
        }
        //k值不合法
        return null;
    }
}
