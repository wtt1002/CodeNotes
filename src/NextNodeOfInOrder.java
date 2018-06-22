/**
 * Package: PACKAGE_NAME
 * Description： 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * Author: TingTing W
 * Date: Created in 2018/6/22 10:57
 */

public class NextNodeOfInOrder {

    private TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        //节点为空，返回空
        if (pNode == null){
            return pNode;
        }
        //如果节点的右孩子存在，则找出右孩子的最左孩子
        if (pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        //右孩子不存在，则不断向上找父节点，直到找到一个节点a，a是父节点F的左孩子，返回父节点F。
        while (pNode.next != null){
            if (pNode == pNode.next.left){
                return pNode.next;
            }else {
                pNode = pNode.next;
            }
        }
        //退到根节点都没有找到，返回null
        return null;
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}