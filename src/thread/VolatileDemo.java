package thread;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/7/20
 */
public class VolatileDemo implements Runnable {
    private volatile int ticket = 5;

    @Override
    public void run() {
        synchronized (this) {
            while (this.ticket > 0) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "买票处理，ticket =" + this.ticket--);
            }
        }
    }
}

class ThreadDemo1 {
    public static void main(String[] args) throws Exception {
        VolatileDemo mt = new VolatileDemo();
        new Thread(mt, "线程A").start();
        new Thread(mt, "线程B").start();
        new Thread(mt, "线程C").start();


    }
}
