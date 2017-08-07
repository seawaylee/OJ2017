package algo_course.str;

/**
 * StringTranslation
 *
 * @author NikoBelic
 * @create 2017/8/6 20:56
 */
public class StringTranslation
{
    public String stringTranslation(String a, int n, int len)
    {
        String reversedStr = reverseStr(a.toCharArray());
        return reverseStr(reversedStr.substring(0, n - len).toCharArray()) + reverseStr(reversedStr.substring(n - len).toCharArray());
    }

    private String reverseStr(char[] a)
    {
        char c;
        for (int i = 0; i < a.length / 2; i++)
        {
            c = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = c;
        }
        return String.valueOf(a);
    }

    public static void main(String[] args)
    {
        StringTranslation stringTranslation = new StringTranslation();
        String s = "ABCDE";
        System.out.println(stringTranslation.stringTranslation(s, s.length(), 3));

    }
}
