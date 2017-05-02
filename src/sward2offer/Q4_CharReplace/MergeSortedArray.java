package sward2offer.Q4_CharReplace;

import java.util.Arrays;

/**
 * @author NikoBelic
 * @create 14/03/2017 21:31
 */
public class MergeSortedArray
{

    public static int[] merge(int[] a, int[] b)
    {
        if (a == null)
            return b;
        if (b == null)
            return a;

        int p1 = a.length - 1 - b.length;
        int p2 = b.length - 1;
        while (p2 >= 0)
        {
            if (p1 >= 0 && a[p1] > b[p2])
            {
                a[p1 + p2 + 1] = a[p1];
                p1--;
            } else
            {
                a[p1 + p2 + 1] = b[p2];
                p2--;
            }
        }

        return a;
    }

    public static void main(String[] args)
    {
        //int[] a = {1, 5, 7, 9, 15, 0, 0, 0};
        //int[] a = {9, 15, 0, 0, 0};
        //int[] a = {1,9, 15, 0, 0, 0, 0,0};
        int[] a = {1,3,5,7,8,9,11,12,13,14,15,0,0,0,0,0};

        int[] b = {2, 4, 6, 10,16};
        merge(a, b);
        for (int i : a)
        {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
