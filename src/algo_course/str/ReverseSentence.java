package algo_course.str;

/**
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
 * <p>
 * 给定一个原字符串A和他的长度，请返回逆序后的字符串。
 * <p>
 * 测试样例：
 * "dog loves pig",13
 * 返回："pig loves dog"
 *
 * @author NikoBelic
 * @create 2017/8/6 20:44
 */
public class ReverseSentence
{
    public String reverseSentence(String a, int n)
    {
        String reversedStr = reverseChars(a.toCharArray());
        String reversedWords = "";
        for (String word : reversedStr.split(" "))
        {
            reversedWords += reverseChars(word.toCharArray());
            reversedWords += " ";
        }
        if (reversedWords.length() > 1)
        {
            return reversedWords.substring(0, reversedWords.length() - 1);
        }
        return reversedWords;
    }

    private String reverseChars(char[] chars)
    {
        char c;
        for (int i = 0; i < chars.length / 2; i++)
        {
            c = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = c;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args)
    {
        ReverseSentence reverseSentence = new ReverseSentence();
        String s = "Niko Belic Is A Good Boy.";
        System.out.println(reverseSentence.reverseSentence(s, s.length()));
    }
}
