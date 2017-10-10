package nowcoder.jrtt_2018.pm;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 产品经理(PM)有很多好的idea，而这些idea需要程序员实现。现在有N个PM，在某个时间会想出一个 idea，每个 idea 有提出时间、所需时间和优先等级。对于一个PM来说，最想实现的idea首先考虑优先等级高的，相同的情况下优先所需时间最小的，还相同的情况下选择最早想出的，没有 PM 会在同一时刻提出两个 idea。
 * 同时有M个程序员，每个程序员空闲的时候就会查看每个PM尚未执行并且最想完成的一个idea,然后从中挑选出所需时间最小的一个idea独立实现，如果所需时间相同则选择PM序号最小的。直到完成了idea才会重复上述操作。如果有多个同时处于空闲状态的程序员，那么他们会依次进行查看idea的操作。
 * 求每个idea实现的时间。
 * 输入
 * 输入第一行三个数N、M、P，分别表示有N个PM，M个程序员，P个idea。随后有P行，每行有4个数字，分别是PM序号、提出时间、优先等级和所需时间。
 * 所有输入数据范围为 [1, 3000]
 * 输出
 * 输出P行，分别表示每个idea实现的时间点。
 * <p>
 * 样例输入
 * 2 2 5
 * 1 1 1 2
 * 1 2 1 1
 * 1 3 2 2
 * 2 1 1 2
 * 2 3 5 5
 * 样例输出
 * 3
 * 4
 * 5
 * 3
 * 9
 *
 * @author NikoBelic
 * @create 2017/8/22 20:16
 */
public class Main
{
    public static void fun3(int n1, int n2, List<int[]> nums)
    {
        int time = 0;
        List<int[]> works = new ArrayList<int[]>();
        for (int i = 0; i < n2; i++)
        {
            int[] nn = new int[4];
            works.add(nn);
        }
        while (true)
        {
            int count = 0;
            for (int i = 0; i < works.size(); i++)
                if (works.get(i)[0] == 0)
                    count += 1;
            if (count == works.size() && nums.size() == 0)
                break;
            time += 1;
            for (int i = 0; i < works.size(); i++)
            {
                //没有工作
                if (works.get(i)[0] == 0)
                {
                    if (nums.size() > 0)
                    {
                        int[] mm = findBestWord(nums, time);
                        for (int j = 0; j < 4; j++)
                            works.get(i)[j] = mm[j];
                    }

                }
                //做完了
                else if (works.get(i)[3] == 1)
                {
                    works.get(i)[0] = 0;
                    System.out.println(time);
                    if (nums.size() > 0)
                    {
                        int[] mm = findBestWord(nums, time);
                        for (int j = 0; j < 4; j++)
                            works.get(i)[j] = mm[j];
                    }
                } else
                    works.get(i)[3] -= 1;
            }
        }
    }

    public static int[] findBestWord(List<int[]> nums, int time)
    {
        int[] rel = new int[4];
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        int min1 = 1000, max2 = 0, min = time;
        int index1 = 0, index2 = 0, index3 = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums.get(i)[1] <= time)
                if (nums.get(i)[2] <= min1)
                {
                    min1 = nums.get(i)[2];
                    index1 = i;
                }
        }
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums.get(i)[2] == min1)
                l1.add(i);
        }
        for (int i = 0; i < l1.size(); i++)
        {
            if (nums.get(l1.get(i))[3] >= max2)
                max2 = nums.get(l1.get(i))[3];
        }
        for (int i = 0; i < l1.size(); i++)
        {
            if (nums.get(l1.get(i))[3] == max2)
                l2.add(l1.get(i));
        }
        for (int i = 0; i < l2.size(); i++)
        {
            if (nums.get(l2.get(i))[0] <= min)
            {
                min = nums.get(l2.get(i))[1];
                index1 = l2.get(i);
            }
        }
        rel = nums.get(index1);
        nums.remove(index1);
        return rel;
    }
}