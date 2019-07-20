package thread;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/7/20
 */
public class ProtectThreadDemo {
    public static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread userThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在运行,进程号-" + i);
            }
        }, "用户线程");
        Thread daemonThread = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在运行,进程号-" + i);
            }
        }, "守护线程");
        daemonThread.setDaemon(true);//设置守护线程
        userThread.start();
        daemonThread.start();
    }
}
