package algorithm.sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Package: algorithm.sort
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/7/15 12:38
 */
public class BubbleTest {
    @Test
    public void test1(){
        Bubble bubble = new Bubble();
        int [] array = {3, 7, 6, 2, 4, 5};
        bubble.bubbleSort(array);
    }

}