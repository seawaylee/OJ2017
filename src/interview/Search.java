package interview;

import java.util.Arrays;
import java.util.Random;

/**
 * @author NikoBelic
 * @create 05/01/2017 10:01
 */
public class Search
{
    public static <T extends Comparable<T>> void sort(T[] list)
    {
        T t;
        for (int i = 0; i < list.length - 1; i++)
        {
            for (int j = 0; j < list.length - i - 1; j++)
            {
                if (list[j].compareTo(list[j+1]) > 0)
                {
                    t = list[j];
                    list[j] = list[j+1];
                    list[j+1] = t;
                }
            }
        }
    }

    /**
     * 折半查找
     * @Author NikoBelic
     * @Date 09/01/2017 01:31
     */
    public static <T extends Comparable<T>> int binarySearch(T[] list,T key)
    {
        int mid = 0;
        int high = list.length - 1;
        int low = 0;
        while (low <= high)
        {
            mid = (high + low) >>> 1;
            if (list[mid].compareTo(key) == 0)
                return mid;
            if (list[mid].compareTo(key) > 0)
                high = mid - 1;
            if (list[mid].compareTo(key) < 0)
                low = mid + 1;
        }
        return -1;
    }

    /*public static int binarySearch(Comparable[] list,Comparable key)
    {
        int mid = 0;
        int high = list.length - 1;
        int low = 0;
        while (low <= high)
        {
            mid = (high + low) >>> 1;
            if (list[mid].compareTo(key) == 0)
                return mid;
            if (list[mid].compareTo(key) > 0)
                high = mid - 1;
            if (list[mid].compareTo(key) < 0)
                low = mid + 1;
        }
        return -1;
    }*/



    public static void main(String[] args)
    {
        Integer[] array = new Integer[21];
        for(int i = 0 ; i < 20; i++)
        {
            array[i] = new Random().nextInt(100);
        }
        array[20] = 7;
        //sort(array);
        Arrays.sort(array);
        for (Integer integer : array)
        {
            System.out.println(integer);
        }
        System.out.println("-------------");
        System.out.println(binarySearch(array,40));

    }
}
