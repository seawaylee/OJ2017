package algo_course.tree;


import algo_course.models.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树广度遍历,按树结构输出结果
 *
 * @author NikoBelic
 * @create 09/01/2017 00:29
 */
public class VisitTree
{
    /**
     * 广度优先遍历
     *
     * @Author NikoBelic
     * @Date 09/01/2017 01:28
     */
    public static int[][] bfs(TreeNode root)
    {
        Deque<TreeNode> queue = new ArrayDeque<>();
        ArrayList<ArrayList> tmpList = new ArrayList<>();
        ArrayList<Integer> subList = new ArrayList<>();
        if (root == null)
            return null;
        queue.add(root);
        TreeNode currentNode; // 当前节点
        TreeNode last = root; // 当前行最后一个节点
        TreeNode nlast = root; // 下一行最后一个节点(动态)
        while (!queue.isEmpty())
        {
            currentNode = queue.pollFirst();
            if (currentNode.left != null)
            {
                queue.addLast(currentNode.left);
                nlast = currentNode.left;
            }
            if (currentNode.right != null)
            {
                queue.addLast(currentNode.right);
                nlast = currentNode.right;
            }
            //System.out.print(currentNode.value);
            subList.add(currentNode.val);
            if (last == currentNode)
            {
                //System.out.println("");
                last = nlast;
                tmpList.add(subList);
                subList = new ArrayList<>();
            }
        }
        // 将结果转换为数组返回
        int[][] result = new int[tmpList.size()][];
        int row = 0, col = 0;
        for (ArrayList<Integer> list : tmpList)
        {
            result[row] = new int[list.size()];
            for (Integer val : list)
            {
                result[row][col++] = val;
                //System.out.print(val + " ");
            }
            row++;
            col = 0;
            //System.out.println("");
        }
        return result;
    }

    /**
     * 先序优先遍历二叉树并序列化
     *
     * @Author NikoBelic
     * @Date 09/01/2017 01:29
     */
    public static String serialTree(TreeNode node)
    {
        //// TODO: 09/01/2017
        return "";
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(0);
        TreeNode l = new TreeNode(1);
        TreeNode r = new TreeNode(2);
        TreeNode ll = new TreeNode(3);
        TreeNode lr = new TreeNode(4);
        TreeNode rl = new TreeNode(5);
        TreeNode rr = new TreeNode(6);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.left = rl;
        r.right = rr;
        int[][] tree = bfs(root);
        for (int[] rows : tree)
        {
            for (int val : rows)
            {
                System.out.print(val + " ");
            }
            System.out.println("");
        }
        //bfs(root);
    }
}


