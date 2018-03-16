package AlgorithmPractice.chapter6_UnionFind;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 20:02 2018/3/10
 * @Description:
 *          原来这个就叫并查集啊！！！
 *          还是给多多学习啊 争取刷完慕课网的视频啊
 */

public class UnionFind2 {
    /**
     *  使用数组指针来进行操作
     *   数组也是一个特殊的指针
     */
    private int[] parent;
    private int count;

    UnionFind2(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int q) {
        //这种情况的find方法 就是查找这个元素的根了
        while (q != parent[q]) {
            q = parent[q];
        }
        return q;
    }

    public boolean isConnected(int q, int p) {
        return find(q) == find(p);
    }

    public void connect(int q, int p) {
        //把两个节点进行合并
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot==qRoot) {
            return;
        }
        //只是对root的一种合并 也算是小小的优化了
        //把根进行合并就ok了 其实这个也不是特别的好理解
        parent[pRoot] = qRoot;
    }
}
