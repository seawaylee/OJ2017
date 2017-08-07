package algo_course.course_preview;

/**
 * @author NikoBelic
 * @create 2017/8/1 00:12
 */
public class RotatingStr
{
    public static boolean chkRotation(String A, int lena, String B, int lenb)
    {
        if (lena != lenb)
        {
            return false;
        }
        String tmp = A + A;
        if (tmp.contains(B))
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        System.out.println(chkRotation("2341", 4, "1234", 4));
    }
}
