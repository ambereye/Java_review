package functional_Interface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    /**
     * Java8的设计者，利用泛型，定义了一整套函数式编程接口
     * Predicate 该接口通常的应用场景为过滤
     * 所谓函数式编程接口就是只能定义一个抽象方法，Predicate函数接口中定义的抽象方法为boolean test(T t)，
     * 对应的函数式行为为接收一类对象t，返回boolean类型，其可用的lambda表达式为(T t) -> boolean类型的表达式，例如(Sample a) -> a.isEmpty()。
     * <p>
     * 该接口通常的应用场景为过滤。下面的例子，要定义一个方法，从集合中进行刷选，具体的刷选逻辑（行为）由参数进行指定
     */

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        // lambda表达式赋值给一个变量
        Predicate<String> behaviorFilter = (String s) -> !s.isEmpty();
        List<String> list = new ArrayList();
        filter(list,behaviorFilter);
    }

    /**
     * 另外，为了避免java基本类型与包装类型的装箱与拆箱带来的性能损耗，
     * 还提供了如下函数式编程接口：IntPredicate、LongPredicate、DoublePredicate。
     */
}
