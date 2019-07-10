package functional_Interface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * TODO
 * 功能性函数式接口
 * @author ambereye
 * @date 2019/7/10
 */
public class FunctionDemo {

    /**
     * 内建的函数式接口    Function apply
     */
//    public static void main(String[] args) {
//        Function<String,Boolean> fun = "**Hello" :: startsWith ;
//        System.out.println(fun.apply("**"));
//    }

    /**
     * 消费式函数式接口  只能进行数据处理，而没有任何返回值  consumer  accept
     */
//    public static void main(String[] args) {
//        Consumer<String> consumer = System.out :: println;
//        consumer.accept("wwww");
//    }

    /**
     * 供给式函数式接口    Supplier  get
     */
//    public static void main(String[] args) {
//        Supplier<String> supplier = "wwwww2222" :: toUpperCase  ;
//        System.out.println(supplier.get());
//    }

    /**
     *   断言型函数式接口 Predicate test
     */
    public static void main(String[] args) {
        Predicate<String> pre = "wwwww2222" :: equalsIgnoreCase      ;
        System.out.println(pre.test("WWWWW2222"));
    }
}
