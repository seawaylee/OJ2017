package nowcoder.wy_2017_spring._2018_1;

import java.util.Scanner;

/**
 * @author NikoBelic
 * @create 2017/8/12 15:31
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int f = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();
        int a = 0;
        if (d / x < f)
        {
            System.out.println(d / x);
            return;
        } else
        {
            a = (d - (x * f)) / (p + x);
        }
        System.out.println(a + f);
    }
}