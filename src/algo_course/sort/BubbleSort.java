package algo_course.sort;

/**
 * 优化版冒泡排序
 * 思路:每次冒泡都会将无序部分最大的数移动到无序部分的最后一个位置
 * @author NikoBelic
 * @create 16/01/2017 17:54
 */
public class BubbleSort
{
    public static int[] sort(int[] array)
    {
        boolean swap = false;
        for (int i = 0; i < array.length - 1; i++)
        {
            swap = false;
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                    swap = true; // 如果某一轮冒泡发现没有任何位置的交换,那么说明这个数组已经是有序的,无需再进行下一轮冒泡
                }
            }
            if (!swap)
                break;
        }
        return array;
    }

    public static void main(String[] args)
    {
        int[] arrays = new int[]{9, 8, 7, 6, 5, 22, 3, 2, 1, 10};
        //arrays = sort(arrays);
        arrays = sort(arrays);
        for (int i = 0; i < arrays.length; i++)
        {
            System.out.print(arrays[i] + " ");
        }
    }
}
