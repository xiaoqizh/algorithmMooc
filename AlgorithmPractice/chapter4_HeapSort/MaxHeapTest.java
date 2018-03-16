package AlgorithmPractice.chapter4_HeapSort;

import org.junit.Test;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 21:30 2018/1/29
 * @Description:
 */

public class MaxHeapTest {


    /**
     * @Description:
     */
    @Test
    public void maxHeapTest(){
        //这就是堆排序的方法
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(35);
        maxHeap.insert(15);
        maxHeap.insert(8);
        maxHeap.insert(20);
        maxHeap.insert(21);
        maxHeap.insert(31);
        maxHeap.insert(2);
        maxHeap.insert(40);
        maxHeap.printArray();
        maxHeap.printCapacity();
        int  size = maxHeap.size();
        System.out.println("最大堆的打印");
        for (int i = 0; i < size; i++) {
            System.out.print(maxHeap.getMaxValue()+" ");
        }

    }
    /**
     * @Description:
     */
    @Test
    public void maxHeap2Test(){
        int[] array = {7, 8, 9, 10, 1, 2, 3, 4, 5, 6};
        MaxHeap maxHeap = new MaxHeap(array, 10);
        int  size = maxHeap.size();
        System.out.println("最大堆的打印");
        for (int i = 0; i < size; i++) {
            System.out.print(maxHeap.getMaxValue()+" ");
        }
    }
}
