package sward2offer.Chapter2.Chapter2_3_DataStructure.Q7_QueueByStack;

import java.util.Stack;

/**
 * @author NikoBelic
 * @create 21/03/2017 21:55
 */
public class Solution
{
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    public void push(int x)
    {
        stack1.push(x);
    }

    public int pop()
    {
        if (stack2.isEmpty())
        {
            while (stack1.size() > 0)
                stack2.push(stack1.pop());
        }

        if (stack2.isEmpty())
        {
            try
            {
                throw new Exception("没有数据了");
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        for (int i = 0; i < 5; i++)
        {
            solution.push(i);
        }
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
    }
}
