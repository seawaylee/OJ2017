package algo_course.c2_sort.old;

/**
 * @author NikoBelic
 * @create 17/01/2017 14:38
 */
public class QuickSort
{
    public static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int middle = getMiddle(arr, low, high);
            quickSort(arr, low, middle - 1);
            quickSort(arr, middle + 1, high);
        }
    }

    public static int getMiddle(int[] list, int low, int high)
    {
        int tmp = list[low];
        while (low < high)
        {
            while (low < high && list[high] >= tmp)
            {
                high--;
            }
            list[low] = list[high];
            while (low < high && list[low] <= tmp)
            {
                low++;
            }
            list[high] = list[low];
        }
        list[low] = tmp;
        return low;
    }

    public static void main(String[] args)
    {
        int[] arr = {8, 1, 0, 4, 6, 2, 7, 9, 5, 3};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr)
        {
            System.out.println(i);
        }
    }
}
