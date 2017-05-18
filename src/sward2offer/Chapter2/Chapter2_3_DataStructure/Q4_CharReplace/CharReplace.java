package sward2offer.Chapter2.Chapter2_3_DataStructure.Q4_CharReplace;

/**
 * @author NikoBelic
 * @create 14/03/2017 20:35
 */
public class CharReplace
{
    public static char[] replaceSpace(char[] str,int length)
    {
        if (str == null)
            return null;

        // 计算总共有多少个空格
        int spaceCount = 0;
        for (int i = 0; i < str.length; i++)
        {
            if (str[i] == ' ')
                spaceCount++;
        }

        // 扩展字符数组长度,每个 ' ' 替换为 %20 需要额外扩展2个长度
        for (int i = 0; i < spaceCount; i++)
        {
            str = (String.valueOf(str) + "  ").toCharArray();
        }

        // 两个指针，P1指向元数组结尾，P2指向新数组结尾
        int p1 = length - 1;
        int p2 = str.length - 1;

        // 从p1向前，逐步将字符复制到p2
        while (p1 != p2)
        {
            // 如果p1为空格，则p1向前移动1位，p2向前移动三位并填充%20
            if (str[p1] == ' ')
            {
                p1--;
                str[p2--] = '0';
                str[p2--] = '2';
                str[p2--] = '%';
            }
            else
            {
                str[p2--] = str[p1--];
            }
            System.out.println(p1 + "," + p2 + "   " + String.valueOf(str));
        }
        return str;

    }

    public static void main(String[] args)
    {
        char[] str = "We are happy  ~~~".toCharArray();
        System.out.println(replaceSpace(str,str.length));
    }
}
