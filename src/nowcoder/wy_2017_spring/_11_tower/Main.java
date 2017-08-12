package nowcoder.wy_2017_spring._11_tower;

        import java.util.Scanner;

/**
 * @author NikoBelic
 * @create 2017/8/12 03:24
 */
public class Main
{
    public static int process(int[] b, int from, int half)
    {
        if (from == b.length)
            return 0;
        int height = process(b, from + 1, half);
        if (height == half)
            return half;
        return b[from] + height;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] b = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            b[i] = sc.nextInt();
            sum += b[i];
        }
        int half = sum / 2;
        int res = process(b, 0, half);
        if (res == half)
        {
            System.out.println(half);
        } else
            System.out.println("-1");
    }
}
