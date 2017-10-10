package nowcoder.jrtt_2018.array;

import java.util.Scanner;

/**
 * 给定一个数组序列, 需要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：
 * 区间中的最小数 * 区间所有数的和
 * 最后程序输出经过计算后的最大值即可，不需要输出具体的区间。如给定序列  [6 2 1]则根据上述公式, 可得到所有可以选定各个区间的计算值:
 * [6] = 6 * 6 = 36;
 * [2] = 2 * 2 = 4;
 * [1] = 1 * 1 = 1;
 * [6,2] = 2 * 8 = 16;
 * [2,1] = 1 * 3 = 3;
 * [6, 2, 1] = 1 * 9 = 9;
 * 从上述计算可见选定区间 [6] ，计算值为 36， 则程序输出为 36。
 * 区间内的所有数字都在[0, 100]的范围内;
 * 输入
 * 第一行输入数组序列个数，第二行输入数组序列。
 * 输出
 * 输出数组经过计算后的最大值。
 * <p>
 * 样例输入
 * 3
 * 6 2 1
 * 样例输出
 * 36
 * <p>
 * Hint
 * 对于 50%的数据,  1 <= n <= 10000;
 * 对于 100%的数据, 1 <= n <= 500000;
 *
 * @author NikoBelic
 * @create 2017/8/22 19:46
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        short[] a = new short[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = sc.nextShort();
        }
        long res = Long.MIN_VALUE;
        for (int split = 1; split < n; split++)
        {
            int from = 0;
            int end = split;

            for (int type = 0; type < n - split + 1; type++)
            {
                while (end < n)
                {
                    long sum = 0;
                    long min = a[from];
                    for (int i = from; i < end; i++)
                    {
                        sum += a[i];
                        if (a[i] < min)
                        {
                            min = a[i];
                        }
                    }
                    from += 1;
                    end += 1;
                    if (sum * min > res)
                        res = sum * min;
                }

            }
        }
        System.out.println(res);


    }

}
