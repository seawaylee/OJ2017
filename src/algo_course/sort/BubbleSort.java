package algo_course.sort;

import sun.jvm.hotspot.tools.SysPropsDumper;

/**
 * 优化版冒泡排序
 *
 * @author NikoBelic
 * @create 2017/8/1 22:39
 */
public class BubbleSort
{
    public int[] bubbleSort2(int[] A, int n)
    {
        int t;
        boolean swap = false;
        int compareCount = 0;
        for (int i = 0; i < n - 1; i++)
        {
            swap = false;
            for (int j = 0; j < n - i - 1; j++)
            {
                if (A[j] > A[j + 1])
                {
                    t = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = t;
                    swap = true;
                }
                compareCount++;
            }
            if (!swap) // 如果比较期间没有发生交换，那么说明该数组已经有序
                break;
        }
        System.out.println("compareCount=" + compareCount);
        return A;
    }

    public static void main(String[] args)
    {
        int[] A = {6, 3, 4, 2, 1, 5, 7, 9, 8};
        BubbleSort s = new BubbleSort();
        A = s.bubbleSort2(A, A.length);
        for (int i : A)
        {
            System.out.print(i + " ");
        }
    }
}
