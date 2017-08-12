package algo_course.c3_str;

/**
 * @author NikoBelic
 * @create 2017/8/6 22:54
 */
public class chkParenthesis
{
    public boolean chkParenthesis(String a, int n)
    {
        int num = 0;
        for (char c : a.toCharArray())
        {
            if (c == '(')
            {
                num++;
            } else
            {
                num--;
            }
            if (num < 0)
            {
                return false;
            }
        }
        if (num == 0)
            return true;
        return false;
    }
}
