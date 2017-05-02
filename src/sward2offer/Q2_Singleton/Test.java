package sward2offer.Q2_Singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NikoBelic
 * @create 14/03/2017 15:56
 */
public class Test
{
    public static void main(String[] args)
    {

        for (int i = 0; i < 1000; i++)
        {
            new Thread(new Runnable()
            {
                @Override
                public void run() {
                    //System.out.println(InnerSingleton.getInstance());
                    System.out.println(EnumSingleton.INSTANCE);
                }
            }).start();
        }

    }
}


