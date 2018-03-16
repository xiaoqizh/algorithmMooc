package AlgorithmPractice.chapter3_advancedSort;

import AlgorithmPractice.chapter2_SimpleSort.SortTestHelper;
import org.junit.Test;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 16:05 2018/1/25
 * @Description:
 */

public class AdvancedSortTest {
    /**
     * @Description: 为什么这里的归并排序所用的时间更长
     */
    @Test
    public void mergeSortTest(){
        int  n = 10000;
        int[] array = SortTestHelper.generateRandomArray(n, 0, n);
        AdvancedSortHelper.sortUseTime("mergeSort",array,0,(n-1));
        AdvancedSortHelper.sortUseTime("mergeSortEnhance",array,0,(n-1));
        AdvancedSortHelper.sortUseTime("quickSort",array,0, (n-1));
    }

    /**
     * @Description:
     */
    @Test
    public void partitionTest(){
        int  n = 10000;
        int[] array = SortTestHelper.generateRandomArray(n, 0, n);
        int[] randomArray = {5, 6, 7, 8, 9, 1, 2, 3, 4, 0,10};
        AdvancedSortHelper.quickSort(array, 0, n - 1);

    }
    /**
     * @Description:
     *
     */
    @Test
    public void partitionEnhanceTest(){
        int  n = 10000;
        int[] array = SortTestHelper.generateRandomArray(n, 0, n);
        int[] randomArray = {5, 6, 7, 8, 9, 1, 2, 3, 4, 10};
        AdvancedSortHelper.quickSort(randomArray, 0, 9);
        SortTestHelper.printArray(randomArray);
    }

    @Test
    public void partition2Test(){
        int[] arr = {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};
        SortTestHelper.printArray(arr);
        System.out.println();
        AdvancedSortHelper.partition(arr, 0, 9);
        SortTestHelper.printArray(arr);
    }
}
