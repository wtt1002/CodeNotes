package algorithm.search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Package: algorithm.search
 * Description： TODO
 * Author: TingTing W
 * Date: Created in 2018/7/22 22:21
 */
public class BinarySearchTest {
    BinarySearch binarySearch;
    int[] array = {1, 2, 4, 6, 7, 9, 11, 12, 15};
    @Before
    public void setUp() throws Exception {
        binarySearch = new BinarySearch();

    }

    @Test
    public void binarySearch() throws Exception {
        System.out.println(binarySearch.binarySearch(array, 5));
        System.out.println(binarySearch.binarySearch(array, 7));
    }

}