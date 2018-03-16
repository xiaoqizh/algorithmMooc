package AlgorithmPractice.chapter5_BinarySearch;

import org.junit.Test;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 17:34 2018/1/31
 * @Description:
 */

public class BinarySearchTest {

    @Test
    public void BinaryTest1() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(BinarySearch.binarySearch(array, 10, 8));
        System.out.println(BinarySearch.binarySearchRec(array, 10, 8));
    }

    @Test
    public void BSTreeTest(){
        BSTree bst = new BSTree();
        bst.insert(26,"26");
        bst.insert(16,"16");
        bst.insert(13,"13");
        bst.insert(22,"22");
        bst.insert(30,"30");
        bst.insert(29,"29");
        bst.insert(42,"42");
        System.out.println(bst.getCount());
        bst.preOrder();
        System.out.println();
        System.out.println(bst.contains(16));
        System.out.println(bst.search(16));
        System.out.println(bst.getMin());
    }
    /**
     * @Description:
     */
    @Test
    public void BSTreeTest2(){
        BSTree bst = new BSTree();
        bst.insert(26,"26");
        bst.insert(16,"16");
        bst.insert(13,"13");
        bst.insert(22,"22");
        bst.insert(30,"30");
        bst.insert(29,"29");
        bst.insert(42,"42");
        System.out.println(bst.getCount());
        bst.preOrder();
        System.out.println();
        System.out.println(bst.getMin());
        System.out.println(bst.getMax());
    }

    /**
     * @Description:
     */
    @Test
    public void BSTreeTest3() {
        BSTree bst = new BSTree();
        bst.insert(26,"26");
        bst.insert(16,"16");
        bst.insert(13,"13");
        bst.insert(22,"22");
        bst.insert(30,"30");
        bst.insert(29,"29");
        bst.insert(42,"42");
        bst.preOrder();
        System.out.println();
        System.out.println(bst.getMin());
        bst.removeMin();
        bst.removeMax();
        bst.preOrder();

    }
    @Test
    public void BSTreeTest4() {
        BSTree bst = new BSTree();
        bst.insert(28,"28");
        bst.insert(16,"16");
        bst.insert(13,"13");
        bst.insert(22,"22");
        bst.insert(30,"30");
        bst.insert(29,"29");
        bst.insert(42,"42");
        bst.remove(42);
        bst.postOrder();
        System.out.println("二分搜索树的数量为"+bst.getCount());
    }
}
