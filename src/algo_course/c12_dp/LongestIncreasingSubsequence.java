package algo_course.c12_dp;

/**
 * 这是一个经典的LIS(即最长上升子序列)问题，请设计一个尽量优的解法求出序列的最长上升子序列的长度。

 给定一个序列A及它的长度n(长度小于等于500)，请返回LIS的长度。

 测试样例：
 [1,4,2,5,3],5
 返回：3
 * @author NikoBelic
 * @create 2017/8/13 16:51
 */
public class LongestIncreasingSubsequence
{
    public int getLIS(int[] a, int n)
    {
        if (n == 0 || a == null)
            return 0;

        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++)
        {
            int temp = 0;
            for (int j = i - 1; j >= 0; j--)
            {
                if (a[i] > a[j] && dp[j] > temp)
                    temp = dp[j];
                dp[i] = temp + 1;
            }
        }
        int temp = 0;
        for (int len : dp)
        {
            if (len > temp)
            {
                temp = len;
            }
        }
        return temp;
    }

    public static void main(String[] args)
    {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.getLIS(new int[]{1, 4, 2, 5, 3}, 5));
    }
}
