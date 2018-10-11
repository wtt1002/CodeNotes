package qiuzhao.didi;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

/**
 * Package: qiuzhao.didi
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/10/10 20:38
 */
public class question_1_new {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] v = new int[n + 1];
        LinkedNode head = new LinkedNode();
        head.val = scanner.nextInt();
        LinkedNode p = head;
        for (int i = 1; i < n; i++){
            LinkedNode node = new LinkedNode();
            node.val = scanner.nextInt();
            node.pre = p;
            p.aft = node;
            p = p.aft;
        }

        LinkedNode pMin;
        int minmin = 100000;
        for(int i = 0; i < m; ++ i){
            p = head;
            pMin = head;
            int min = 100000;
            while (p != null){
                if (p.val < min){
                    min = p.val;
                    pMin = p;
                    System.out.println("里面pMin:" + pMin.val);
                }
                p = p.aft;
            }
            System.out.println("pMin:" + pMin.val);
            if (pMin == null)break;
            if (pMin.pre != null && pMin.aft != null){
                if (pMin.pre.val <= pMin.aft.val){
                    pMin.pre.val = pMin.pre.val + pMin.val;
                    pMin.pre.aft = pMin.aft;
                    pMin.aft.pre = pMin.pre;
                }else {
                    pMin.aft.val = pMin.aft.val + pMin.val;
                    pMin.pre.aft = pMin.aft;
                    pMin.aft.pre = pMin.pre;
                }
            }else if (pMin.pre != null){
                pMin.pre.val = pMin.pre.val + pMin.val;
                pMin.pre.aft = null;

            }else if (pMin.aft != null){
                pMin.val = pMin.aft.val + pMin.val;
                pMin.aft = pMin.aft.aft;
                pMin.aft.pre = pMin;
            }else {

            }


        }
        while (head != null){
            if (head.val < minmin){
                minmin = head.val;
            }
            System.out.println("..." + head.val);
            head = head.aft;
        }
        System.out.println(minmin);
    }
}
class LinkedNode{
    public int val;
    public LinkedNode pre = null;
    public LinkedNode aft = null;
}
