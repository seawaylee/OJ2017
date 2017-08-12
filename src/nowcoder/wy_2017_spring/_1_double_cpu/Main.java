package nowcoder.wy_2017_spring._1_double_cpu;

import java.util.*;

/**
 * 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。n个任务可以按照任意顺序放入CPU进行处理，现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。
 * 输入描述:
 * <p>
 * 输入包括两行：
 * 第一行为整数n(1 ≤ n ≤ 50)
 * 第二行为n个整数length[i](1024 ≤ length[i] ≤ 4194304)，表示每个任务的长度为length[i]kb，每个数均为1024的倍数。
 * <p>
 * <p>
 * 输出描述:
 * <p>
 * 输出一个整数，表示最少需要处理的时间
 * 示例1
 * 输入
 * <p>
 * 5
 * 3072 3072 7168 3072 1024
 * 输出
 * <p>
 * 9216
 *
 * @author NikoBelic
 * @create 2017/8/11 19:07
 */

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int[] originalArray = new int[count];
        int sum = 0;

        for (int i = 0; i < count; i++)
        {
            originalArray[i] = scanner.nextInt() >> 10;
            sum += originalArray[i];
        }
        //存放“最大价值”（每个“重量”对应的最大价值）
        int[] flag = new int[sum / 2 + 1];
        //i代表任务数量（物品数量）
        for (int i = 0; i < count; i++)
        {
            //j代表任务执行时长的一半（背包承重的最大值）
            for (int j = sum / 2; j >= originalArray[i]; j--)
            {
                //如果背包还可以承受i这个物品重量的话，那么就可以选择放置进来
                //有两种情况：
                //1：放置进来：那么flag[j]=flag[j - originalArray[i]]+originalArray[i]；
                //2. 选择不放进来，那么：flag[j]=flag[j]；
                //这两种情况该选择最大值作为flag[j]
                flag[j] = Math.max(flag[j], flag[j - originalArray[i]] + originalArray[i]);
            }
        }
        System.out.println(Math.max(flag[sum / 2], sum - flag[sum / 2]) << 10);
    }
}