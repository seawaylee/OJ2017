package sward2offer.Q3_Array_Search;

import java.util.Arrays;
import java.util.Random;

/**
 * @author NikoBelic
 * @create 14/03/2017 19:17
 */
public class ArraySearch
{

    public static boolean findElementInArray(int[][] array, int key)
    {
        if (array == null)
            return false;

        int startCol = array[0].length - 1;
        for (int i = 0; i < array.length; i++)
        {
            for (int j = startCol; j > 0; j--)
            {
                System.out.println("查询位置:(" + i + "," + j + ")");
                // 如果当前数字大于key，则删除此列
                if (array[i][j] > key)
                {
                    // 删除过得列，不需要再查找，下次循环时从新的起始列开始查
                    startCol -= 1;
                    continue;
                }
                // 如果当前数字小于key，则删除此行
                else if (array[i][j] < key)
                    break;
                else
                {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        //Integer[][] array = new Integer[row+1][col+1]; // 这里为什么要多一个 不然会报错？
        int[][] array = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("===================");
        System.out.println("Result:" + findElementInArray(array, 15));
    }
}
