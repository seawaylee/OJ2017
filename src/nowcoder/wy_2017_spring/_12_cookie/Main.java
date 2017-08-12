package nowcoder.wy_2017_spring._12_cookie;

import java.util.Scanner;

/**
 * @author NikoBelic
 * @create 2017/8/12 03:35
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String k = sc.nextLine();
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < 10; i++)
        {
            long m = Long.valueOf(k.replace("X", String.valueOf(i)));
            if (m % n == 0)
            {
                count++;
            }
        }
        System.out.println(count);
    }
}
