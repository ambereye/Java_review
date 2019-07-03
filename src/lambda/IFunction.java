package lambda;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/7/3
 */
public interface IFunction<R>{
    /**
     *  引用静态方法： 类名称::static 方法名称
     *  引用某个实力对象方法：实例化对象：：普通方法
     *  引用特定类型的方法：特定类：：普通方法
     *  引用构造方法：类名称：：new
     */
        // 引用静态方法
//        R change(P p);
        //引用某个实力对象方法
//        R change1();
        //引用特定类型的方法
//        int compare(P p1,P p2);
        //引用构造方法
    public R create(String s, int a);
}
