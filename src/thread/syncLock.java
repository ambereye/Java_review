package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 * 同步锁
 * @author ambereye
 * @date 2019/7/28
 */
public class syncLock implements Runnable {

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            lock.lock();
            if(0>0){// 业务逻辑代码


                try{
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                    //获取当前对象名称
                String name = Thread.currentThread().getName();
                System.out.println("正在处理业务逻辑....");

            }

            lock.unlock();

        }
    }
}
