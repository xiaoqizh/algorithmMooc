package AlgorithmPractice.chapter5_BinarySearch;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 19:11 2018/1/31
 * @Description: 因为二分查找树并不能用数组进行表示
 *               所以需要用节点
 */

public class BSTreeNode {
    /**
     * 插入节点的时候总要先创建节点
     */
    private int key;
    private String value;
    private BSTreeNode left;
    private BSTreeNode right;

    public BSTreeNode() {
        this.key = 0;
        this.value = null;
        this.left = null;
        this.right = null;
    }

    public BSTreeNode(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BSTreeNode getLeft() {
        return left;
    }

    public void setLeft(BSTreeNode left) {
        this.left = left;
    }

    public BSTreeNode getRight() {
        return right;
    }

    public void setRight(BSTreeNode right) {
        this.right = right;
    }
}

