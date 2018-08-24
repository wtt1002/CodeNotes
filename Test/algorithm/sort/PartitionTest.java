package algorithm.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Package: algorithm.sort
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/7/16 21:19
 */
public class PartitionTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void partition_base() throws Exception {
    }


    Partition partition = new Partition();
    int[] array = {3, 5, 2, 7, 4, 9, 8, 1, 6};

    @Test
    public void partition_random() throws Exception {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        partition.partition_random(array, 0, array.length - 1);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
    @Test
    public void partition_last() throws Exception {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        partition.partition_last(array, 0, array.length -1);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    @Test
    public void test1(){
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        partition.partition(array, 0, array.length - 1);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}