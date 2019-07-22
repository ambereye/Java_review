package javabaseclasslibrary;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/7/22
 */
public class SystemDemo {
    /**
     * 数组拷贝 arrarycopy
     * 获取当前的日期数值 long currentTimeMillis
     * 进行垃圾回收 static void gc
     */
    public static void main(String[] args) {
        long satrt = System.currentTimeMillis();
        Runtime run =Runtime.getRuntime() ;
        String str = "";
        for (int i = 0; i < 30000; i++) {
            //产生大量的垃圾
            str += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("操作耗时:" +(end-satrt));
        /**
         * java 只有一个gc方法
         *     public static void gc() {
         *         Runtime.getRuntime().gc();
         *     }
         */
        System.gc();

    }
}
