package AlgorithmPractice;

import org.junit.Test;

import java.io.PrintStream;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 17:57 2018/1/27
 * @Description:
 */

public class Other {
    public static void main(String[] args) {
        String a = "ab";
        String b = "cd";
        String c = "ab";
        System.out.println(a == c);
        String d = "abcd";
        //"ab"+"cd" 是会提前在jvm中进行初始化的
        //但是通过new创建的对象是不会再jvm常量池中进行初始化的 而且String对象是在jvm中是final的
        String e = "ab" + "cd";
        System.out.println(d == e);
    }

    /**
     * @Description: 其他的测试
     */
    @Test
    public void test1(){
        //System.out 的返回值是一个printStream
        PrintStream out = System.out;
        out.print("123");

    }
}
