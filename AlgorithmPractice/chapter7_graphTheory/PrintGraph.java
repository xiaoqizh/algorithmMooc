package AlgorithmPractice.chapter7_graphTheory;

import java.util.ArrayList;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 18:30 2018/3/14
 * @Description:
 *        图的遍历其实和树的遍历非常相似
 *        只不过是图的遍历多了一个isVisited的数组
 */

public class PrintGraph {
    /**
     * 访问过 1
     * 未被访问过 0
     * connectedComponent:连通分量的意思
     */
    private int[] isVisited;
    private DenseGraph denseGraph;
    private int vCount;
    private int connectedComponent =0;
    /**
     * parents数组是一个并查集 其的根就是连通分量
     * 普通的并查集是数组形式的   图的并查集的根就是其中一个连通分量
     */
    private int[] parents;

    public PrintGraph(DenseGraph denseGraph) {
        vCount = denseGraph.getvCount();
        //一开始的时候所有的节点都是未被访问过的 所以每个节点都是0
        isVisited = new int[vCount];
        parents = new int[vCount];
        for (int i = 0; i < vCount; i++) {
            isVisited[i] = 0;
        }
        this.denseGraph = denseGraph;
    }

    public void printGraph() {
        //首先就是对所有的节点进行遍历
        for (int i = 0; i < vCount; i++) {
            //如果没有被访问过
            if (isVisited[i] == 0) {
                dfs(i);
                connectedComponent++;
            }
        }
    }

    private void dfs(int index) {
        parents[connectedComponent] = 0;
        //对该节点进行深度遍历
        isVisited[index] = 1;
        ArrayList<Integer> edgesForOne = denseGraph.getEdgesForOne(index);
        for (Integer next : edgesForOne) {
            if (isVisited[next] == 0) {
                dfs(next);
            }
        }
    }

    public int getConnectedComponent() {
        return connectedComponent;
    }
}
