package AlgorithmPractice.chapter5_BinarySearch;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 17:28 2018/1/31
 * @Description:
 */

public class BinarySearch {
    /**
     * 二分查找的非递归版本
     * 数组一定是要有序的
     */
    public static int binarySearch(int[] array, int n,int target) {
       return   binarySearchAux(array, 0, n - 1, target);
    }

    public static int binarySearchAux(int[] array, int l, int r, int target) {

        while (l <= r) {
            int middle = l + (r - l) / 2;
            if (array[middle] == target) {
                return middle;
            }
            if (array[middle] > target) {
                r = middle - 1;
            } else {
                l = middle + 1;
            }
        }
        return -1;
    }

    /**
     *  二分查找法的递归版本
     * @return
     */
    public static int binarySearchRec(int[] array, int n, int target) {
        return binarySearchRecAux(array, 0, n - 1, target);
    }

    /**
     * 递归法的辅助函数
     */
    private static int binarySearchRecAux(int[] array, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (array[mid] == target) {
            return  mid;
        }
        else if (array[mid] > target) {
            //注意这里的return 为什么?
            return   binarySearchRecAux(array, l, mid - 1, target);
        } else {
            return  binarySearchRecAux(array, mid + 1, r, target);
        }
    }
    }


