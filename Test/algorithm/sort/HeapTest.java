package algorithm.sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Package: algorithm.sort
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/7/15 16:26
 */
public class HeapTest {

    @Test
    public void test1(){
        Heap heap = new Heap();
        int[] array = {6, 8, 10, 9, 2, 7, 3, 5, 4, 11, 1, 14, 0};
        heap.heapSort(array);
        for (int num :
                array) {
            System.out.println(num);
        }
    }
}