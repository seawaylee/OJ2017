package nowcoder.meituan.recur;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author NikoBelic
 * @create 2017/9/14 21:31
 */
public class Main
{
    public static void main(String[] args)
    {
        //upper(1);
        decr(16);
    }

    public static void upper(int n)
    {
        if (n <= 10)
        {
            System.out.println(n);
            upper(2 * n);
        } else
        {
            System.out.println(n);
        }

    }

    public static void decr(int n)
    {
        if (n > 1)
        {
            System.out.println(n);
            decr(n / 2);
        }
        else
        {
            System.out.println("1");
        }
    }
}
