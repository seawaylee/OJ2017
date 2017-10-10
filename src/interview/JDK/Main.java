package interview.JDK;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author NikoBelic
 * @create 2017/9/20 22:29
 */
public class Main
{
    public static void main(String[] args)
    {
        Set s = new HashSet();
        List l = new ArrayList();
        PriorityBlockingQueue p = new PriorityBlockingQueue();
        p.add(3);
        p.add(1);
        p.add(4);
        p.add(2);
        while (!p.isEmpty())
        {
            System.out.println(p.remove());
        }
    }
}
