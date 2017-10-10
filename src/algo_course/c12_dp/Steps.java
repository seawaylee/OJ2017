package algo_course.c12_dp;

/**
 * @author NikoBelic
 * @create 2017/8/13 16:05
 */
public class Steps
{
    public int countWays(int n)
    {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++)
        {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n - 1];
    }

    public static void main(String[] args)
    {
        int n = 100;
        System.out.println(new Steps().countWays(n));
    }
}
