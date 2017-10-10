package nowcoder.didi.ncifang;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author NikoBelic
 * @create 2017/9/23 19:38
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext())
        {
            BigDecimal r = cin.nextBigDecimal();
            int n = cin.nextInt();
            r = r.pow(n).stripTrailingZeros();
            String res = r.toPlainString();
            if (res.charAt(0) == '0')
                res = res.substring(1);
            System.out.println(res);
        }

    }
}
