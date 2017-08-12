package algo_course.c2_sort;

/**
 * @author NikoBelic
 * @create 2017/8/4 00:49
 */
public class QuickSort
{
    //public static int partition(int a[], int left, int right)
    //{
    //    int i = left, j = right;
    //    int x = a[left];
    //
    //    while (i < j)
    //    {
    //        // 从右向左找小于x的数来填a[i]
    //        while (i < j && a[j] > x)
    //        {
    //            j--;
    //        }
    //        if (i < j)
    //        {
    //            a[i] = a[j];
    //            i++;
    //        }
    //
    //        // 从左向右找大于或等于x的数来填a[j]
    //        while (i < j && a[i] < x)
    //        {
    //            i++;
    //        }
    //        if (i < j)
    //        {
    //            a[j] = a[i];
    //            j--;
    //        }
    //    }
    //    // 退出时，i等于j，将x填入此坑
    //    a[i] = x;
    //    return i;
    //}
    //
    //public static void quickSort(int[] a, int left, int right)
    //{
    //    if (left < right)
    //    {
    //        int i = partition(a, left, right);
    //        quickSort(a, left, i - 1);
    //        quickSort(a, i + 1, right);
    //    }
    //}

    public static void quickSort(int[] a, int left, int right)
    {
        if (left < right)
        {
            int i = left, j = right;
            // 以中间数为基准
            //SortUtil.swap(a, left, (left + right) / 2);
            // 以随机数为基准
            SortUtil.swap(a, left, SortUtil.getRandomIndex(left, right));
            int x = a[left]; // a[left] 就是被挖出的第一个坑
            while (i < j)
            {
                // 从右向左找小于x的数来填a[i]
                while (i < j && a[j] > x)
                    j--;

                if (i < j)
                    a[i++] = a[j]; // 将a[j]填到a[i]，a[j]形成了新的坑
                // 从左向右找大于x的数来填a[j]
                while (i < j && a[i] < x)
                    i++;
                if (i < j)
                    a[j--] = a[i];// 将[i]天到a[j],a[i]形成了新的坑
            }
            a[i] = x;// 退出时，i等于j，将x填到这个坑
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        }
    }


    public static void main(String[] args)
    {
        int[] a = SortUtil.getRandomArray(10);
        SortUtil.printArray(a);
        quickSort(a, 0, a.length - 1);
        SortUtil.printArray(a);
    }
}
