package algo_course.c4_stack_queue;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * <p>
 * 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 * <p>
 * 测试样例：
 * [1,2,3,4,5]
 * 返回：[5,4,3,2,1]
 *
 * @author NikoBelic
 * @create 2017/8/9 01:22
 */
public class StackSort
{
    private Stack<Integer> helpStack = new Stack<>();

    public ArrayList<Integer> sort(int[] numbers)
    {
        Stack<Integer> stack = new Stack<>();
        for (int number : numbers)
        {
            stack.push(number);
        }
        while (!stack.isEmpty())
        {
            int x = stack.pop();
            if (helpStack.isEmpty() || helpStack.peek() > x)
            {
                helpStack.push(x);
            } else
            {
                int moveCount = 0;
                while (!helpStack.isEmpty() && helpStack.peek() < x)
                {
                    stack.push(helpStack.pop());
                    moveCount++;
                }
                helpStack.push(x);
                while (moveCount-- > 0)
                {
                    helpStack.push(stack.pop());
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!helpStack.isEmpty())
        {
            result.add(helpStack.pop());
        }
        return result;
    }

    public static void main(String[] args)
    {
        StackSort stackSort = new StackSort();
        for (Integer x : stackSort.sort(new int[]{1,3,5,2,2,7,8,1,9,7,0}))
        {
            System.out.println(x);
        }
    }

}
