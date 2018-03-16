package AlgorithmPractice.chapter6_UnionFind;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 19:04 2018/3/11
 * @Description:
 */

public class UnionFind2EnhanceRank {

    /**
     * rank指的是当前结点为根的树的深度
     *
     * 用指向的思路更能理解赋值是一个什么概念
     */

    private int[] parent;
    private int[] rank;
    private int count;

    UnionFind2EnhanceRank(int n) {
        count = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int q) {
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
        if (pRoot == qRoot) {
            return;
        }
        if (rank[qRoot] > rank[pRoot]) {
            parent[pRoot] = qRoot;
            //这种情况呢 直接把小树挪到大树上就行了
            //挪动之后树的深度最大也就是大树的深度
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            //重要的是两个树的深度相同时如何进行挪动
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
      }
}
