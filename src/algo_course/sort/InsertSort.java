package algo_course.sort;

import sun.misc.Sort;

import java.util.Arrays;

/**
 * @author NikoBelic
 * @create 2017/8/1 23:58
 */
public class InsertSort
{
    public static int[] insertionSort(int[] array)
    {
        int preIndex, key, compareCounter = 0;
        for (int i = 1; i < array.length; i++)
        {
            preIndex = i - 1;
            key = array[i];
            while ((++compareCounter > 0) && (preIndex >= 0 && key < array[preIndex]))
            {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = key;
        }
        System.out.println("compareCounter = " + compareCounter);
        return array;
    }

    public static int[] insertionSort2(int[] array)
    {
        int key, pre, last, mid, compareCounter = 0;
        for (int i = 1; i < array.length; i++)
        {
            key = array[i];
            pre = 0;
            last = i - 1;
            while (pre <= last)
            {
                compareCounter++;
                mid = (pre + last) / 2;
                if (key < array[mid])
                {
                    last = mid - 1;
                } else
                {
                    pre = mid + 1;
                }
            }
            for (int j = i; j >= pre + 1; j--)
            {
                array[j] = array[j - 1];
            }
            array[pre] = key;
        }
        System.out.println("compareCounter = " + compareCounter);
        return array;
    }

    public static void main(String[] args)
    {
        int[] array = SortUtil.getRandomArray(10);
        int[] array2 = Arrays.copyOf(array, array.length);
        SortUtil.printArray(array);
        array = insertionSort(array);
        SortUtil.printArray(array);

        SortUtil.printArray(array2);
        array2 = insertionSort2(array2);
        SortUtil.printArray(array2);
    }
}
