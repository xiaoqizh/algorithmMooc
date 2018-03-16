package AlgorithmPractice.chapter2_SimpleSort;

import org.junit.Test;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 16:46 2018/1/22
 * @Description:  选择排序测试
 */

public class SimpleSortTest {

    /**
     * @Description: 选择排序测试
     */
    @Test
    public void selectionSortTest (){
//        int[] array = {10,9,8,7,6,5,4,3,2,1};
        int[] array = SortTestHelper.generateRandomArray(10, 0, 10);
        SortTestHelper.swap(array, 1, 6);
        SortTestHelper.printArray(array);
        System.out.println();
        SortTestHelper.selectionSort(array, 10);
//        selectSortGeneric(integers, 5);
        SortTestHelper.printArray(array);

    }
    /**
     * @Description: 插入排序测试
     */
    @Test
    public void insertionSortTest (){
        int[] array = {5,4,3,2,1,10,9,8,7,6};
        SortTestHelper.printArray(array);
        System.out.println();
        SortTestHelper.insertionSort(array, 10);
        SortTestHelper.printArray(array);
        int[] array1 = {5,4,3,2,1,10,9,8,7,6,5};
        System.out.println();
        SortTestHelper.insertionSortEnhance(array1, 11);
        SortTestHelper.printArray(array1);
    }

    /**
     * @Description: 对泛型方法进行测试
     */
    @Test
    public void testGeneric(){
        CompareUseCase[] useCases = {new CompareUseCase("zhangsan", 12),
                new CompareUseCase("lisi", 20),
                new CompareUseCase("wangwu", 3),
                new CompareUseCase("zhaoliu", 30),};
        SortTestHelper.selectSortGeneric(useCases, 4);
        SortTestHelper.printArrayGeneric(useCases);
    }
    /**
     * @Description:
     */
    @Test
    public void testTime(){
        int n = 10000;
        int[] array = SortTestHelper.generateNearlyOrderedArray(n,10);
        SortTestHelper.sortUseTime("insertionSort",array,n);
        int[] array1 = SortTestHelper.generateNearlyOrderedArray(n, 10);
        SortTestHelper.sortUseTime("insertionSortEnhance", array1, n);
    }

    /**
     * @Description: 对数组中一部分进行选择排序
     */
    @Test
    public void testInsertRange() {
        int[] array = {5, 4, 3, 2, 1, 10, 9, 8, 7, 6};
        SortTestHelper.insertionSortByRange(array, 1, 5);
        SortTestHelper.printArray(array);
    }
}
