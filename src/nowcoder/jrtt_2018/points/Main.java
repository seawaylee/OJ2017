package nowcoder.jrtt_2018.points;

import java.util.Scanner;

/**
 * 题目描述：
 * P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），则称其为“最大的”。求出所有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
 * 如下图：实心点为满足条件的点的集合。
 * 请实现代码找到集合 P 中的所有 ”最大“ 点的集合并输出。
 * 输入
 * 第一行输入点集的个数 N， 接下来 N 行，每行两个数字代表点的 X 轴和 Y 轴。
 * 输出
 * 输出“最大的” 点集合， 按照 X 轴从小到大的方式输出，每行两个数字分别代表点的 X 轴和 Y轴。
 * <p>
 * 样例输入
 * 5
 * 1 2
 * 5 3
 * 4 6
 * 7 5
 * 9 0
 * 样例输出
 * 输出结果按照 x 轴排序，如上例输出为：
 * 4 6
 * 7 5
 * 9 0
 * <p>
 * Hint
 * 对于 50%的数据,  1 <= n <= 10000;
 * 对于 100%的数据, 1 <= n <= 500000;
 *
 * @author NikoBelic
 * @create 2017/8/22 19:22
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int[] resX = new int[n];
        int[] resY = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++)
        {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++)
        {
            int flag = 0;
            for (int j = 0; j < n; j++)
            {
                if (x[i] < x[j] && y[i] < y[j])
                {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
            {
                resX[count] = x[i];
                resY[count] = y[i];
                count++;
            }
        }

        // SORT
        int t = 0;
        for (int i = 0; i < count; i++)
        {
            for (int j = 0; j < count - i - 1; j++)
            {
                if (resX[j] > resX[j + 1])
                {
                    t = resX[j];
                    resX[j] = resX[j + 1];
                    resX[j + 1] = t;

                    t = resY[j];
                    resY[j] = resY[j + 1];
                    resY[j + 1] = t;
                }
            }
        }

        for (int i = 0; i < count; i++)
        {
            System.out.println(resX[i] + " " + resY[i]);
        }
    }
}
