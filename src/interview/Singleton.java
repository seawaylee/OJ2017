package interview;

/**
 * @author NikoBelic
 * @create 05/01/2017 10:23
 */
public class Singleton
{
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance()
    {
        return instance;
    }
}


class SingletonLazy
{
    private static SingletonLazy instance = null;

    private SingletonLazy(){}

    public static synchronized SingletonLazy getInstance()
    {
        if (instance == null)
            instance = new SingletonLazy();
        return instance;
    }
}

class SafeSingleton
{
    volatile private static SafeSingleton instance = null;
    private SafeSingleton(){}

    public static SafeSingleton getInstance() throws InterruptedException
    {
        if (instance == null)
        {
            Thread.sleep(1000);
            synchronized (SafeSingleton.class)
            {
                if (instance == null)
                {
                    instance = new SafeSingleton();
                }
            }
        }
        return instance;
    }
}