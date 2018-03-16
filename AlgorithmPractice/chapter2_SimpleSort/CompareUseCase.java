package AlgorithmPractice.chapter2_SimpleSort;

/**
 * @Author: xiaoqiZh
 * @Date: Created in 21:40 2018/1/22
 * @Description:
 */

public class CompareUseCase implements Comparable<CompareUseCase> {

    private String name;
    private int age;

    public CompareUseCase(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(CompareUseCase o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "CompareUseCase{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
