package AlgorithmPractice.chapter6_UnionFind;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 19:39 2018/3/10
 * @Description:
 *    UnionFind 就是并查集的意思
 */

public class UnionFind1 {
    /**
     * 并查集的QuickFind的第一种实现方式
     * 其实这种方式的查找方便 但是进行两个并会很麻烦
     * 其实数组也是一种特殊的指针
     * 存放的数量
     * 并查集的id[]
     */
    private int[] id;
    private int count;

    UnionFind1(int n) {
        id = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        //查:查找元素对应的下标
        return id[p];
    }

    public void union(int q, int p) {
        //并
        //各种的辅助代码要会！
        int qId = find(q);
        int pId = find(p);
        if (qId == pId) {
            return;
        }
        for (int i =0 ;i<count;i++) {
            if (id[i] == qId) {
                id[i] = pId;
            }
        }
    }
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

}
