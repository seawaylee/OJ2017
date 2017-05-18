package sward2offer.Chapter2.Chapter2_4_Algorithm.Preface;

import java.util.Random;

/**
 * @author NikoBelic
 * @create 2017/5/2 22:00
 */
public class QuickSort
{
    private int randomInRange(int start, int end)
    {
        return start + new Random().nextInt(end - start);
    }

    private void swap(int[] data, int from, int to)
    {
        int t = data[from];
        data[from] = data[to];
        data[to] = t;
    }

    private int partition(int[] data, int length, int start, int end) throws Exception
    {
        if (data == null || length <= 0 || start < 0 || end >= length)
        {
            throw new Exception("Invalid Params");
        }

        int index = randomInRange(start, end);
        swap(data, index, end);

        int small = start - 1;
        for (index = start; index < end; index++)
        {
            if (data[index] < data[end])
            {
                small++;
                if (small != index)
                {
                    swap(data, index, small);
                }
            }
        }
        small++;
        swap(data, small, end);
        return small;
    }

    private void sort(int[] data, int length, int start, int end) throws Exception
    {
        if (start == end)
            return;

        int index = partition(data, length, start, end);
        if (index > start) sort(data, length, start, index - 1);
        if (index < end) sort(data, length, index + 1, end);
    }
    public static void main(String[] args) throws Exception
    {
        QuickSort s = new QuickSort();
        int[] data = {2,5,7,43,3,6,8,999,0};
        s.sort(data, data.length, 0, data.length - 1);
        for (int i = 0; i < data.length; i++)
        {
            System.out.print(data[i] + " ");
        }
    }

}
