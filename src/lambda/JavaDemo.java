package lambda;

import java.util.Arrays;

/**
 * TODO
 * 方法引用
 * @author ambereye
 * @date 2019/7/3
 */
public class JavaDemo {
    /**
     *  引用静态方法： 类名称::static 方法名称
     *  引用某个实力对象方法：实例化对象：：普通方法
     *  引用特定类型的方法：特定类：：普通方法
     *  引用构造方法：类名称：：new
     */
    public static void main(String[] args) {
        //引用静态方法
//        IFunction<Integer,String> fun = String :: valueOf;
//        String str = fun.change(100);
//        System.out.println(str.length());
        //引用某个实力对象方法
//        IFunction<String> fun = "www.baidu.com"::toUpperCase;
//        System.out.println(fun.change1());
        //引用特定类型的方法
//        IFunction<String> fun = String::compareTo;
//        System.out.println(fun.compare("A","a"));
        //引用构造方法
        IFunction<Person> fun = Person::new;
        System.out.println(fun.create("张三",20));

        String[] stringArray = { "Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);
        System.out.println(stringArray.length);
    }
}
