package nowcoder.wy_2017_spring._4_clear_repeat_element;

import java.util.*;

/**
 * 小易有一个长度为n序列，小易想移除掉里面的重复元素，但是小易想是对于每种元素保留最后出现的那个。小易遇到了困难,希望你来帮助他。
 输入描述:
 输入包括两行：
 第一行为序列长度n(1 ≤ n ≤ 50)
 第二行为n个数sequence[i](1 ≤ sequence[i] ≤ 1000)，以空格分隔


 输出描述:
 输出消除重复元素之后的序列，以空格分隔，行末无空格

 输入例子1:
 9
 100 100 100 99 99 99 100 100 100

 输出例子1:
 99 100
 * @author NikoBelic
 * @create 2017/8/12 01:52
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            numMap.put(sc.nextInt(), i);
        }
        Map<Integer, Integer> reversedMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry: numMap.entrySet())
        {
            reversedMap.put(entry.getValue(), entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
            if (reversedMap.containsKey(i))
            {
                sb.append(reversedMap.get(i)).append(" ");
            }
        }
        System.out.println(sb.substring(0,sb.length() - 1).toString());
    }
}
