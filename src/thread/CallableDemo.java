package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * TODO
 *  有返回的线程
 * @author ambereye
 * @date 2019/7/18
 */

class MyThread1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("run"+i);
        }
        return "close";
    }

}
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new MyThread1());
        new Thread(task).start();
        System.out.println("得到返回结果"+task.get());
    }
}
