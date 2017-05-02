package java_basic.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author NikoBelic
 * @create 22/03/2017 12:58
 */
public class ClassAndObjectLock
{
    synchronized public static void classMethod() throws InterruptedException
    {
        System.out.println("Class Mehod is running.");
        TimeUnit.SECONDS.sleep(3);
    }
    synchronized public void objMethod() throws InterruptedException
    {
        System.out.println("Object Mehod is running.");
        TimeUnit.SECONDS.sleep(3);
    }

    public static void main(String[] args) throws InterruptedException
    {
        final ClassAndObjectLock o1 = new ClassAndObjectLock();
        final ClassAndObjectLock o2 = new ClassAndObjectLock();

        new Thread(new Runnable()
        {
            @Override
            public void run() {
                try
                {
                    ClassAndObjectLock.classMethod();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable()
        {
            @Override
            public void run() {
                try
                {
                    ClassAndObjectLock.classMethod();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
