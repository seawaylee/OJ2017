package nowcoder.wy_2017_spring._6_work_arrange;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 现在有n位工程师和6项工作(编号为0至5)，现在给出每个人能够胜任的工作序号表(用一个字符串表示，比如：045，表示某位工程师能够胜任0号，4号，5号工作)。现在需要进行工作安排，每位工程师只能被安排到自己能够胜任的工作当中去，两位工程师不能安排到同一项工作当中去。如果两种工作安排中有一个人被安排在的工作序号不一样就被视为不同的工作安排，现在需要计算出有多少种不同工作安排计划。
 * 输入描述:
 * <p>
 * 输入数据有n+1行：
 * 第一行为工程师人数n(1 ≤ n ≤ 6)
 * 接下来的n行，每行一个字符串表示第i(1 ≤ i ≤ n)个人能够胜任的工作(字符串不一定等长的)
 * <p>
 * <p>
 * 输出描述:
 * <p>
 * 输出一个整数，表示有多少种不同的工作安排方案
 * 示例1
 * 输入
 * <p>
 * 6
 * 012345
 * 012345
 * 012345
 * 012345
 * 012345
 * 012345
 * 输出
 * <p>
 * 720
 *
 * @author NikoBelic
 * @create 2017/8/12 13:25
 */
public class Main
{
    private static int cases = 0;

    public static void main(String[] args)
    {
        //读取输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] ables = new String[n];
        for (int i = 0; i < n; i++)
            ables[i] = in.next();

        HashSet<Integer> set = new HashSet<>();

        doWork(ables, 0, set);

        System.out.println(cases);
    }

    public static void doWork(String[] ables, int index, HashSet set)
    {
        if (index >= ables.length)
        {
            cases++;
            return;
        }

        String able = ables[index];
        for (int i = 0; i < able.length(); i++)
        {
            int work = able.charAt(i) - '0';
            if (!set.contains(work))
            {
                set.add(work);
                doWork(ables, index + 1, set);
                set.remove(work);
            }
        }
    }


}
