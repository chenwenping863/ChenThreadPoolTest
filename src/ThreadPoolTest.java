import sun.rmi.runtime.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chenwenping on 17/4/13.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        /*
        * FixedThreadPool：核心固定，非核心为0
        CachedThreadPool：核心为0，非核心无限制
        ScheduledThreadPool：核心固定，非核心无限制
        SingleThreadExecutor：核心为1，非核心为0
        * */

        //==============================================
        System.out.print("\n====fixedThreadExecutor==========================================\n");
        ExecutorService fixedThreadExecutor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i ++) {
            MyRunnable myRunnable = new MyRunnable(i);
            fixedThreadExecutor.execute(myRunnable);
        }

        //==============================================
        System.out.print("\n====cachedThreadPool==========================================\n");

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i ++) {
            MyRunnable myRunnable = new MyRunnable(i);
            cachedThreadPool.execute(myRunnable);
        }

       //=================================================
        System.out.print("\n====scheduledThreadExecutor==========================================\n");

        ExecutorService scheduledThreadExecutor = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i ++) {
            MyRunnable myRunnable = new MyRunnable(i);
            scheduledThreadExecutor.execute(myRunnable);
        }

        //=================================================
        System.out.print("\n====singleThreadExecutor==========================================\n");

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i ++) {
            MyRunnable myRunnable = new MyRunnable(i);
            singleThreadExecutor.execute(myRunnable);
        }


    }


    static class MyRunnable implements Runnable {
        int threadNum;

        public MyRunnable(int threadNum) {
            this.threadNum = threadNum;
        }

        @Override
        public void run() {
            System.out.print("\n打印消息：" + "等待中。。。执行第" + threadNum + "号线程\n");
            try {
                Thread.currentThread().sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("\n打印消息：" + "完成第" + threadNum + "号线程\n");
        }
    }



}
