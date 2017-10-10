package nowcoder.sougou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 钝角三角形个数
 * 时间限制：C/C++语言 3000MS；其他语言 5000MS
 * 内存限制：C/C++语言 30720KB；其他语言 555008KB
 * 题目描述：
 * 输入圆周上的n个点（n>=1），以角度a表示其位置(0<=a<360)，输入按a从小到大排序。求输入的点可以构成的钝角三角形个数。
 * 输入
 * 第一行为点个数n，后跟n行，每行一个双精度浮点数，表示点的角度（小数点后保留8位），例如输入样例中为4个点的输入：
 * 输出
 * 输出可以构成的钝角三角形个数和'\n'换行符。
 * <p>
 * 样例输入
 * 4
 * 0.00000000
 * 56.00000000
 * 179.00000000
 * 180.00000000
 * 样例输出
 * 2
 * <p>
 * Hint
 * 注意事项：
 * 1.我们保证输入的点不会重复，点的个数不会超过30w；
 * 2.程序性能要足够快，否则可能无法通过一些大型测试数据；
 * 3.从标准输入读取输入数据时，应尽量使用效率较高的输入方式，否则在读取一些大的输入数据时，可能会发生超时。比如c++可以考虑使用scanf代替std::cin，java可以考虑使用BufferedReader代替Scanner，Python可以使用sys.stdin系列代替input系列。
 *
 * @author NikoBelic
 * @create 2017/9/28 19:28
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] points = new double[n];
        for (int i = 0; i < n; i++)
        {
            points[i] = sc.nextDouble();
        }
        int count = 0;
        for (int i = 0; i < n - 2; i++)
        {
            for (int j = i + 1; j < n - 1; j++)
            {
                for (int k = j + 1; k < n; k++)
                {
                    double[] tp = {points[i], points[j], points[k]};
                    Arrays.sort(tp);
                    if (tp[2] - tp[0] < 180 )
                    {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
