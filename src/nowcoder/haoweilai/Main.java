package nowcoder.haoweilai;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author NikoBelic
 * @create 2017/9/15 19:58
 */
public class Main
{
    public static void main(String[] args)
    {
        final int n = 10;
        final int[][] A = new int[n][n];
        final int[] x = new int[n];
        final int[] res = new int[n];
        ExecutorService es = Executors.newFixedThreadPool(n);
        for (int i = 0; i < n; i++)
        {
            final int finalI = i;
            es.execute(new Runnable()
            {
                @Override
                public void run()
                {
                    for (int j = 0; j < n; j++)
                    {
                        res[finalI] += x[j] * A[finalI][j];
                    }
                }
            });
        }
    }
}
