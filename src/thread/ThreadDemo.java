package thread;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/7/11
 */
class MyThread implements Runnable {//线程主体类
    private String title;

    public MyThread(String title) {
        this.title = title;
    }

    @Override
    public void run() {// 线程主体方法  多线程执行的功能呢要在run方法内定义
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + "运行,x=" + i);
        }
    }
}

public class ThreadDemo {
//    public static void main(String[] args) {
//        new MyThread("线程A").start();
//        new MyThread("线程B").start();
//        new MyThread("线程C").start();
//
//    }

    /**
     * if (threadStatus != 0)
     *             throw new IllegalThreadStateException();
     *
     *    group.add(this);
     *
     *         boolean started = false;
     *         try {
     *             start0();
     *             started = true;
     *         } finally {
     *             try {
     *                 if (!started) {
     *                     group.threadStartFailed(this);
     *                 }
     *             } catch (Throwable ignore) {
     *
     *                         }
     *         }
     *     }
     */

    // 可以用runable实现
    public static void main(String[] args) {
        Thread threadA = new Thread(new MyThread("线程A"));
        Thread threadB = new Thread(new MyThread("线程B"));
        Thread threadC = new Thread(new MyThread("线程C"));
        threadA.start();
        threadB.start();
        threadC.start();

    }


}

