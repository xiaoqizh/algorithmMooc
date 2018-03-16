package AlgorithmPractice.chapter3_advancedSort;

import AlgorithmPractice.chapter2_SimpleSort.SortTestHelper;
import com.sun.org.apache.bcel.internal.generic.SWAP;
import com.sun.xml.internal.ws.util.xml.XMLStreamReaderToXMLStreamWriter;

import java.util.Random;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 11:59 2018/1/25
 * @Description: 高级排序的应用
 */

public class AdvancedSortHelper {

    private static final int RECURSION_VALUE = 15;
    private static final String MERGE_SORT = "mergeSort";
    private static final String MERGE_SORT_ENHANCE = "mergeSortEnhance";
    private static final String QUICK_SORT = "quickSort";

    public static void sortUseTime(String methodName,int[] array,int start,int end) {
        long startTime = System.currentTimeMillis();
        if (MERGE_SORT.equals(methodName)) {
            mergeSort(array, start, end);
        } else if (MERGE_SORT_ENHANCE.equals(methodName)) {
            mergeSortEnhance(array, start, end);
        } else if (QUICK_SORT.equals(methodName)) {
            quickSort(array, start, end);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(methodName+"所用时间为："+(endTime-startTime)+"ms");
    }
    /**
     * 归并排序mergeSort
     * 归并排序就是分治思想。先分后治。
     * 递归递归 先递 然后在归
     * 这种递归方式其实就是自顶向下的归并
     * */
    public static void mergeSort(int[] array, int start, int end) {
        if (start >= end) { return; }
        int middle = (start + end) / 2;
        //对整个数组的左半部分进行归并
        mergeSort(array, start, middle);
        //对右半部份进行归并
        mergeSort(array, middle+1, end);
        //把顺序的两个数组进行归并 是在整个array数组里面分块进行归并
        mergeArray(array, start, middle, end);
    }
    public static void mergeSortEnhance(int[] array, int start, int end) {
        //这里是递归到只有两个或者只有一个的时候 就是说明递归到底了
        //这里的优化 其实可以不必递归到底,小数组可以直接使用插入排序
        //小范围内的插入排序效率更高
//      if (start >= end) { return; }
        if ((end - start) >= RECURSION_VALUE) {
            SortTestHelper.insertionSortByRange(array, start, end);
        }
        int middle = (start + end) / 2;
        mergeSort(array, start, middle);
        mergeSort(array, middle+1, end);
        //在归并的时候 从中间值判断结果是否已经有序了
        if (array[middle] > array[middle + 1]) {
            mergeArray(array, start, middle, end);
        }
    }

    /**
     * 归并数组是从 只有两个值的数组开始排序的 然后在进一步的进行排序：并
     * @param array
     * @param start
     * @param middle
     * @param end
     */
    private static void mergeArray(int[] array, int start, int middle, int end) {
        //创建一个辅助数组aux (aux本身就是辅助的意思)
        //目的是为了 让这个数组临时保存要进行归并的代码块
        int[] aux = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            aux[i - start] = array[i];
        }
        //i是数组左边，j是数组右边
        int i = start;
        int j = middle + 1;
        //但是每一个操作都是有偏移量的
        for (int k = start; k <= end; k++) {
            if (i > middle) {
                array[k] = aux[j - start];
                j++;
            }
            else if (j > end) {
                array[k] = aux[i - start];
                i++;
            }
            else if (aux[i - start] < aux[j - start]) {
                array[k] = aux[i - start];
                i++;
            }
            else {
                array[k] = aux[j - start];
                j++;
            }
        }
    }

    /**
     * @Description: 快速排序
     * 以数组的第一个值为基准 把数组分成大于该值的 和小于该值的 一共两部分
     * 依次递归  直到递归到 一个数组只有俩个值的时候（未优化）
     *  选择排序还是需要递归进行
     *
     *  其实下面这俩属于二路排序
     */
    public static void quickSort(int[] array, int l, int r) {
        //递归一定要有递归结束的条件\
        //高级排序到了底层大多可以使用基本排序进行优化
      /*  if (l >= r) {
            return;
        }*/
        if ((r - l) <= RECURSION_VALUE) {
            SortTestHelper.insertionSortByRange(array, l, r);
            return;
        }
        //把数组进行第一次分割
        //q是中间那个，作为左右的界限
        int q = partition(array, l, r);
        quickSort(array, l, q-1);
        quickSort(array, q + 1, r);
    }

    public static int partition(int[] array, int l, int r) {
        //获得当前第一个元素的值(其实这每次选择最左边的一个值 对于基本有序的数组效率是十分低的)
        //但是可以改成选择一个随机数
        Random random = new Random();
        int randomIndex = random.nextInt((r - l));
        SortTestHelper.swap(array, l, randomIndex+l);
        int firstValue = array[l];
        //j存储注释中两个数组的分界值
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if(array[i] < firstValue) {
                //这里为什么是j+1:因为要多扩展出一个位子 不能与j交换
                //j本身就是小于firstValue的值了 所以要换j后面的一个
                //SortTestHelper.swap(array, i,j+1);
                j++;
            }
        }
        //只需要把firstValue放到合适的位置
        SortTestHelper.swap(array, l, j);
        //返回的是处于中间值的指针
        return j;
    }

    /**
     * 下面这种分割使相等的元素分散在两个数组之中，这样对于含有大量重复的值的数组；
     * 使分割之后的数组大小基本相同！
     * @param array
     * @param l
     * @param r
     * @return
     */
    public static int partition2(int[] array, int l, int r) {
        //上一中分割的方法在对于含有大量重复元素的数组时。划分的数组大小很不均衡  因为重复的在一侧
        //所以导致了分割的两个数组大小很不均衡
        //随机选择一个数作为交换  就不再使用第一个数组，因为随机性太小
        Random random = new Random();
        int nextInt = random.nextInt(r - l)+l;
        System.out.println(nextInt);
        SortTestHelper.swap(array, l, nextInt);
        int firstValue = array[l];
        //还是因为第一个值 是作为基准值了
        int  i =l+1 ,j= r;
        while (true) {
            //在左边找出第一个大于firstValue的；下面的同理
            while (array[i] < firstValue && i<=r) { i++; }
            while (array[j] > firstValue && j>=l+1) { j--;}
            //while的结束条件 就是i左边的指针与j右边的指针
            if (i >= j) { break; }
            //如果碰到了 那么就交换值
            SortTestHelper.swap(array, i, j);
            //其实这里 i++ j++ 不写也可以
            //因为上一行代码已经交换了值了
            i++;
            j--;
        }
        //这时候基准值还在数组的最左侧 交换的是比较小的数组的最右边一个
        // 但是这里为什么是j呢？
        //因为j指针就是找的就是小于firstValue的
        SortTestHelper.swap(array, l,j );
        return j;
    }
}
