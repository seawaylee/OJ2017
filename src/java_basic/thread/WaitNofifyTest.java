package java_basic.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author NikoBelic
 * @create 22/03/2017 12:04
 */
public class WaitNofifyTest
{
    private static Object lock = new Object();
    private static Object anotherLock = new Object();
    private static boolean flag = true;


    public static void main(String[] args)
    {
        Thread tA = new Thread(new Wait(lock), "wait thread1");
        tA.start();
        Thread tC = new Thread(new Wait(lock), "wait thread2");
        tC.start();
        Thread tB = new Thread(new Nofify(lock), "notify thread");
        tB.start();
    }

    static class Wait implements Runnable
    {
        private Object lock;

        public Wait(Object lock)
        {
            this.lock = lock;
        }

        @Override
        public void run()
        {
            synchronized (this.lock)
            {

                while (flag)
                {
                    try
                    {
                        System.out.println("Flag is true " + Thread.currentThread().getName());
                        lock.wait();
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                System.out.println("Flag is false " + Thread.currentThread().getName());
            }
        }
    }

    static class Nofify implements Runnable
    {
        private Object lock;

        public Nofify(Object lock)
        {
            this.lock = lock;
        }

        @Override
        public void run()
        {
            synchronized (this.lock)
            {
                flag = false;
                lock.notifyAll();
                try
                {
                    TimeUnit.SECONDS.sleep(7);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

}
