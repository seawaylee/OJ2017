package nowcoder.xiaomi;

import java.util.Scanner;

/**
 * 现在我希望你编写一个程序，将类名按照某种规则转换为include guard所使用的宏。
 * 类名会包含namespace前缀，使用“.”作为分隔符。被分隔符分开的各个部分称之为组件，组件只会包含大小写字母和数字，且不能以数字开头。
 * 转换规则：
 * > 在开头和结尾都添加下划线；
 * > 将“.”转化为下划线；
 * > 根据下面的规则识别出组件中的单词，并使用下划线将单词进行分隔（具体参照输入输出样例）：
 * > 第一个大写字母与后面连续的小写字母一起识别为一个单词，如果不以大写字母开头，则直接将连续的小写字母识别为一个单词；
 * > 连续的大写字母一起识别为一个单词，但是如果最后一个大写字母后面跟着小写字母，则最后一个大写字母不包含在内；
 * > 连续的数字一起识别为一个单词；
 *
 * @author NikoBelic
 * @create 2017/9/18 19:18
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            String s = sc.nextLine();
            StringBuilder res = new StringBuilder();
            res.append("_");
            for (char c : s.toCharArray())
            {
                if (c == '.')
                {
                    res.append("_");
                } else if (Character.isLetter(res.charAt(res.length() - 1)) && Character.isDigit(c))
                {
                    res.append("_");
                    res.append(c);
                }else if (Character.isDigit(res.charAt(res.length() - 1)) && Character.isLetter(c))
                {
                    res.append("_");
                    res.append(c);
                }
                else if (Character.isUpperCase(c))
                {
                    // 下一个是小写 前面是大写  肯定是新单词
                    if (Character.isLowerCase(res.charAt(res.length() - 1)))
                    {
                        res.append("_");
                    }
                    res.append(c);
                } else if (Character.isLowerCase(c))
                {
                    if (Character.isUpperCase(res.charAt(res.length() - 1)))
                    {
                        char delChar = res.charAt(res.length() - 1);
                        res.deleteCharAt(res.length() - 1);
                        if (res.charAt(res.length() - 1) != '_')
                            res.append("_");
                        res.append(delChar);
                    }
                    res.append(c);
                } else
                {
                    res.append(c);
                }
            }
            res.append("_");

            System.out.println(res.toString().toUpperCase());
        }
    }
}
