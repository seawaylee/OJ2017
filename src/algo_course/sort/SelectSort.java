package algo_course.sort;

/**
 * 简单选择排序
 * 思路:每次循环都将无序数组的第一个元素和无序数组中的最小元素互换位置
 * @author NikoBelic
 * @create 17/01/2017 13:29
 */
public class SelectSort
{
    public static int[] sort(int[] array)
    {
        int index;
        int min;
        for (int i = 0; i < array.length; i++)
        {
            index = i;
            min = array[i];
            // 找到最小值
            for (int j = i; j < array.length; j++)
            {
                if (array[j] < min)
                {
                    min = array[j];
                    index = j;
                }
            }
            int t = array[i];
            array[i] = array[index];
            array[index] = t;
        }
        return array;
    }
    public static void main(String[] args)
    {
        int[] arrays = new int[]{9, 8, 7, 6, 5, 22, 3, 2, 1, 10};
        arrays = sort(arrays);
        arrays = sort(arrays);
        for (int i = 0; i < arrays.length; i++)
        {
            System.out.print(arrays[i] + " ");
        }
    }
}
