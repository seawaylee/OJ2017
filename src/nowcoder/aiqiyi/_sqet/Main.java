package nowcoder.aiqiyi._sqet;


import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author NikoBelic
 * @create 2017/9/10 19:34
 */
public class Main
{
    public static double getSSR(int a, int b)
    {
        return Math.sqrt(a * b);

    }
    public static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        double res;
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                final int finalI = i;
                final int finalJ = j;
                es.execute(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        double res = getSSR(finalI, finalJ);
                        if (Math.abs((int) res - res) <= 0.000001)
                        {
                            count.addAndGet(1);
                        }
                    }
                });

            }
        }
        es.shutdown();
        System.out.println(count);
    }
}

