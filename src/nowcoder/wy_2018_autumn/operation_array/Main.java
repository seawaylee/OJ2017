package nowcoder.wy_2018_autumn.operation_array;

import java.util.*;

/**
 * 小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
 * 1、将a_i放入b序列的末尾
 * 2、逆置b序列
 * 小易需要你计算输出操作n次之后的b序列。
 * 输入描述:
 * 输入包括两行,第一行包括一个整数n(2 ≤ n ≤ 2*10^5),即序列的长度。
 * 第二行包括n个整数a_i(1 ≤ a_i ≤ 10^9),即序列a中的每个整数,以空格分割。
 * <p>
 * <p>
 * 输出描述:
 * 在一行中输出操作n次之后的b序列,以空格分割,行末无空格。
 * <p>
 * 输入例子1:
 * 4
 * 1 2 3 4
 * <p>
 * 输出例子1:
 * 4 2 1 3
 *
 * @author NikoBelic
 * @create 2017/8/13 23:00
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> q = new ArrayDeque<>();
        Stack<Integer> s = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < n; i++)
        {
            if (flag)
                q.addLast(sc.nextInt());
            else
                q.addFirst(sc.nextInt());
            flag = !flag;
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty())
        {
            if (n % 2 == 0)
                sb.append(q.pollFirst()).append(" ");
            else
                sb.append(q.pollLast()).append(" ");
        }
        System.out.println(sb.substring(0, sb.length() - 1).toString());
    }
}
