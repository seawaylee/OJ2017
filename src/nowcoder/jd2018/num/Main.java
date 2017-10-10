package nowcoder.jd2018.num;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author NikoBelic
 * @create 2017/9/8 20:17
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int a = 1; a <= n; a++)
        {
            for (int b = 1; b <= n; b++)
            {
                for (int c = 1; c <= n; c++)
                {
                    for (int d = 1; d <= n; d++)
                    {
                        if (a == c && b == d)
                        {
                            count++;
                        } else if (Math.pow(a, b) % 1000000007 == Math.pow(c, d) % 1000000007)
                        {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(Math.pow(2, 2) == 4);
        System.out.println(count);
    }

}
