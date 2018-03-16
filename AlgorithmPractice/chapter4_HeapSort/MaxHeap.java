package AlgorithmPractice.chapter4_HeapSort;

import AlgorithmPractice.chapter2_SimpleSort.SortTestHelper;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 16:32 2018/1/29
 * @Description:
 *          最大堆作为一个泛型类 容纳各种数据
 */

public class MaxHeap {
    /**
     *  堆的容量
     *  堆中的数量
     *  用来保存二叉堆的数组
     */
    private  int capacity;
    private  int count;
    private  int[] items;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        //创建当前泛型数组 第0个是不放元素的
        items =  new int[capacity+1];
        //没有插入值,count为0
        count = 0;
    }

    public MaxHeap(int[] array, int n) {
        //把一个数组进行堆化;这个其实也是
        // 原理：所有的叶子节点其实都是一个最大堆 因为只有一个节点
        items = new int[n + 1];
        this.capacity = n;
        this.count = n;
        for (int i = 0; i < n; i++) {
            items[i + 1] = array[i];
        }
        //然后再进行堆化数组
        //count / 2 就是第一个非叶子节点
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    /**
     * 向堆中插入元素
     * 一定要牢记二叉堆的性质
     * @return
     */
    public void insert(int  t) {
        //进行数组大小的自动扩展;以二倍为方案进行拓展
        if (count >= capacity) {
            int[] itemsTemp = new int[2 * capacity];
            //把原来数组中的内容赋值到新的数组中  其实这里capacity与count是相同的
            for (int i = 1; i <= capacity; i++) {
                itemsTemp[i] = items[i];
            }
            this.capacity = this.capacity * 2;
            //把items重新赋值就ok
            items = itemsTemp;
        }
        //先赋值
        count ++;
        items[count] = t;
        shiftUp(count);
    }

    public  int getMaxValue() {
         //得到堆中最大的元素 其实也是出队列的操作  第一个肯定是最大值
        int item = this.items[1];
        //得到最大值之后然后再把堆重新进行排序
        SortTestHelper.swap(items, 1, count);
        this.count --;
        shiftDown(1);
        return  item;
    }

    private void shiftDown(int k) {
        //k是当前位置;k * 2 <= count说明有左孩子 但是可能没有右孩子;
        while (2 * k <= count) {
            //j+1 确定是否有右孩子;j是要交换的位置
            int j = 2* k;
            //当有左右孩子时
            if (j + 1 <= count && items[j] < items[j + 1]) {
                j += 1;
            }
            if (items[k] >= items[j]) {
                break;
            }
            SortTestHelper.swap(items, k, j);
            k++;
//            k = j;
        }
    }

    private void shiftUp(int currentIndex) {
        //在二叉堆 自底向上的插入值；count 就是当前的指针;如果不满足则还是与按顺序的插入
        //数组在items[1]的位置开始存储
        while (currentIndex > 1 && items[currentIndex] > items[currentIndex / 2]) {
            //如果大于就向上增加数值 并交换数值
            SortTestHelper.swap(items, currentIndex, currentIndex / 2);
            currentIndex = currentIndex / 2;
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return  count == 0;
    }

    public void printArray() {
        for (int i = 1; i <= count; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(items[i]+" ");
        }
        System.out.println();
    }

    public void printCapacity() {
        System.out.println(capacity);
    }
}
