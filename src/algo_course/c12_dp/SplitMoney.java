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
    /**
     * 暴力求解
     * @Author SeawayLee
     * @Date 2017/08/13 16:02
     */
    public int countWays(int[] penny, int n, int aim)
    {
        if (penny == null || penny.length == 0 || aim < 0)
        {
            return 0;
        }
        // 记忆搜索
        int[][] map = new int[penny.length + 1][aim + 1];
        return process(penny, 0, aim, map);
    }

    public int process(int[] penny, int index, int aim, int[][] map)
    {
        int res = 0;
        if (index == penny.length)
        {
            res = aim == 0 ? 1 : 0;
        } else
        {
            int mapValue = 0;
            for (int i = 0; i * penny[index] <= aim; i++)
            {
                mapValue = map[index + 1][aim - penny[index] * i];
                if (mapValue != 0)
                {
                    res += mapValue == -1 ? 0 : mapValue;
                } else
                {
                    res += process(penny, index + 1, aim - i * penny[index], map);
                }
            }
        }
        map[index][aim] = res == 0 ? -1 : res;
        return res;
    }

    /**
     * 动态规划
     * @Author SeawayLee
     * @Date 2017/08/13 16:01
     */
    public static int countWaysDynamic(int[] a, int n, int aim)
    {
        if (n == 0 || a == null)
        {
            return 0;
        }

        // 默认填充所有元素为0
        int[][] dp = new int[n][aim + 1];

        // 先填充第一行，即只用a[0]的情况下，能否构造出aim
        for (int i = 0; i < aim + 1; i++)
        {
            dp[0][i] = i % a[0] == 0 ? 1 : 0;
        }

        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < aim + 1; j++)
            {
                if (j < a[i])
                {
                    // 若剩余待填充金额小于要使用的纸币面值，则不可能成功，所以成功数量不增加
                    dp[i][j] = dp[i - 1][j];
                } else
                {
                    // dp[i][j] == dp[i-1][j] + dp[i-1][j - 1*a[i]] + dp[i-1][j - 2*[ai]] == dp[i][j - a[i]] + dp[i-1][j]
                    dp[i][j] = dp[i][j - a[i]] + dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][aim];
    }

    public static void main(String[] args)
    {
        long from = System.currentTimeMillis();
        SplitMoney sm = new SplitMoney();
        int[] penny = new int[]{1, 2, 4};
        System.out.println(sm.countWaysDynamic(penny, penny.length, 3));
        System.out.println("cost seconds: " + (System.currentTimeMillis() - from) / 1000.0);
    }
}
