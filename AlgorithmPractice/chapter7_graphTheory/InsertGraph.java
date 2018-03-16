package AlgorithmPractice.chapter7_graphTheory;

import org.junit.Test;

import java.io.*;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 20:18 2018/3/13
 * @Description:
 */

public class InsertGraph {
    /**
     * 读取文件 根据文件的内容创建一个Graph 数据结构
     */
    private static final String DENSE = "dense";
    private static final String SPARSE = "sparse";
    private static DenseGraph denseGraph;
    private static SparseGraph sparseGraph;

    public static Object insert(String filename,String graphType) throws IOException {
        File file = new File(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(file),"utf-8"));
        String s = reader.readLine();
        if (DENSE.equals(graphType)) {
            //下面一行是构造函数
            if (s != null) {
                String[] strings = s.split(" ");
                int var1 = Integer.valueOf(strings[0]);
                denseGraph = new DenseGraph(var1, false);
            }
            //接下来就是添加边
            while ((s = reader.readLine()) != null) {
                String[] strings = s.split(" ");
                denseGraph.addEdge(Integer.valueOf(strings[0]),
                        Integer.valueOf(strings[1]));
            }
            return denseGraph;
        } else if (SPARSE.equals(graphType)){
            if (s != null) {
                String[] strings = s.split(" ");
                int var1 = Integer.valueOf(strings[0]);
                sparseGraph = new SparseGraph(var1, false);
            }
            //接下来就是添加边
            while ((s = reader.readLine()) != null) {
                String[] strings = s.split(" ");
                int var1 = Integer.valueOf(strings[0]);
                int var2 = Integer.valueOf(strings[1]);
                sparseGraph.addEdge(var1, var2);
            }
            return sparseGraph;
        }
        throw new IllegalArgumentException("参数传递错误");
    }
}
