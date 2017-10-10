package nowcoder.jd2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author NikoBelic
 * @create 2017/9/8 19:44
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String braces = sc.nextLine();
        char[] bChars = braces.toCharArray();
        List<Integer> res = new ArrayList<>();
        if (bChars.length == 1)
        {
            System.out.println("0");
            return;
        }
        // find ) after from index1
        for (int i = 1; i < bChars.length; i++)
        {
            int category = 0;
            int diff = 0;
            int latest_index = 1;
            if (bChars[i] == ')')
            {
                for (int j = i; j < bChars.length; j++)
                {
                    // del )
                    if (bChars[j] == ')')
                    {
                        bChars[j] = '-';
                        for (int k = 1; k < bChars.length; k++)
                        {
                            if (bChars[k] == '(')
                                diff--;
                            else if (bChars[k] == ')')
                                diff++;
                        }
                        if (diff == 0)
                        {
                            category++;
                        }
                        bChars[j] = ')';
                    }
                }

            }
            if (category > 0)
            {
                res.add(category);
            }
        }
        int sum = res.get(0);
        for (int i = 1; i < res.size(); i++)
        {
            sum *= res.get(i);
        }
        System.out.println(sum);
    }
}
