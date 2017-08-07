package algo_course.course_preview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author NikoBelic
 * @create 2017/7/31 23:21
 */
public class PrintBinTree
{
    public static int[][] print(TreeNode root)
    {
        Deque<TreeNode> queue = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> printResult = new ArrayList<>();
        ArrayList<Integer> lineResult = new ArrayList<>();
        TreeNode last, nlast, currNode;
        last = nlast = currNode = root;
        queue.addLast(root);
        while (!queue.isEmpty())
        {
            currNode = queue.pollFirst();
            if (currNode.left != null)
            {
                queue.addLast(currNode.left);
                nlast = currNode.left;
            }
            if (currNode.right != null)
            {
                queue.addLast(currNode.right);
                nlast = currNode.right;
            }
            if (last == currNode)
            {
                lineResult.add(currNode.val);
                printResult.add(lineResult);
                lineResult = new ArrayList<>();
                last = nlast;
            } else
            {
                lineResult.add(currNode.val);
            }
        }
        int[][] intRes = new int[printResult.size()][];
        int row = 0, col = 0;
        for (ArrayList<Integer> rows : printResult)
        {
            intRes[row] = new int[rows.size()];
            for (Integer data : rows)
            {
                intRes[row][col++] = data;
            }
            row++;
            col = 0;
        }
        return intRes;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int[][] result = print(root);
        for (int[] rows : result)
        {
            for (int data : rows)
            {
                System.out.print(data);
            }
            System.out.println("");
        }

    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString()
    {
        return "" + this.val;
    }
}