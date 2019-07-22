package javabaseclasslibrary;

/**
 * TODO
 * 描述运行时状态类,JVM之中,runtime类是唯一一个与JVM运行状态有关的类,并且会提供一个该类的实例化对象
 * @author ambereye
 * @date 2019/7/22
 */
public class RuntimeDemo {
    public static void main(String[] args) {
        // private的构造方法  单例设计模式 该类有static方法获取本类实例
        Runtime run =Runtime.getRuntime() ;
        System.out.println(run.availableProcessors());// 获取本机的cup内核数
        System.out.println("1.MAX_MEMORY--"+run.maxMemory()); //默认本机内存的4分之一
        System.out.println("2.TOTAL_MEMORY--"+run.totalMemory());//默认本机内存的64分之一
        System.out.println("3.FREE_MEMORY---"+run.freeMemory());
        String str = "";
        for (int i = 0; i < 30000; i++) {
            str += i;//产生大量的垃圾
        }
        run.gc();
        System.out.println("1.MAX_MEMORY--"+run.maxMemory()); //默认本机内存的4分之一
        System.out.println("2.TOTAL_MEMORY--"+run.totalMemory());//默认本机内存的64分之一
        System.out.println("3.FREE_MEMORY---"+run.freeMemory());


    }
    // long 用在字节 文件大小 日期时间数值//
    // 获取最大可用内存空间 private long maxMemory()
    // 获取可用内存空间 private long totalMemory()
    // 获取空闲内存空间 private long freeMemory()
    // 手工进行cg处理 private void gc()

    /**
     * gc垃圾收集器 或者手工使用runtime回收gc
     */

}
