package algo_course.c3_str;

import java.util.Arrays;

/**
 * @author NikoBelic
 * @create 2017/8/6 23:02
 */
public class DistinctSubString
{
    public int longestSubstring(String A, int n)
    {
        char[] chas = A.toCharArray();
        int len = -1;
        int[] map = new int[255];
        int pre = -1;
        int cur = 0;

        Arrays.fill(map, -1);
        for (int i = 0; i < n; i++)
        {
            pre = Math.max(pre, map[chas[i]]);
            cur = i - pre; // ?
            len = Math.max(len, cur);
            map[chas[i]] = i;
        }
        return len;
    }

    public int l2(String A, int size)
    {
        int i, j;
        char[] str = A.toCharArray();
        int longest = 0;
        int[] visit = new int[255];

        for (i = 0; i < size; ++i)
        {
            Arrays.fill(visit, 0);
            visit[str[i]] = 1;
            for (j = i + 1; j < size; ++j)
            {
                if (visit[str[j]] == 0)
                {
                    visit[str[j]] = 1;
                } else
                {
                    if (j - i > longest)
                    {
                        longest = j - i;
                    }
                    break;
                }
            }
            if ((j == size) && (j - i > longest))
            {
                longest = j - i;
            }
        }
        return longest;
    }

    public static void main(String[] args)
    {
        DistinctSubString d = new DistinctSubString();
        //System.out.println(d.longestSubstring("ABCDA", 5));
        System.out.println(d.l2("spnvw", 5));
    }
}
