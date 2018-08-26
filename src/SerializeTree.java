import java.util.Stack;

/**
 * Package: PACKAGE_NAME
 * Description： 请实现两个函数，分别用来序列化和反序列化二叉树
 * Author: TingTing W
 * Date: Created in 2018/6/24 10:36
 */
public class SerializeTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode root = buildTree();
        Serialize(root);
    }
//    public static String Serialize(TreeNode root) {
//        StringBuilder sb = new StringBuilder();
//        getSerializeString(root, sb);
//        if(sb.length() != 0)
//        sb.deleteCharAt(sb.length()-1);
//        System.out.println(sb.toString());
//        return sb.toString();
//    }
//    public static void getSerializeString(TreeNode root, StringBuilder sb){
//    if(root == null) sb.append("#,");
//    else{
//        sb.append(root.val + ",");
//        getSerializeString(root.left, sb);
//        getSerializeString(root.right, sb);
//        }
//    }
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

    public static String Serialize(TreeNode root) {
        StringBuffer buffer = new StringBuffer();
        if (root == null){
            buffer.append("#");
        }else {
            buffer.append(root.val);
            coreSerialize(root.left,buffer);
            coreSerialize(root.right,buffer);
        }
        System.out.println(buffer.toString());
        return buffer.toString();
    }
    private static void coreSerialize(TreeNode root, StringBuffer buffer){
        if (root == null){
            buffer.append(",#");
        }else {
            buffer.append(","+root.val);
            if (root.left == null && root.right == null){
                buffer.append(",#,#");
            }else if (root.left == null){
                buffer.append(",#");
                coreSerialize(root.right,buffer);
            }else if (root.right == null){
                coreSerialize(root.left,buffer);
                buffer.append(",#");
            }else {
                coreSerialize(root.left,buffer);
                coreSerialize(root.right,buffer);
            }
        }

    }
    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0){
            return null;
        }
        String [] nodes = str.split(",");
        int rootVal = Integer.parseInt(nodes[0]);
        TreeNode root = null;
        int index = 0;
        coreDeserialize(root,nodes,index);

        return null;
    }
    private static void coreDeserialize(TreeNode root, String [] nodes, int index){
        if (root == null){
            root = new TreeNode(Integer.parseInt(nodes[index]));
        }else {
            if (!nodes[index].equals("#")){
                int val = Integer.parseInt(nodes[index]);
                TreeNode node = new TreeNode(val);

            }
        }
    }
}
