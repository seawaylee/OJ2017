package nowcoder.aiqiyi.braces;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author NikoBelic
 * @create 2017/9/10 19:26
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String bStr = sc.nextLine();
        Stack<Character> bStack = new Stack<>();
        int maxDepth = 0;
        for (Character c :bStr.toCharArray())
        {
            if (c == '(')
            {
                bStack.push(c);
                if (bStack.size() > maxDepth)
                {
                    maxDepth = bStack.size();
                }
            }
            else
                bStack.pop();
        }
        System.out.println(maxDepth);
    }
}
