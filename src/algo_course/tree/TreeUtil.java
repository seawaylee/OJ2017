package algo_course.tree;

import algo_course.models.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Random;

/**
 * @author NikoBelic
 * @create 2017/8/6 15:46
 */
public class TreeUtil
{
    public static TreeNode getTree()
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
        return root;
    }


    public static void printTree(TreeNode root)
    {
        Deque<TreeNode> queue = new ArrayDeque<>();
        ArrayList<ArrayList> tmpList = new ArrayList<>();
        ArrayList<Integer> subList = new ArrayList<>();
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
            System.out.print(currentNode.val);
            if (last == currentNode)
            {
                last = nlast;
                System.out.println("");
            }
        }

    }
}
