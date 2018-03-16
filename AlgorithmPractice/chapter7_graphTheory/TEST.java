package AlgorithmPractice.chapter7_graphTheory;

import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 21:10 2018/3/11
 * @Description:
 */

public class TEST {


    @Test
    public void test1() {
        DenseGraph2 denseGraph2 = new DenseGraph2(10, false);
        denseGraph2.addEdge(1, 2);
        denseGraph2.addEdge(1, 3);
        denseGraph2.addEdge(1, 4);
        Map<Integer, Map<Integer, Boolean>> e = denseGraph2.getE();
        Map<Integer, Boolean> integerBooleanMap = e.get(1);
        Set<Integer> integers = integerBooleanMap.keySet();
        for (Integer integer : integers) {
            if (integerBooleanMap.get(integer) == true) {
                System.out.println(integer);
            }
        }
    }

    @Test
    public void test2(){
        SparseGraph sparseGraph = new SparseGraph(10, false);
        sparseGraph.addEdge(1, 2);
        sparseGraph.addEdge(1, 3);
        sparseGraph.addEdge(1, 4);
        sparseGraph.addEdge(2, 4);
        sparseGraph.addEdge(4, 4);
        sparseGraph.addEdge(5, 4);
      /*  System.out.println(sparseGraph.hasEdge(2, 2));
        System.out.println(sparseGraph.hasEdge(1, 1));
        System.out.println("---");
        System.out.println(sparseGraph.getEdges().get(1));
        System.out.println("---");*/
       sparseGraph.getEdgesForAll();
     //   sparseGraph.getEdgeForOne(1);

    }

    @Test
    public void test3() {
        DenseGraph denseGraph = new DenseGraph(10, false);
        denseGraph.addEdge(1, 2);
        denseGraph.addEdge(1, 3);
        denseGraph.addEdge(1, 4);
//
//        System.out.println(denseGraph.geteCount());
//        System.out.println("-------");
//        System.out.println(edges.get(1));
//        System.out.println(edges.get(2));
//        System.out.println(edges.get(8));
//        System.out.println("-------");

        //denseGraph.getEdgesForAll();
        System.out.println(denseGraph.getEdgesForOne(1));

    }

    @Test
    public void test4() throws IOException {
        DenseGraph denseGraph = (DenseGraph) InsertGraph.insert("D:\\graph2.txt","dense");
        denseGraph.getEdgesForAll();
        denseGraph.getEdgesForAll();
        System.out.println("边数:"+denseGraph.geteCount());
        System.out.println("节点数:"+denseGraph.getvCount());
    }


    @Test
    public void test5() throws IOException {
        SparseGraph sparse = (SparseGraph) InsertGraph.insert("D:\\graph1.txt", "sparse");
        sparse.getEdgesForAll();
    }
    /**
     * @Description:
     */
    @Test
    public void test6(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * @Description:
     */
    @Test
    public void test7() throws IOException {
        DenseGraph denseGraph = (DenseGraph) InsertGraph.insert("D:\\graph1.txt","dense");
        PrintGraph printGraph = new PrintGraph(denseGraph);
        printGraph.printGraph();
        System.out.println(printGraph.getConnectedComponent());
    }    /**
     * @Description:
     */
    @Test
    public void test8() throws IOException {
        int[] psss = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] s = new int[6];
        for (int i = 0; i < 6; i++) {
            s[i] = psss[i];
        }
        System.out.println(Arrays.toString(s));

    }
    @Test
    public void test9() throws IOException {
        DenseGraph denseGraph = new DenseGraph(7,false);
        denseGraph.addEdge(0, 1);
        denseGraph.addEdge(0, 2);
        denseGraph.addEdge(0, 5);
        denseGraph.addEdge(0, 6);
        denseGraph.addEdge(5, 3);
        denseGraph.addEdge(3, 4);
        denseGraph.addEdge(4, 6);
        PathGraph p = new PathGraph(denseGraph, 0);
        p.showPath(6);

    }
}
