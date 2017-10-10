package nowcoder.xiaomi.path;

import java.util.*;

/**
 * 假如有一个HTTP Server，可以对不同的路径（Path）注册不同的处理函数（Handler）。路径的格式为/x/y/z，使用“/”作为分隔符，被分隔开的每个组件都是只包含字母的非空字符串；路径总是以“/”开头，且不以“/”结尾，也不会出现“/x//y”这样的情况。为了简化问题，我们将处理函数用整数的ID号表示。
 * 对于客户端的HTTP请求，我们需要根据路径匹配最合适的处理函数。匹配规则是：在所有已经注册的路径中，找到包含该路径的最长前缀。前缀要求对组件的匹配是完整的，因此“/a/b”是“/a/b/c”的前缀，但不是“/a/bc”的前缀。
 * 输入
 * 输入分两部分：
 * 第一部分是注册的路径列表，每行两个元素，用空格分开，分别为路径和ID号；ID号为非0整数，且不会重复。
 * 第二部分是需要匹配的路径列表，每行一个路径。
 * 两个部分用只包含一个短横线的特殊行分隔。
 * 输出
 * 对于每个需要匹配的路径，输出其匹配的ID号，每行一个；如果没有找到匹配路径，则输出0。
 * <p>
 * 样例输入
 * /a 1
 * /a/b 2
 * /a/b/c/d/e/f/g/h/i 3
 * /a/bcde 4
 * -
 * /a
 * /a/b
 * /a/b/c/d
 * /a/b/c/d/e/f/g/h/i
 * /a/bcde
 * /a/bcdefghi
 * /b
 * 样例输出
 * 1
 * 2
 * 2
 * 3
 * 4
 * 1
 * 0
 *
 * @Author SeawayLee
 * @Date 2017/09/18 19:59
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        List<List<String>> arrList1 = new ArrayList();
        List<String> arrList2 = new ArrayList<>();
        int mark = 0;
        while (scanner.hasNext())
        {
            String str = scanner.nextLine();
            if (str.equals("-"))
            {
                mark = 1;
                continue;
            }
            if (mark == 0)
            {
                String[] strs = str.split(" ");
                String[] strsPath = strs[0].split("/");
                arrList2.add(strs[1]);
                List<String> arrList = new ArrayList<>();
                for (int i = 1; i < strsPath.length; i++)
                    arrList.add(strsPath[i]);
                arrList1.add(arrList);
            } else
            {
                String[] strsPath = str.split("/");
                List<String> arrList = new ArrayList<>();
                for (int i = 1; i < strsPath.length; i++)
                    arrList.add(strsPath[i]);
                System.out.println(fun(arrList, arrList1, arrList2));
            }
        }
    }

    public static String fun(List<String> arrList, List<List<String>> arrList1, List<String> arrList2)
    {
        String rel = "0";
        int max = 0;
        for (int i = 0; i < arrList1.size(); i++)
            if (arrList.containsAll(arrList1.get(i)))
            {
                if (max < arrList1.get(i).size())
                {
                    rel = arrList2.get(i);
                }
            }
        return rel;
    }

}