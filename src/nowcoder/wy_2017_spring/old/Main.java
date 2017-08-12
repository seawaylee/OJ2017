package nowcoder.wy_2017_spring.old;

import java.util.*;

/**
 * 小易有一个长度为n序列，小易想移除掉里面的重复元素，但是小易想是对于每种元素保留最后出现的那个。小易遇到了困难,希望你来帮助他。
 输入描述:
 输入包括两行：
 第一行为序列长度n(1 ≤ n ≤ 50)
 第二行为n个数sequence[i](1 ≤ sequence[i] ≤ 1000)，以空格分隔


 输出描述:
 输出消除重复元素之后的序列，以空格分隔，行末无空格

 输入例子:
 9
 100 100 100 99 99 99 100 100 100

 输出例子:
 99 100
 * @author NikoBelic
 * @create 2017/4/17 18:07
 */
public class Main
{
    public void soltion()
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String t;
        Map<String, Node> seqMap = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            t = String.valueOf(in.nextInt());
            if (seqMap.containsKey(t)) seqMap.put(t, new Node(i, seqMap.get(t).getCount() + 1));
            else
            {
                seqMap.put(t, new Node(i,1));
            }
        }

        Node[] nodes = (Node[]) seqMap.values().toArray();
        for (Node node : nodes)
        {
            System.out.println(node);
        }

    }
    public static void main(String[] args)
    {
        new Main().soltion();
    }
}

class Node implements Comparator<Node>
{
    int index;
    int count;

    public Node(int index, int count)
    {
        this.index = index;
        this.count = count;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    @Override
    public int compare(Node o1, Node o2)
    {
        return o1.getCount() - o2.getCount();
    }

    @Override
    public String toString()
    {
        return "Node{" + "index=" + index + ", count=" + count + '}';
    }
}
