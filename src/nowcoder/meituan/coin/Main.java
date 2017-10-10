package nowcoder.meituan.coin;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author NikoBelic
 * @create 2017/9/14 20:27
 */
public class Main
{
    static int maxDiffTypeCoin = 0;
    static int maxAppearCount = 0;


    public static void main(String[] args)
    {
        int[] penny = new int[]{1, 2, 5, 10, 20, 50, 100};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer,Integer> appearMap =new HashMap<>();
        while (n > 0)
        {
            for (int i = 0; i < penny.length; i++)
            {
                int val = penny[i];
                appearMap.put(val, appearMap.containsKey(val) ? appearMap.get(val) + 1 : 1);
                n -= val;
                if (n < 0)
                {
                    n += val;
                    int now_count = appearMap.get(val);
                    now_count -= 1;
                    if (now_count <= 0)
                    {
                        appearMap.remove(val);
                    }
                    else
                    {
                        appearMap.put(val, now_count);
                    }
                    break;
                }
                else
                    maxAppearCount++;
            }
            while (n-- > 0)
            {
                maxAppearCount++;
            }
        }
        System.out.println(appearMap.size() + " " + maxAppearCount);
    }
}
