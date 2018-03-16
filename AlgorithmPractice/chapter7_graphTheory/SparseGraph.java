package AlgorithmPractice.chapter7_graphTheory;

import java.util.*;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 10:43 2018/3/12
 * @Description: 像这种稀疏图  都是用邻接表来实现
 *
 *    都是简单图:没有自环  也没有平行边
 */

public class SparseGraph{

    private int vCount, eCount;
    private Map<Integer, ArrayList<Integer>> edges;
    private boolean isDirected;
    private int iteratorIndex = 0;
    public SparseGraph(int vCount, boolean isDirected) {
        this.vCount = vCount;
        this.isDirected = isDirected;
        this.eCount = 0;
        edges = new HashMap<>();
        //下面就是edges的初始化；一开始都是为空的
        for (int i = 0; i < vCount; i++) {
            edges.put(i,new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        //把节点v w 连接起来
        if (v >= vCount || w >= vCount) {
            throw new IllegalArgumentException("参数范围错误");
        }
        if (hasEdge(v, w) || v == w) {
            return;
        }
        //否则就在邻接表上进行连接
        if (!isDirected) {
            edges.get(w).add(v);
        }
        edges.get(v).add(w);
        eCount++;
    }

    public boolean hasEdge(int v, int w) {
        if (v >= vCount || w >= vCount) {
            throw new IllegalArgumentException("参数范围错误");
        }
        //在这里要取消平行边  因为arrayList存放的元素可以是重复的
        return edges.get(v).contains(w);
    }
    public int getvCount() {
        return vCount;
    }

    public int geteCount() {
        return eCount;
    }

    public Map<Integer, ArrayList<Integer>> getEdges() {
        return edges;
    }

    /**
     * 得到稀疏图中所有点的相邻节点
     *
     * @return
     */
    public void getEdgesForAll() {
        for (int i = 0; i < vCount; i++) {
            ArrayList<Integer> integers = edges.get(i);
            System.out.println(i+":"+integers);
        }
        System.out.println("边数:"+eCount);
    }

    /**
     * 得到一个节点的所有相邻节点
     */
    public ArrayList<Integer> getEdgeForOne(int vIndex) {
        return edges.get(vIndex);
    }
}
