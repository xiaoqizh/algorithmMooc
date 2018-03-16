package AlgorithmPractice.chapter2_SimpleSort;

import java.util.Random;
/**
 * @Author: xiaoqiZh
 * @Date: Created in 15:23 2018/1/22
 * @Description: 测试算法的工具类
 */

public class SortTestHelper {
    private static final String SELECTION_SORT = "selectionSort";
    private static final String INSERTION_SORT = "insertionSort";
    private static final String INSERTION_SORT_ENHANCE = "insertionSortEnhance";
    /**
     * 根据排序名字选择具体的排序方法
     */
    public  static void sortUseTime(String sortName, int[] array, int n) {
        long start = System.currentTimeMillis();
        if (SELECTION_SORT.equals(sortName)) {
            selectionSort(array, n);
        } else if (INSERTION_SORT.equals(sortName)) {
            insertionSort(array, n);
        } else if (INSERTION_SORT_ENHANCE.equals(sortName)) {
            insertionSortEnhance(array, n);
        }
        long end = System.currentTimeMillis();
        System.out.println(sortName+"  所用时间为:" + (end - start) + "ms");
    }

    /**
     *        对数组的排序和排序的泛型版本
     * @param array
     * @param n
     */
    public static void selectionSort(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            //寻找[i.n)之间的最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            SortTestHelper.swap(array, i, minIndex);
        }
    }

    public static  void selectSortGeneric(Comparable[] array, int n) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            System.out.print("");
            for (int j = i + 1; j < n; j++) {
                if ( array[minIndex].compareTo(array[j]) >0) {
                    minIndex = j;
                }
            }
            SortTestHelper.swapGeneric(array, i, minIndex);
        }
    }


    /**
     * 对数组的插入排序
     * 插入排序就跟玩扑克一样 一张一张的进行插入
     * 第一张的时候 肯定是有序的，因为只有一张！
     *
     * 插入排序对于基本有序的数组 排序所用的时间是最少的。这也是插入排序特性
     * 泛型方法与 selectionSort一样 就是换成Comparable[]就行
     *
     * 数组之间交换 需要三次赋值操作，但是一次比较需要的时间比一次赋值所用的时间要少。
     * 所以要尽可能的进行比较而不是每次比较之后都进行三次赋值（就是数组元素的交换）
     * 插入排序在针对基本有序数组时，进行排序的效率是最高的！多数的数据都是几乎有序的
     **/
    public static void insertionSort(int[] array, int n) {
        //因为第一张肯定是有序的 所以i从1开始排
        for (int i = 1; i < n; i++) {
            //开始从第二张进行插入;总是两个相邻的进行比较！第二个循环与i无关
            //思考：j>0 而不是j>=0? 因为总是比较j 与j-1 两个所以j>=1
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                swap(array, j - 1, j);
            }
        }
    }
    public static void insertionSortEnhance(int[] array, int n) {
        //大致的思想：选择出最小的，先不交换数组，在比较出最小的值之后在进行交换赋值
        //赋值系统耗费比较大
        for (int i = 1; i < n; i++) {
            int currentValue = array[i];
            int j;
            //在for循环进行判断性能更好
            //循环比较i之前的数值。进行比较
            for (j = i; j > 0 && currentValue < array[j - 1]; j--) {
                //当前值往后挪一个；此时的j指针就是currentValue应该存放的位置
                array[j] = array[j - 1];
            }
            array[j] = currentValue;
        }
    }

    public static void insertionSortByRange(int[] array, int l, int r) {
        //对数组的一部分进行插入排序[l,r].谁说离散数学没用了?
        //这里是l+1 因为下面有个 j-1  其实还是因为只有一个数的时候数组肯定是有序的
        for (int i = l+1; i <= r; i++) {
            //与上一个insertionSortEnhance一样
            int currentValue = array[i];
            int j ;
            for (j = i; j > l && currentValue < array[j-1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = currentValue;
        }
    }

    /**
     * @Description:    用于值的交换:要知道java中没有c中的指针 但是可以事先把数组传递过来
     *                  java中没有对应的交换值的api 没有c那种指针
     *
     *                  注意： 这里传递的肯定是数组的下标 而不是具体的值！
     * @Date: 16:11 2018/1/22
     */
    public  static  int[] swap(int[] array,int indexFirst,int indexSecond) {
        if (indexFirst > array.length || indexSecond > array.length) {
            throw new IllegalArgumentException("数组下标越界！");
        }
        int temp = array[indexFirst];
        array[indexFirst] = array[indexSecond];
        array[indexSecond] = temp;
        return array;
    }
    public  static  Comparable[] swapGeneric(Comparable[] array,int indexFirst,int indexSecond) {
        if (indexFirst > array.length || indexSecond > array.length) {
            throw new IllegalArgumentException("数组下标越界！");
        }
        System.out.print("");
        Comparable temp = array[indexFirst];
        array[indexFirst] = array[indexSecond];
        array[indexSecond] = temp;
        return array;
    }

    /**
     * @Description: 产生范围内的随机数
     *               下面的是产生一定数目的基本有序的数组 用来测试排序算法的性能
     * @Date: 15:57 2018/1/22
     */
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        Random random = new Random();
        int[] array = new int[n];
        int width = rangeR - rangeL;
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(width) + rangeL;
        }
        return array;
    }

    public static int[] generateNearlyOrderedArray(int n, int swapTimes) {
        //产生基本有序的数组:包含n个数字  交换了swapTimes次
        Random random = new Random();
        int[] generateArray = new int[n];
        for (int i = 0; i < n; i++) {
            generateArray[i] = i;
        }
        //然后在随机的打乱顺序
        for (int i = 0; i < swapTimes; i++) {
            int swap1 = random.nextInt(n);
            int swap2 = random.nextInt(n);
            swap(generateArray, swap1, swap2);
        }
        return generateArray;
    }

    /**
     * @Description: 对数据进行打印
     *               下面是对泛型进行打印的
     * @Date: 15:58 2018/1/22
     */
    public static void printArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 10) {
                System.out.print(" "+array[i]);
                System.out.print(" ");
            } else  {
                System.out.print(array[i]+" ");
            }
            if (i != 0 && i % 10 == 0) {
                System.out.println();
            }
        }
    }
    public static void printArrayGeneric(Comparable [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(" ");
            System.out.println(array[i]+" ");
            if (i != 0 && i % 10 == 0) {
                System.out.println();
            }
        }
    }

    /**
     * 判断数组是否有序
     */
    public boolean isSorted(int[] array) {
        for (int i : array) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
