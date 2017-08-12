package nowcoder.wy_2017_spring._9_paint;

import java.util.Scanner;

/**
 * 小易有一块n*n的棋盘，棋盘的每一个格子都为黑色或者白色，小易现在要用他喜欢的红色去涂画棋盘。小易会找出棋盘中某一列中拥有相同颜色的最大的区域去涂画，帮助小易算算他会涂画多少个棋格。
 * 输入描述:
 * 输入数据包括n+1行：
 * <p>
 * 第一行为一个整数n(1 ≤ n ≤ 50),即棋盘的大小
 * <p>
 * 接下来的n行每行一个字符串表示第i行棋盘的颜色，'W'表示白色，'B'表示黑色
 * <p>
 * <p>
 * 输出描述:
 * 输出小易会涂画的区域大小
 * <p>
 * 输入例子1:
 * 3
 * BWW
 * BBB
 * BWB
 * <p>
 * 输出例子1:
 * 3
 *
 * @author NikoBelic
 * @create 2017/8/12 02:59
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] lines = new String[n];
        for (int i = 0; i < n; i++)
        {
            lines[i] = sc.next();
        }

        int maxCount = 0;
        for (int j = 0; j < n; j++)
        {
            int c = 1;
            for (int i = 0; i < n - 1; i++)
            {
                if (lines[i].charAt(j) == lines[i+1].charAt(j))
                {
                    c++;
                    maxCount = Math.max(maxCount, c);
                }
                else
                {
                    c = 1;
                }
            }
        }
        System.out.println(maxCount);
    }
}
