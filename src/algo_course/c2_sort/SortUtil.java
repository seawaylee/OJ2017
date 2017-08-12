package algo_course.c2_sort;

import java.util.Random;

/**
 * @author NikoBelic
 * @create 2017/8/2 00:21
 */
public class SortUtil
{
    public static void printArray(int[] array)
    {
        for (int i : array)
        {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static int[] getRandomArray(int length)
    {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++)
        {
            array[i] = random.nextInt(10);
        }
        return array;
    }

    public static void swap(int[] array, int from, int to)
    {
        int t = array[from];
        array[from] = array[to];
        array[to] = t;
    }

    public static int getRandomIndex(int from, int to)
    {
        return from + (int) (Math.random() * (to - from + 1));
    }

}
