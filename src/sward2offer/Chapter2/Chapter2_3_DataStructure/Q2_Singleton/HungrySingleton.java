package sward2offer.Chapter2.Chapter2_3_DataStructure.Q2_Singleton;

/**
 * @author NikoBelic
 * @create 14/03/2017 15:55
 */
public class HungrySingleton
{
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton()
    {
    }

    public static HungrySingleton getInstance()
    {
        return instance;
    }
}
