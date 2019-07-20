package thread;

/**
 * TODO
 * 线程的数字加减
 *
 * @author ambereye
 * @date 2019/7/20
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        Resource resource = new Resource();
        AddThread at = new AddThread(resource);
        SubThread st = new SubThread(resource);
        new Thread(at, "加法线程 -A").start();
        new Thread(st, "加法线程 -X").start();
        new Thread(at, "加法线程 -B").start();
        new Thread(st, "加法线程 -Y").start();
    }

}

// 加法线程
class AddThread implements Runnable {
    private Resource resource;

    public AddThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.resource.add();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

// 减法线程'
class SubThread implements Runnable {
    private Resource resource;

    public SubThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.resource.sub();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

//资源
class Resource {
    private int num = 0;
    /**
     * 加减切换 flag = true 表示加法操作，但无法进行减法操作 flag = false 可以减法无法加法
     */
    private boolean flag = true;

    public synchronized void add() throws Exception {
        if (this.flag == false) { //现在需要执行的是减法操作,加法操作等待
            super.wait();
        }
//        Thread.sleep(100);
        this.num++;
        System.out.println("【加法操作 -" + Thread.currentThread().getName() + "】num =" + this.num);
        this.flag = false;//加法操作执行完毕,需要执行减法操作
        super.notifyAll();//唤醒全部等待线程
    }

    public synchronized void sub() throws Exception {
        if (this.flag == true) { //现在需要执行的是加法操作,减法操作等待
            super.wait();
        }
//        Thread.sleep(200);
        this.num--;
        System.out.println("【加法操作 -" + Thread.currentThread().getName() + "】num =" + this.num);
        this.flag = true;//减法操作执行完毕,需要执行加法操作
        super.notifyAll();//唤醒全部等待线程
    }
}

