package nowcoder.aiqiyi.repeeat;

import java.util.Scanner;

/**
 * @author NikoBelic
 * @create 2017/9/10 19:13
 */
public class Main
{
    public static String getRepeat(String x1, int k1)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k1; i++)
        {
            sb.append(x1);
        }
        return sb.toString();
    }

    public static void compare(String s1, String s2)
    {
        if (s1.length() != s2.length())
        {
            if (s1.length() > s2.length())
                System.out.println("Greater");
            else if (s1.length() < s2.length())
                System.out.println("Less");
            return;
        }

        for (int i = 0; i < s1.length(); i++)
        {
            if (s1.charAt(i) > s2.charAt(i))
            {
                System.out.println("Greater");
                return;
            } else if (s1.charAt(i) < s2.charAt(i))
            {
                System.out.println("Less");
                return;
            }
        }
        System.out.println("Equal");
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long x1 = sc.nextLong();
        int k1 = sc.nextInt();
        long x2 = sc.nextLong();
        int k2 = sc.nextInt();

        String s1 = getRepeat(String.valueOf(x1), k1);
        String s2 = getRepeat(String.valueOf(x2), k2);
        compare(s1,s2);
    }
}
