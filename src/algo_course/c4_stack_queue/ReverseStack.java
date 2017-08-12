package algo_course.c4_stack_queue;

import java.util.Stack;

/**
 * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
 * <p>
 * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
 *
 * @author NikoBelic
 * @create 2017/8/9 00:10
 */
public class ReverseStack
{
    public int[] reverseStack(int[] A, int n)
    {
        if (n == 0)
            return A;
        int bottom = get(A, n);
        n--;
        reverseStack(A, n);
        A[n] = bottom;
        return A;
    }

    public int get(int[] A, int n)
    {
        int result = A[n - 1];
        n--;
        if (n == 0)
        {
            return result;
        } else
        {
            int last = get(A, n);
            A[n - 1] = result;
            return last;
        }

    }
    //private Stack<Integer> stack = new Stack<>();
    //
    //private int get(Stack<Integer> stack)
    //{
    //    int result = stack.pop();
    //    if (stack.isEmpty())
    //    {
    //        return result; // the deepest method must be return the bottom element
    //    } else
    //    {
    //        int bottom = get(stack); // get the bottom element
    //        stack.push(result); // repush the not bottom elements
    //        return bottom; // always return the bottom element step by step
    //    }
    //}
    //
    //private void reverse(Stack<Integer> stack)
    //{
    //    if (stack.isEmpty()) // stop pushing methods while the stack is empty
    //    {
    //        return;
    //    }
    //    int i = get(stack); // pop the bottom element of current stack
    //    reverse(stack); // do get(stack) recursive
    //    stack.push(i); // push the elements from top in original stack
    //}

}
