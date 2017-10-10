package nowcoder.souhu.huiwen;

import sun.font.TrueTypeFont;

import java.util.*;

/**
 * @author NikoBelic
 * @create 2017/9/17 19:43
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        int[] res = new int[l * 2];
        for (int i = 0; i < l; i++)
        {
            a.add(sc.nextInt());
        }

        int left = 0;
        int right = 0;
        boolean putRight = true;
        int rightMoveCount = 0;
        int leftMoveCount = 0;
        for (int i = 0; i < a.size() / 2 + 1; i++)
        {
            left = a.get(i - leftMoveCount);
            right = a.get(a.size() - 1 - i + rightMoveCount);
            if (left == right)
            {
                res[i] = left;
                res[a.size() - i] = left;
            } else
            {
                putRight = left < right;
                if (putRight)
                {
                    res[i] = left;
                    res[a.size() - 1 - i + 1] = left;
                    rightMoveCount++;
                } else
                {
                    res[a.size() - 1 - i + 1] = right;
                    res[i] = right;
                    leftMoveCount++;
                }
            }
        }
        int sum = 0;
        for (Integer re : res)
        {
            sum += re;
        }
        System.out.println(sum);
    }
}
