package sward2offer.Q2_Singleton;

/**
 * @author NikoBelic
 * @create 14/03/2017 15:44
 */
public class Singleton
{
    private static Singleton instance = null;
    private static final Object LOCKOBJ = new Object();

    private Singleton(){}

    public static Singleton getInstance()
    {
        if (instance == null)
        {
            try
            {
                Thread.sleep(10);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            synchronized (LOCKOBJ)
            {
                try
                {
                    Thread.sleep(10);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                if (instance == null)
                {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
