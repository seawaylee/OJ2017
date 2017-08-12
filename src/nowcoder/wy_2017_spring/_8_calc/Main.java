package nowcoder.wy_2017_spring._8_calc;

import sun.security.util.Length;

import java.util.Scanner;

/**
 * 常规的表达式求值，我们都会根据计算的优先级来计算。比如的优先级就高于+-。但是小易所生活的世界的表达式规则很简单，从左往右依次计算即可，而且小易所在的世界没有除法，意味着表达式中没有/，只有(+, - 和 *)。现在给出一个表达式，需要你帮忙计算出小易所在的世界这个表达式的值为多少
 * 输入描述:
 * 输入为一行字符串，即一个表达式。其中运算符只有-,+,*。参与计算的数字只有0~9.
 * 保证表达式都是合法的，排列规则如样例所示。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个数，即表达式的值
 * <p>
 * 输入例子1:
 * 3+5*7
 * <p>
 * 输出例子1:
 * 56
 *
 * @author NikoBelic
 * @create 2017/8/12 02:37
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] c = s.toCharArray();
        long res = 0;
        res = Integer.valueOf(String.valueOf(c[0]));
        for (int i = 1; i < c.length - 1; i += 2)
        {
            if (c[i] == '+')
                res += Integer.valueOf(String.valueOf(c[i + 1]));
            else if (c[i] == '-')
                res -= Integer.valueOf(String.valueOf(c[i + 1]));
            else if (c[i] == '*')
            {
                res *= Integer.valueOf(String.valueOf(c[i + 1]));
            }

        }
        System.out.println(res);
    }
}
