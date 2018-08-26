package algorithm.sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Package: algorithm.sort
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/7/15 14:23
 */
public class ExchangeTest {

    @Test
    public void test1(){
        int [] array = {6, 8, 2, 9, 5, 1, 3};
        Exchange exchange = new Exchange();
        exchange.ExchangeSort(array);
    }



}