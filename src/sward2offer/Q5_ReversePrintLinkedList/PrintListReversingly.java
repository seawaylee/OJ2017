package sward2offer.Q5_ReversePrintLinkedList;

import sward2offer.model.SimpleLinkedList;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author NikoBelic
 * @create 15/03/2017 21:16
 */
public class PrintListReversingly
{
    /**
     * 递归实现
     * @Author NikoBelic
     * @Date 15/03/2017 21:25
     */
    private static void printReversingly(SimpleLinkedList head)
    {
        if (head == null)
            return;

        if (head.next != null)
            printReversingly(head.next);

        System.out.print(head.val + " ");

    }

    /**
     * 栈或队列实现
     * @Author NikoBelic
     * @Date 15/03/2017 21:28
     */
    private static void printByQueue(SimpleLinkedList head)
    {
        Deque queue = new LinkedBlockingDeque();
        while (head != null)
        {
            queue.addFirst(head.val);
            head = head.next;
        }

        while (queue.size() > 0)
        {
            System.out.print(queue.pop() + " ");
        }
    }

    public static void main(String[] args)
    {
        SimpleLinkedList head = new SimpleLinkedList(0, null);
        SimpleLinkedList p;
        p = head;
        for (int i = 1; i <= 10; i++)
        {
            p.next = new SimpleLinkedList(i, null);
            p = p.next;
            System.out.print(i + " ");
        }
        System.out.println("\n递归逆序输出结果");
        printReversingly(head.next);
        System.out.println("\n栈逆序输出结果");
        printByQueue(head.next);
    }
}


