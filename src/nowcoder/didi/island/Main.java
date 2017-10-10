package nowcoder.didi.island;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author NikoBelic
 * @create 2017/9/23 20:00
 */
public class Main
{
    public static Set<String> islands = new HashSet<>();

    public static int countIsland(int[][] map, int m, int n)
    {
        int count = 0;
        boolean firstCome = true;
        islands.clear();
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (map[i][j] == 1 && !islands.contains(i + "," + j))
                {
                    try
                    {
                        if (map[i - 1][j] != 1 && map[i + 1][j] != 1 && map[i][j - 1] != 1 && map[i][j + 1] != 1)
                        {
                            count++;
                            islands.add(i + "," + j);
                        } else if (firstCome)
                        {
                            count++;
                            firstCome = false;
                        }
                    } catch (Exception e)
                    {
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] map = new int[m + 2][n + 2];
        //Arrays.fill(map, 0);
        int k = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (!(x >= m || x < 0 || y >= n || y < 0))
                map[x + 1][y + 1] = 1;
            islands.add(x + "," + y);
            int c = countIsland(map, m, n);
            sb.append(c).append(" ");
            //System.out.println(c);
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
