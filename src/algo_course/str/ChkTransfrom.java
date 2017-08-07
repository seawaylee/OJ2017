package algo_course.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
 * <p>
 * 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
 * <p>
 * 测试样例：
 * "abc",3,"bca",3
 * 返回：true
 *
 * @author NikoBelic
 * @create 2017/8/6 18:01
 */
public class ChkTransfrom
{
    public boolean chkTransform(String a, int lenA, String b, int lenB)
    {
        if (a.equals(b))
        {
            return true;
        }
        if (lenA != lenB)
        {
            return false;
        }
        Map<Character, Integer> hashA = new HashMap<>();
        Map<Character, Integer> hashB = new HashMap<>();

        for (char c : a.toCharArray())
        {
            hashA.put(c, hashA.get(c) == null ? 1 : hashA.get(c) + 1);
        }
        for (char c : b.toCharArray())
        {
            hashB.put(c, hashB.get(c) == null ? 1 : hashB.get(c) + 1);
        }
        for (Map.Entry<Character, Integer> entry : hashA.entrySet())
        {
            if (hashB.get(entry.getKey()) == entry.getValue())
                continue;
            return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(new ChkTransfrom().chkTransform("DAQT", 4, "QDAT", 4));
    }
}
