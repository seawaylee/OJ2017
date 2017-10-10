package nowcoder.wy_2018_autumn.mis_range_str;

import java.util.Scanner;

/**
 * @author NikoBelic
 * @create 2017/8/13 22:53
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.length() == 1)
        {
            System.out.println("1");
            return;
        }
        int maxLen = 1;
        int tmpLen ;
        for (int i = 0; i < s.length(); i++)
        {
            tmpLen = 1;
            for (int j = i; j < s.length() - 1; j++)
            {
                if (s.charAt(j) != s.charAt(j + 1))
                    maxLen = Math.max(maxLen, ++tmpLen);
                else
                    break;
            }

        }
        System.out.println(maxLen);
    }
}
