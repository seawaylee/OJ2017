package nowcoder.wy_2017_spring._5_magic_loop;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小易拥有一个拥有魔力的手环上面有n个数字(构成一个环),当这个魔力手环每次使用魔力的时候就会发生一种奇特的变化：每个数字会变成自己跟后面一个数字的和(最后一个数字的后面一个数字是第一个),一旦某个位置的数字大于等于100就马上对100取模(比如某个位置变为103,就会自动变为3).现在给出这个魔力手环的构成，请你计算出使用k次魔力之后魔力手环的状态。
 输入描述:

 输入数据包括两行：
 第一行为两个整数n(2 ≤ n ≤ 50)和k(1 ≤ k ≤ 2000000000),以空格分隔
 第二行为魔力手环初始的n个数，以空格分隔。范围都在0至99.


 输出描述:

 输出魔力手环使用k次之后的状态，以空格分隔，行末无空格。
 示例1
 输入

 3 2
 1 2 3
 输出

 8 9 7
 * @author NikoBelic
 * @create 2017/8/12 02:05
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt();
        }

        int headLast;
        for (int i = 0; i < k; i++)
        {
            headLast = a[0];
            for (int j = 0; j < a.length; j++)
            {
                int t;
                if (j + 1 == a.length )
                    t = headLast;
                else
                    t = a[j + 1];
                a[j] = (a[j] + t) % 100;
            }
        }
        for (int i = 0; i < n; i++)
        {
            System.out.print(a[i]);
            if (i != n - 1)
                System.out.print(" ");
        }

    }
}
