package nowcoder.wy_2018_autumn.crazy_queue;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;

/**
 * 小易老师是非常严厉的,它会要求所有学生在进入教室前都排成一列,并且他要求学生按照身高不递减的顺序排列。有一次,n个学生在列队的时候,小易老师正好去卫生间了。学生们终于有机会反击了,于是学生们决定来一次疯狂的队列,他们定义一个队列的疯狂值为每对相邻排列学生身高差的绝对值总和。由于按照身高顺序排列的队列的疯狂值是最小的,他们当然决定按照疯狂值最大的顺序来进行列队。现在给出n个学生的身高,请计算出这些学生列队的最大可能的疯狂值。小易老师回来一定会气得半死。
 * 输入描述:
 * 输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),表示学生的人数
 * 第二行为n个整数h[i](1 ≤ h[i] ≤ 1000),表示每个学生的身高
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数,表示n个学生列队可以获得的最大的疯狂值。
 * <p>
 * 如样例所示:
 * 当队列排列顺序是: 25-10-40-5-25, 身高差绝对值的总和为15+30+35+20=100。
 * 这是最大的疯狂值了。
 * <p>
 * 输入例子1:
 * 5
 * 5 10 25 40 25
 * <p>
 * 输出例子1:
 * 100
 *
 * @author NikoBelic
 * @create 2017/8/14 00:18
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int mid = n / 2;
        int left = mid - 1, right = mid + 1;
        int[] res = new int[n];
        res[mid] = a[n - 1];
        boolean flag = true;
        for (int i = 0; i < n / 2; i++)
        {
            if (left >= 0)
                res[left--] = flag ? a[i] : a[n - i - 1];
            if (right < n)
                res[right++] = flag ? a[i + 1] : a[n - i - 2];
            flag = !flag;
        }
        int diff = 0;
        for (int i = 0; i < n; i++)
        {
            System.out.print(res[i] + " ");
            if (i != n - 1)
                diff += abs(res[i] - res[i + 1]);
        }
        if ((res[n - 1] == res[n - 2] && res[0] != res[1]) || (res[0] == res[1] && res[n - 1] != res[n - 2]))
        {
            diff += Math.max(abs(res[n - 1] - res[n - 2]), abs(res[0] - res[1]));
        }
        System.out.println("");
        System.out.println(diff);
    }
}
