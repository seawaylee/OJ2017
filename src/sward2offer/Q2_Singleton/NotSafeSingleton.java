package sward2offer.Q2_Singleton;

/**
 * @author NikoBelic
 * @create 14/03/2017 16:00
 */
public class NotSafeSingleton
{
    private static NotSafeSingleton instance = null;

    private NotSafeSingleton(){}

    public static NotSafeSingleton getInstance()
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
            instance = new NotSafeSingleton();

        }
        return instance;
    }
}
