package algo_course.c3_str;

/**
 * @author NikoBelic
 * @create 2017/8/6 21:15
 */
public class Prior
{
    public String findSmallest(String[] strs, int n)
    {
        String tmp;
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if ((strs[i] + strs[j]).compareTo(strs[j] + strs[i]) > 0)
                {
                    tmp = strs[i];
                    strs[i] = strs[j];
                    strs[j] = tmp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs)
        {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        Prior p = new Prior();
        System.out.println(p.findSmallest(new String[]{"gh","ab", "cd", "ef"}, 4));
    }
}
