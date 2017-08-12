package algo_course.c12_dp;

/**
 * 有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 * <p>
 * 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
 * <p>
 * 测试样例：
 * [1,2,4],3,3
 * 返回：2
 *
 * @author NikoBelic
 * @create 2017/8/11 23:11
 */
public class SplitMoney
{
    public int countWays(int[] penny, int n, int aim)
    {
        if (penny == null || penny.length == 0 || aim < 0)
        {
            return 0;
        }
        return process(penny, 0, aim);
    }

    public int process(int[] penny, int index, int aim)
    {
        int res = 0;
        if (index == penny.length)
        {
            res = aim == 0 ? 1 : 0;
        } else
        {
            for (int i = 0; i * penny[index] <= aim; i++)
            {
                res += process(penny, index + 1, aim - i * penny[index]);
            }
        }
        return res;
    }
    public static void main(String[] args)
    {
        SplitMoney sm = new SplitMoney();
        int[] penny = new int[]{1, 2, 4};
        System.out.println(sm.countWays(penny, penny.length, 3));
    }
}
