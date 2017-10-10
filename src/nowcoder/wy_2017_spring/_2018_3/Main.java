package nowcoder.wy_2017_spring._2018_3;

import java.util.Scanner;

/**
 * @author NikoBelic
 * @create 2017/8/12 16:15
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(recursive(n, k, 0, 1) % 1000000007);
    }

    public static int recursive(int n, int k, int count, int num)
    {
        if (n == 1)
        {
            for (int i = 1; i <= k; i++)
            {
                if (num <= i || num % i != 0)
                {
                    count += 1;
                }
            }
            return count;
        } else
        {
            for (int i = 1; i <= k; i++)
            {
                if (num <= i || num % i != 0)
                {
                    count = recursive(n - 1, k, count, i);
                }
            }
        }
        return count;
    }

}
