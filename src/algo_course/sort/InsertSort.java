package algo_course.sort;

/**
 * 插入排序
 *
 * @author NikoBelic
 * @create 16/01/2017 09:12
 */
public class InsertSort
{
    /**
     * 普通插入排序   空间复杂度O(1) 时间复杂度O(n^2)
     * 思路:从第2个元素开始,与其左边的有序数组进行逐一比较,找到其需要正确插入的位置
     * 将该位置右边的数组向右移动一位,然后将当前元素插入进去
     *
     * @Author NikoBelic
     * @Date 16/01/2017 09:36
     */
    public static int[] sort(int[] array)
    {
        int key; // Insert value
        int preIndex; // index that need to be move

        for (int i = 1; i < array.length; i++)
        {
            key = array[i]; // get the insert value
            preIndex = i - 1;
            // move elements which less than key
            while (preIndex >= 0 && key < array[preIndex])
            {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            // put the key in the correct position
            array[preIndex + 1] = key;
        }
        return array;
    }

    /**
     * 折半插入排序 空间、时间复杂度不变,较少了比较次数
     *
     * @Author NikoBelic
     * @Date 16/01/2017 09:37
     */
    public static int[] binarySort(int[] array)
    {
        //从数组的第二个位置开始遍历值
        for(int i = 1; i < array.length; i++)  {
            int key = array[i];           //暂存要插入的值
            int pre = 0;              //有序序列开始和结尾下标申明
            int last = i - 1;
            // 折半查找出插入位置 a[pre]
            while(pre <= last)  {
                int mid = (pre + last) / 2;
                if(key < array[mid])  {
                    last = mid - 1;
                } else {
                    pre = mid + 1;
                }
            }
            //a[i]已经取出来存放在key中，把下标从pre + 1到 i-1的元素依次后移
            for(int j = i; j >= pre + 1; j--)  {
                array[j] = array[j - 1];
            }
            //把值插入空白位置
            array[pre] = key;
        }
        return array;
    }


    public static void main(String[] args)
    {
        //int[] arrays = new int[]{2,5,6,8,3,3,6,8,9};
        int[] arrays = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        //arrays = sort(arrays);
        arrays = binarySort(arrays);
        for (int i = 0; i < arrays.length; i++)
        {
            System.out.print(arrays[i] + " ");
        }
    }
}
