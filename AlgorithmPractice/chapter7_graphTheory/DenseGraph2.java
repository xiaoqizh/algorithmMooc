package AlgorithmPractice.chapter7_graphTheory;

import edu.princeton.cs.algs4.Edge;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 20:44 2018/3/11
 * @Description:
 *      稠密图使用邻接矩阵进行表示
 *         其实用Map这个格式就行了
 */

public class DenseGraph2 {

    /**
     * 确实是否是有向图 或者是无向图
     * vCount : 图的顶点
     * eCount : 边的数量
     * e :图的边的邻接矩阵表示
     *
     *  有向图 无向图
     *  大多讨论的都是简单图:没有自环 没有平行边
     *
     */
    private int vCount,eCount;
    private Map<Integer,Map<Integer,Boolean>> e;
    private boolean isDirected;

    public DenseGraph2(int vCount, boolean isDirected) {
        this.vCount = vCount;
        this.eCount = 0 ;
        this.isDirected = isDirected;
        e = new HashMap<>();
        //初始化map 使之起始值为false 一定要进行初始化才ok
        Map<Integer, Boolean> temp = new HashMap<>();
        for (int i =0 ;i<vCount;i++) {
            temp.put(i, false);
        }
        //初始化所有的边 一开始均为false  一开始的边都是不连通的
        for (int i = 0; i < vCount; i++) {
            e.put(i, temp);
        }
    }

    public void addEdge(int v, int w) {
        // v节点 和w节点 进行连接操作;取消闭环 与平行边
        if (v >= vCount || w >= vCount) {
            throw new IllegalArgumentException("传递参数错误");
        }
        if (v == w || hasEdge(v, w)) {
            return;
        }
        if (!isDirected) {
            //无向图
            Map<Integer, Boolean> integerBooleanMap = e.get(w);
            integerBooleanMap.put(v, true);
        }
        //其实现在还没有考虑自环的情况  就是v = w
        System.out.println("123");
        e.get(v).put(w, true);
        //e.get(v).put(v, false);
        //e.get(w).put(w, false);
        eCount++;
    }

    public boolean hasEdge(int v, int w) {
        if (v >= vCount || w >= vCount) {
            throw new IllegalArgumentException("传递参数错误");
        }
        return e.get(v).get(w);
    }
    public int getvCount() {
        return vCount;
    }

    public int geteCount() {
        return eCount;
    }

    public Map<Integer, Map<Integer, Boolean>> getE() {
        return e;
    }
}
