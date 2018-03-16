package AlgorithmPractice.chapter7_graphTheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 20:44 2018/3/11
 * @Description: 稠密图使用邻接矩阵进行表示
 * 其实用Map这个格式就行了
 *
 *
 * 在图中 如果没有isVisited数组的话 图就会无休止的遍历下去
 */

public class DenseGraph {

    /**
     * 使用arrayList实现图的结构
     * arrayList 可以直接用下标
     */
    private int vCount, eCount;
    private boolean isDirected;
    /**
     * 0 是没有边
     * 1 是有边
     */
    private int[][] edges;

    public DenseGraph(int vCount, boolean isDirected) {
        this.vCount = vCount;
        this.eCount = 0;
        this.isDirected = isDirected;
        edges = new int[vCount][vCount];
        for (int i = 0; i < vCount; i++) {
            for (int j = 0; j < vCount; j++) {
                edges[i][j] = 0;
            }
        }
    }

    public void addEdge(int v, int w) {
        if (v >= vCount || w > vCount) {
            throw new IllegalArgumentException("参数范围错误");
        }
        if ( hasEdge(v, w)) {
            return;
        }
        //无向图
        if (!isDirected ) {
            edges[v][w] = 1;
        }
        edges[w][v] = 1;
        eCount++;
    }

    public boolean hasEdge(int v, int w) {
        if (v >= vCount || w > vCount) {
            throw new IllegalArgumentException("参数范围错误");
        }
        return edges[v][w] > 0;
    }

    public int getvCount() {
        return vCount;
    }

    public int geteCount() {
        return eCount;
    }

    public int[][] getEdges() {
        return edges;
    }

    public void getEdgesForAll() {
        //得到所有节点的所有临边
        for (int i = 0; i < vCount; i++) {
            int[] edge = edges[i];
            System.out.print(i+":");
            for (int j = 0; j < vCount; j++) {
                if (edge[j] >0 ) {
                    System.out.print(j+" ");
                }
            }
            System.out.println("");
        }
    }
    public ArrayList<Integer> getEdgesForOne(int index) {
        int[] edge = edges[index];
        ArrayList<Integer> aux = new ArrayList<>();
        for (int j = 0; j < vCount; j++) {
            if (edge[j] > 0) {
                aux.add(j);
            }
        }
        return aux;
    }
}
