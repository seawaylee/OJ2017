package algo_course.str;

/**
 * @author NikoBelic
 * @create 2017/8/6 22:10
 */
public class Replacement
{
    public String repalceSpace(String iniString, int length)
    {
        if (iniString == null || iniString.equals(""))
            return "";
        int spaceCount = iniString.split(" ").length - 1;
        char[] initChars = iniString.toCharArray();
        char[] resChars = new char[iniString.length() + spaceCount * 2];
        int j = resChars.length - 1;
        for (int i = length - 1; i >= 0; i--)
        {
            if (initChars[i] != ' ')
            {
                resChars[j--] = initChars[i];
            } else
            {
                resChars[j--] = '0';
                resChars[j--] = '2';
                resChars[j--] = '%';
            }
        }
        return String.valueOf(resChars);
    }

    public static void main(String[] args)
    {
        Replacement r = new Replacement();
        String s = "Niko Belic Is A Good Boy";
        System.out.println(r.repalceSpace(s, s.length()));
    }
}
