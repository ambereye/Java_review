package designPatterns;

/**
 * TODO
 * 单例设计模式特点 构造方法私有化 内部类提供static方法获取实例化对象
 * @author ambereye
 * @date 2019/7/1
 */
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {}// 构造方法私有化

    public static Singleton getInstance() {
        return INSTANCE;
    }

    public void print() {
        System.out.println("饿汉式，单例设计模式");
    }

    private static Singleton instance;

    public static Singleton getINSTANCE() {
        if (instance == null) {//第一次使用
            instance = new Singleton();// 实例化对象
        }
        return INSTANCE;
    }

    public void print1() {
        System.out.println("懒汉式，单例设计模式"); // 需要考虑到线程同步问题
    }
}
