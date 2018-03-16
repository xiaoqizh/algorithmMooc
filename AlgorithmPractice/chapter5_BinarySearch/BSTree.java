package AlgorithmPractice.chapter5_BinarySearch;

import javafx.scene.transform.Rotate;

import java.util.Map;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 19:14 2018/1/31
 * @Description: 整个的二分搜索树
 *               其实还是迭代最容易理解了
 *               就算是递归 也能用迭代进行实现
 *               而且我觉得迭代更容易理解
 */

public class BSTree {
    /**
     * 如果BSTreeNode 不想被别人看到
     * 可以设计为静态内部类的方式进行创建
     */
    private BSTreeNode root;
    private int count;

    public BSTree() {
        this.root = null;
        this.count = 0;
    }

    public void insert(int key, String value) {
        if (root == null) {
            count++;
            root = new BSTreeNode(key, value);
            //这里必须有return
            return;
        }
        BSTreeNode current = root;
        BSTreeNode parent = root;
        boolean isLeft = true;
        while (current != null) {
            //parent就是要插入节点的父节点
            parent = current;
            //根据大小 判断下一个current的位置
            if (current.getKey() == key) {
                current.setValue(value);
                break;
            } else if (key > current.getKey()) {
                //确定下一个current节点的位置
                current = current.getRight();
                isLeft = false;
            } else {
                current = current.getLeft();
                isLeft = true;
            }
        }
        //结束循环的时候就是要插入节点的位置
        BSTreeNode insertedNode = new BSTreeNode(key, value);
        count++;
        if (isLeft) {
            //当初始化的时候 这个地方会多加了一个节点
            parent.setLeft(insertedNode);
        } else {
            parent.setRight(insertedNode);
        }
    }


    /**
     * 得到树中的最大值与最小值
     * 以及删除最大值 或 最小值之后
     * 删除最大值 最小值其实就是删除一个节点最简单的情况;因为最大值没有右孩子
     *              最小值没有左孩子
     */
    public int getMin() {
        return getMin(root);
    }

    private int getMin(BSTreeNode node) {
        //得到以node为根的最大值
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        //树的最左边的孩子就是最小值
        return node.getKey();
    }

    private void removeMin(BSTreeNode node) {
        //删除二叉树的最小值 就是最左边的;但是如果有左右孩子的话;那么就给更新节点
        //最小值肯定是没有 做节点的;最小值就是最左孩子
        //得到最小值的那个节点 node
        //parent存放的就是要被删除最小值的父节点
        BSTreeNode parent = root;
        while (node.getLeft() != null) {
            parent = node;
            node = node.getLeft();
        }
        //说明有右孩子 那就把右孩子放置到当前node
        if (node.getRight() != null) {
            parent.setLeft(node.getRight());
            count--;
            return;
        }
        //如果没有右孩子 那么这个最小值就是一个叶子结点 直接删除就ok
        //怎么删除呢:直接置为null就ok
        parent.setLeft(null);
        count--;
    }

    private void removeMax(BSTreeNode node) {
        //用来存放父节点的
        BSTreeNode  parent = root;
        while (node.getRight() != null) {
            parent = node;
            node = node.getRight();
        }
        //如果有左孩子的话 那么重新构造二叉树
        if (node.getLeft() != null) {
            parent.setRight(node.getLeft());
            count--;
            return;
        }
        //如果就是一个叶子节点那么就直接删除u
        parent.setRight(null);
        count--;
    }

    /**
     * 删除任意一个节点
     *  删除的节点如果同时有左右孩子的话 那么就
     *  删除其右孩子的最小的那个节点
     * @param key
     */
    public void remove(int key) {
        if (!contains(key)) {
            return;
        }
        //如果该键存在的话 就进行操作 否则返回null
        //找到该节点
        count--;
        BSTreeNode currentParent = root;
        BSTreeNode current = root;
        boolean isLeft = true;
        while(current != null) {
            if (current.getKey() < key) {
                currentParent = current;
                isLeft = false;
                current = current.getRight();
            } else if (current.getKey() > key){
                currentParent = current;
                isLeft = true;
                current = current.getLeft();
            } else if (current.getKey() == key) {
                //得到需要删除的key
                break;
            }
        }
        //current 就是需要删除的节点;parent就是其父节点； 只有左孩子 只有右孩子，有左右孩子分情况
        //如果有左右孩子的时候 右子树的最小值来进行代替
        if (current.getLeft() != null && current.getRight() != null) {
             //得到右子树最小值节点
            BSTreeNode tempMin = current.getRight();
            BSTreeNode tempMinParent = current.getRight();
            while(tempMin.getLeft() != null) {
                tempMinParent = tempMin;
                tempMin = tempMin.getLeft();
            }
            //current的位置其实不用动 只需要更改里面的值就好了
            //然后把右子树 替换被删除节点的位置
            int keya = tempMin.getKey();
            String valuea = tempMin.getValue();
            //TODO:这里为什么删除不了这个节点啊
            if (tempMin == tempMinParent) {
                current.setRight(null);
            } else {
                tempMinParent.setLeft(null);
            }
            if (isLeft) {
                current.setKey(keya);
                current.setValue(valuea);
            } else {
                current.setKey(keya);
                current.setValue(valuea);
            }
        }

        if (current.getLeft() == null) {
            if (isLeft) {
                currentParent.setLeft(current.getRight());
            } else {
                currentParent.setRight(current.getRight());
            }
        }
        if (current.getRight() == null) {
            if (isLeft) {
                currentParent.setLeft(current.getLeft());
            } else {
                currentParent.setRight(current.getLeft());
            }
        }

    }
    public int getMax() {
        return getMax(root);
    }

    private int getMax(BSTreeNode node) {
        //得到最大值就是得到二叉树最右边的
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node.getKey();
    }

    public void removeMin() {
        removeMin(root);
    }

    public void removeMax() {
        removeMax(root);
    }


    /**
     * 先序 中序 后序 就是打印的位置不同 其余都是一样的
     * 这几个遍历就是深度优先遍历
     * 广度优先遍历可能需要队列
     */
    public void preOrder() {
        //二分搜索树的前序遍历
        preOrder(root);
    }

    private void preOrder(BSTreeNode node) {
        //二分搜索树的前序遍历;就是先打印父节点 然后在打印子节点
        if (node != null) {
            System.out.print(node.getKey() + "," + node.getValue() + "; ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(BSTreeNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getKey() + "," + node.getValue() + "; ");
            inOrder(node.getRight());
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(BSTreeNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            inOrder(node.getRight());
            System.out.print(node.getKey() + "," + node.getValue() + "; ");
        }
    }

    public String search(int key) {
        //有一个原则就是减少暴露 根节点是没必要暴露出来的
        return search(root, key);
    }

    private String search(BSTreeNode node, int key) {
        if (node == null) {
            return null;
        }
        if (node.getKey() == key) {
            return node.getValue();
        } else if (key < node.getKey()) {
            return search(node.getLeft(), key);
        } else {
            return search(node.getRight(), key);
        }
    }

    public boolean contains(int key) {
        //递归是多么的重要!
        return contains(root, key);
    }

    private boolean contains(BSTreeNode node, int key) {
        //递归是多么的重要啊!
        if (node == null) {
            return false;
        }
        //以root为根的树中进行查找
        if (node.getKey() == key) {
            return true;
        } else if (node.getKey() > key) {
            return contains(node.getLeft(), key);
        } else {
            return contains(node.getRight(), key);
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getCount() {
        return count;
    }
    /**
     *
     */
    public void insertRec(int key, String value) {
        //以root为根节点的二叉搜索树 插入节点 (key ,value)
        //返回值是整个二叉搜索树的根
        root = insertRec(this.root, key, value);
    }

    /**
     * 这里的node 是整个搜索树的根节点
     * 返回值也是整个搜索树的根节点
     */
    private BSTreeNode insertRec(BSTreeNode node, int key, String value) {
        //搜索树的最后肯定是有空的节点
        if (node == null) {
            count++;
            return new BSTreeNode(key, value);
        }
        //如果有重复的值 直接插入
        if (node.getKey() == key) {
            node.setValue(value);
        }
        //如果小于那么就插入到左树上
        else if (key < node.getKey()) {
            BSTreeNode node1 = insertRec(node.getLeft(), key, value);
            node.setLeft(node1);
        } else {
            BSTreeNode node2 = insertRec(node.getRight(), key, value);
            node.setRight(node2);
        }
        return node;
    }

}
