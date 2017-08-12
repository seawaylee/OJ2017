package algo_course.c4_stack_queue;

import java.util.*;

/**
 * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 * <p>
 * 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 * <p>
 * 测试样例：
 * [1,2,3,0,4,0],6
 * 返回：[1,2]
 *
 * @author NikoBelic
 * @create 2017/8/8 21:51
 */
public class TwoStackMakeQueue
{
    Stack<Integer> fromStack = new Stack<>();
    Stack<Integer> toStack = new Stack<>();

    /**
     * 最先想到的解法，每次push/pop操作都保证另外一个栈为空
     *
     * @Author SeawayLee
     * @Date 2017/08/08 22:49
     */
    public int[] twoStack(int[] ope, int n)
    {
        int[] popList = new int[n];
        int popCounter = 0;
        for (int operation : ope)
        {
            if (operation != 0)
            {
                while (!toStack.isEmpty())
                {
                    fromStack.push(toStack.pop());
                }
                fromStack.push(operation);
            } else
            {
                while (!fromStack.isEmpty())
                {
                    toStack.push(fromStack.pop());
                }
                popList[popCounter++] = toStack.pop();
            }
        }

        return Arrays.copyOfRange(popList, 0, popCounter);
    }

    /**
     * 时间复杂度更低的解法
     *
     * @Author SeawayLee
     * @Date 2017/08/08 22:50
     */
    public int[] twoStack2(int[] ope, int n)
    {
        int popCounter = 0;
        for (int o : ope)
        {
            if (o != 0)
            {
                fromStack.push(o);
            } else
            {
                popCounter++;
            }
        }
        int[] popList = new int[popCounter];
        while (!fromStack.isEmpty())
        {
            toStack.push(fromStack.pop());
        }
        int i = 0;
        while (popCounter-- > 0)
        {
            popList[i++] = toStack.pop();
        }
        return popList;
    }

    public static void main(String[] args)
    {
        TwoStackMakeQueue t = new TwoStackMakeQueue();
        int[] array = new int[]{1, 2, 3, 0, 4, 5, 6, 0, 0, 0};
        for (int x : t.twoStack2(array, array.length))
        {
            System.out.println(x + " ");
        }
    }

}
