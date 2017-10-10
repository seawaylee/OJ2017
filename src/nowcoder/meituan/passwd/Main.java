package nowcoder.meituan.passwd;

import java.util.Scanner;

/**
 * @author NikoBelic
 * @create 2017/9/14 20:13
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
        {
            String passwd = sc.next();
            if (check(passwd))
            {
                System.out.println("YES");
            } else
            {
                System.out.println("NO");
            }
        }
    }

    public static boolean check(String passwd)
    {
        if (passwd.length() < 8)
            return false;
        boolean lower = false;
        boolean upper = false;
        boolean digital = false;
        char[] passwdArray = passwd.toCharArray();
        if (Character.isDigit(passwdArray[0]))
        {
            return false;
        }
        for (char c : passwdArray)
        {
            if (Character.isDigit(c))
            {
                digital = true;
            } else if (Character.isLowerCase(c))
            {
                lower = true;
            } else if (Character.isUpperCase(c))
            {
                upper = true;
            } else
                return false;
        }
        if (digital && lower || digital && upper || lower && upper)
            return true;
        return false;
    }
}
