package algo_course.c4_stack_queue;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 *
 * @author NikoBelic
 * @create 2017/8/8 21:35
 */
public class MyStack
{
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node)
    {
        dataStack.push(node);
        if (minStack.isEmpty() || node < minStack.peek())
        {
            minStack.push(node);
        } else
        {
            minStack.push(minStack.peek());
        }
    }

    public void pop()
    {
        dataStack.pop();
        if (!minStack.isEmpty())
        {
            minStack.pop();
        }
    }

    public int peek()
    {
        return dataStack.peek();
    }

    public int min()
    {
        return minStack.peek();
    }
}
