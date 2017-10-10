package algo_course.c2_sort;

/**
 * @author NikoBelic
 * @create 2017/10/10 16:32
 */
public class MergeSort
{
    public static void main(String[] args)
    {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        int len = arr.length;
        int[] reg = new int[len];
        merge_sort_recursive(arr, reg, 0, len - 1);
        for (int i : arr)
        {
            System.out.println(i);
        }
    }

    static void merge_sort_recursive(int[] arr, int[] reg, int start, int end)
    {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        //递归到子序列只有一个数的时候，开始逐个返回
        merge_sort_recursive(arr, reg, start1, end1);
        merge_sort_recursive(arr, reg, start2, end2);
        //-------合并操作，必须在递归之后（子序列有序的基础上）----
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            reg[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            reg[k++] = arr[start1++];
        while (start2 <= end2)
            reg[k++] = arr[start2++];
        //借用reg数组做合并，然后把数据存回arr中
        for (k = start; k <= end; k++)
            arr[k] = reg[k];
    }
}
