package nowcoder.xiaomi.code;

import java.util.Scanner;

/**
 * 我们来做一个简单的密码破译游戏。破译的规则很简单，将数字转换为字母，1转化为a，2转化为b，依此类推，26转化为z。现在输入的密码是一串数字，输出的破译结果是该数字串通过转换规则所能产生的所有字符串。
 * 输入
 * 多行数据，每行为一个数字串。
 * 输出
 * 多行数据，每行对应输出通过数字串破译得到的所有字符串，并按照字符串顺序排列，字符串之间用单个空格分隔。每行开头和结尾不允许有多余的空格。
 * <p>
 * 样例输入
 * 1
 * 12
 * 123
 * 样例输出
 * a
 * ab l
 * abc aw lc
 *
 * @author NikoBelic
 * @create 2017/9/18 20:01
 */
import java.util.*;

public class Main
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (scanner.hasNext())
        {
            String str = scanner.nextLine();
            recr(str, "", list);
            for (String s : list)
                System.out.print(s + " ");
            System.out.println("\n");
            list.clear();
        }
    }

    public static void recr(String str, String rel, List<String> list)
    {
        if (str.length() == 0)
        {
            list.add(rel);
        } else if (str.length() == 1)
        {
            String relT = rel;
            relT += String.valueOf((char) (Integer.parseInt(str) + 96));
            recr("", relT, list);
        } else
        {
            String relT1 = rel, relT2 = rel;
            String str1 = str.substring(0, 1);
            relT1 += String.valueOf((char) (Integer.parseInt(str1) + 96));
            recr(str.substring(1, str.length()), relT1, list);
            String str2 = str.substring(0, 2);
            if (Integer.parseInt(str2) <= 26)
            {
                relT2 += String.valueOf((char) (Integer.parseInt(str2) + 96));
                recr(str.substring(2, str.length()), relT2, list);
            }
        }
    }
}