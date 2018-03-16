package AlgorithmPractice.chapter6_UnionFind;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 20:02 2018/3/10
 * @Description:
 *          原来这个就叫并查集啊！！！
 *          还是给多多学习啊 争取刷完慕课网的视频啊
 */

public class UnionFind2EnhanceSize {
    /**
     *  进行优化的版本
     *  优化的范围主要是在连接时树的深度
     */
    private int[] parent;
    private int[] size;
    private int count;

    UnionFind2EnhanceSize(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
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
        //主要是树的深度的优化  应该是把小树移动到大树上 所以用数量来
        //进行衡量也不是最准确的  准确的是树的深度进行衡量!

        //而不是把大树移动到小树上!
        //这里用指向的方式更容易理解
        if (size[qRoot] > size[pRoot]) {
            //那就应该把pRoot这个小树 挪动到qRoot这个大树上
            parent[pRoot] = qRoot;
            //不要忘了更新size
            size[qRoot] += size[pRoot];
        } else {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }
}
