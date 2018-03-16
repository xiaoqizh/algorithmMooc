package AlgorithmPractice.chapter7_graphTheory;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 18:30 2018/3/14
 * @Description:
 *        图的遍历其实和树的遍历非常相似
 *        只不过是图的遍历多了一个isVisited的数组
 *        也正是因为有isVisited数组的存在 图中的每个节点才不会被第二次迭代
 */

public class PathGraph {

    private int[] isVisited;
    private DenseGraph denseGraph;
    private int vCount;
    private int[] from;
    private int source;

    public PathGraph(DenseGraph denseGraph,int source) {
        vCount = denseGraph.getvCount();
        //一开始的时候所有的节点都是未被访问过的 所以每个节点都是0
        isVisited = new int[vCount];
        from = new int[vCount];
        for (int i = 0; i < vCount; i++) {
            isVisited[i] = 0;
            from[i] = -1;
        }
        this.denseGraph = denseGraph;
        this.source = source;
        dfs(source);
    }

    private void dfs(int index) {
        //对该节点进行深度遍历
        isVisited[index] = 1;
        ArrayList<Integer> edgesForOne = denseGraph.getEdgesForOne(index);
        for (Integer next : edgesForOne) {
            if (isVisited[next] == 0) {
                from[next] = index;
                dfs(next);
            }
        }
    }

    public boolean hasPath(int dest) {
        //source 与dest 节点之间是否存在路径
        return isVisited[dest] > 0;
    }

    public void showPath(int dest) {
        //打印source 到dest的路径
        Stack<Integer> stack = new Stack<>();
        int p = from[dest];
        while (p != -1) {
            stack.push(p);
            p = from[p];
        }
        //打印路径
        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+"->");
        }
        System.out.print(dest);
    }
}
