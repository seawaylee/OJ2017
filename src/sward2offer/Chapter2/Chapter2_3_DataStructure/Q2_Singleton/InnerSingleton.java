package sward2offer.Chapter2.Chapter2_3_DataStructure.Q2_Singleton;

/**
 * @author NikoBelic
 * @create 14/03/2017 16:12
 */
public class InnerSingleton
{
    private InnerSingleton(){}

    public static InnerSingleton getInstance()
    {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder
    {
        private static final InnerSingleton instance = new InnerSingleton();

    }
}
