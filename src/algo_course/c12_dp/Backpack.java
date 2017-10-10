package algo_course.c12_dp;

/**
 * 一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，也都有自己的重量，记录在数组w中，每件物品只能选择要装入背包还是不装入背包，要求在不超过背包承重的前提下，选出物品的总价值最大。
 * <p>
 * 给定物品的重量w价值v及物品数n和承重cap。请返回最大总价值。
 * <p>
 * 测试样例：
 * [1,2,3],[1,2,3],3,6
 * 返回：6
 *
 * @author NikoBelic
 * @create 2017/8/13 18:43
 */
public class Backpack
{
    public int maxValue(int[] w, int[] v, int n, int cap)
    {
        int[][] dp = new int[n][cap+1];
        for (int i = 0; i <= cap; i++)
        {
            dp[0][i] = i >= w[0] ? v[0] : 0;
        }

        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j <= cap; j++)
            {
                if (j >= w[i])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n-1][cap];
    }

    public static void main(String[] args)
    {
        Backpack bp = new Backpack();
        System.out.println(bp.maxValue(new int[]{16,36,25,19,26,23}, new int[]{619,363,582,163,487,344}, 6, 35));
    }
}
