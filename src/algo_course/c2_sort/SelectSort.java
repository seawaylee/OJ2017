package algo_course.c2_sort;

/**
 * @author NikoBelic
 * @create 2017/8/1 23:17
 */
public class SelectSort
{
    public static int[] selectionSort(int[] A, int n)
    {
        int t, min, min_index, compareCount = 0;
        for (int i = 0; i < n; i++)
        {
            min_index = i;
            min = A[i];
            for (int j = i; j < n; j++)
            {
                compareCount++;
                if (A[j] < min)
                {
                    min = A[j];
                    min_index = j;
                }
            }
            t = A[i];
            A[i] = A[min_index];
            A[min_index] = t;
        }
        System.out.println("compareCount=" + compareCount);
        return A;
    }

    public static void main(String[] args)
    {
        int[] A = {6, 3, 4, 2, 1, 5, 7, 9, 8};
        A = selectionSort(A, A.length);
        for (int i : A)
        {
            System.out.print(i + " ");
        }
    }
}
