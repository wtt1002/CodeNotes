package algorithm.sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Package: algorithm.sort
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/7/22 16:22
 */
public class MergeSortTest {

    MergeSort mergeSort = new MergeSort();
    int[] array = {3, 5, 2, 7, 4, 9, 8, 1, 6};
    int[] temp = new int[array.length];
    @Test
    public void test1(){
        mergeSort.sort(array, temp, 0, array.length - 1);
        for (int num :
                array) {
            System.out.print(num + " ");
        }
    }

    @Test
    public void sort() throws Exception {

    }

    @Test
    public void merge() throws Exception {
    }




}