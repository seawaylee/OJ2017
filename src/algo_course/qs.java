package algo_course;

import algo_course.c2_sort.SortUtil;

/**
 * @author NikoBelic
 * @create 2017/8/10 00:31
 */
public class qs
{
    public static void quickSort(int[] a, int left, int right)
    {
        int i = left, j = right;
        int key = a[i];
        while (i < j)
        {
            while (i < j && a[j] > key)
            {
                j--;
            }
            if (i < j)
            {
                int t = a[i];
                a[i++] = a[j];
                a[j] = t;
            }

            while (i < j && a[i] < key)
            {
                i++;
            }
            if (i < j)
            {
                int t = a[j];
                a[j--] = a[i];
                a[i] = t;
            }
            a[i] = key;
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        }
    }

    public static void main(String[] args)
    {
        int[] randomArray = SortUtil.getRandomArray(10);
        SortUtil.printArray(randomArray);
        quickSort(randomArray, 0, randomArray.length - 1);
        SortUtil.printArray(randomArray);
    }
}
