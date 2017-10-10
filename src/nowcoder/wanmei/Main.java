package nowcoder.wanmei;

import java.util.*;

/**
 * @author NikoBelic
 * @create 2017/9/26 19:42
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        List<Integer> groupA = new ArrayList<>();
        List<Integer> groupB = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            groupA.add(sc.nextInt());
        }
        Collections.sort(groupA);

        for (int i = 0; i < n; i++)
        {
            groupB.add(sc.nextInt());
        }
        Collections.sort(groupB);


        for (int i = 0; i < n; i++)
        {
            int hero = groupB.get(i);
            int minDiff = Integer.MAX_VALUE;
            int minDiffIndex = -1;
            int diff = 0;
            boolean flag = false;
            // iter groupA
            for (int j = 0; j < groupA.size(); j++)
            {
                diff = hero - groupA.get(j);
                if (diff < 0 && Math.abs(diff) <= minDiff)
                {
                    minDiffIndex = j;
                    minDiff = diff;
                    flag = true;
                    break;
                }
            }
            if (minDiffIndex == -1)
            {
                if (!flag && diff == 0)
                    groupA.remove(0);
                continue;
            }
            if (minDiff == 0)
            {
                groupA.remove(minDiffIndex);
            } else
            {
                count += 100;
                groupA.remove(minDiffIndex);
            }
        }
        count -= groupA.size() * 100;
        System.out.println(count);

    }
}
