/**
 * Package: PACKAGE_NAME
 * Description： 一个链表中包含环，请找出该链表的环的入口结点。
 * Author: TingTing W
 * Date: Created in 2018/6/21 10:08
 */
public class LinkedWithCircle {
    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7,8,9};
        ListNode head = buildList(array,true,0);
        System.out.println(EntryNodeOfLoop(head).val);

    }


    /**
     * 寻找带环链表的环入口节点
     * @param pHead
     * @return
     */
    private static ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode intersect = hasCircle(pHead);
        if (intersect != null){
            ListNode ptrOne = pHead;
            ListNode ptrTwo = intersect;
            while (ptrOne != ptrTwo){
                ptrOne = ptrOne.next;
                ptrTwo = ptrTwo.next;
            }
            return ptrOne;
        }
        return null;
    }

    /**
     * 判断是否存在环
     * @param pHead
     * @return
     */
    private static ListNode hasCircle(ListNode pHead){
        ListNode singleStep = pHead;
        ListNode doubleStep = pHead;
        ListNode interNode = null;
        while (singleStep != null && doubleStep != null && doubleStep.next != null){
            singleStep = singleStep.next;
            doubleStep = doubleStep.next.next;
            if (singleStep == doubleStep){
                interNode = singleStep;
                break;
            }
        }
        return interNode;
    }

    /**
     * 建立链表
     * @param array 初始数组
     * @param isCircle 是否有环
     * @param startIndexOfCir 环开始下标
     * @return
     */
    private static ListNode buildList(int [] array, boolean isCircle, int startIndexOfCir){
        if (array == null || array.length <= 0){
            return null;
        }
        ListNode head = new ListNode(array[0]);
        ListNode pNode = head;
        if (isCircle && startIndexOfCir >= 0 && startIndexOfCir < array.length){
            ListNode entranceNode = null;
            for (int i = 0; i < array.length; i++){
                ListNode node = new ListNode(array[i]);
                if (startIndexOfCir == i){
                    entranceNode = node;
                }
                pNode.next = node;
                pNode = node;
            }
            pNode.next = entranceNode;

        }else {
            for (int i = 0; i < array.length; i++){
                ListNode node = new ListNode(array[i]);
                pNode.next = node;
                pNode = node;
            }
        }
        return head;
    }
}

/**
 * 节点类
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}