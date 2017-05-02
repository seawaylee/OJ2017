package interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author NikoBelic
 * @create 04/01/2017 16:21
 */
public class ThreadTest
{
    @Test
    public void testThread()
    {

    }


    static class MyThread extends Thread
    {

        private Object lock ;
        public MyThread(Object lock)
        {
            this.lock = lock;
        }

        @Override
        public void run()
        {
            synchronized (lock)
            {
                try
                {
                    for (int i = 0; i < 10; i++)
                    {
                        System.out.println(Thread.currentThread().getName() + "-----" + i);
                        Thread.sleep(1000);
                        if (i == 3)
                            lock.wait();
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }


    static class CallThread implements Callable<Integer>
    {
        private Integer end;

        public CallThread(Integer end)
        {
            this.end = end;
        }

        @Override
        public Integer call() throws Exception
        {
            int sum = 0;
            for (int i = 0; i < end; i++)
            {
                sum += i;
                Thread.sleep(1000);
            }

            return sum;
        }
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        //synchronized (MyThread.class)
        //{
            // wait后释放锁
            //Object lock = new Object();
            //MyThread t1 = new MyThread(lock);
            //MyThread t2 = new MyThread(lock);
            //t1.start();
            //t2.start();
            //synchronized (lock)
            //{
            //    lock.notifyAll();
            //}
            List<Future<Integer>> results = new ArrayList<>();
            ExecutorService threadPool = Executors.newFixedThreadPool(10);

            for (int i = 0; i < 10; i++)
            {
                results.add(threadPool.submit(new CallThread(i)));
            }
            for (Future<Integer> result : results)
            {
                System.out.println(result.get());
            }
        threadPool.shutdown();
        //}

    }
}
