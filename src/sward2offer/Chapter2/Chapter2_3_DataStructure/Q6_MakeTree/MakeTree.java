package sward2offer.Chapter2.Chapter2_3_DataStructure.Q6_MakeTree;

import sward2offer.Chapter2.Chapter2_3_DataStructure.model.TreeNode;

import java.util.*;

/**
 * @author NikoBelic
 * @create 16/03/2017 19:55
 */
public class MakeTree
{
    /**
     * 构建一颗随机值的二叉树
     *
     * @Author NikoBelic
     * @Date 16/03/2017 20:36
     */
    public static void buildRandomTree(TreeNode root, int deep)
    {
        int type = new Random().nextInt(100) % 3;
        //int type = 0; // 构建满二叉树
        if (deep > 0)
        {
            if (type == 0) // 左+右
            {
                root.left = new TreeNode(new Random().nextInt(10));
                root.right = new TreeNode(new Random().nextInt(10));
                System.out.print("left-" + root.left.val);
                System.out.println("right-" + root.right.val);
                buildRandomTree(root.left, deep - 1);
                buildRandomTree(root.right, deep - 1);
            } else if (type == 1)
            {
                root.left = new TreeNode(new Random().nextInt(10));
                System.out.println("left-" + root.left.val);
                buildRandomTree(root.left, deep - 1);
            } else
            {
                root.right = new TreeNode(new Random().nextInt(10));
                System.out.println("right-" + root.right.val);
                buildRandomTree(root.right, deep - 1);
            }
        } else
            return;

    }

    /**
     * 广度优先遍历二叉树
     *
     * @Author NikoBelic
     * @Date 16/03/2017 20:36
     */
    public static void bfs(TreeNode node)
    {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(node);
        while (!q.isEmpty())
        {
            node = q.pop();
            System.out.println(node.val);
            if (node.left != null)
                q.addLast(node.left);
            if (node.right != null)
                q.addLast(node.right);
        }

    }


    /**
     * 按照中序、先序遍历结果，重新构建二叉树
     *
     * @Author SeawayLee
     * @Date 2017/03/21 19:17
     */
    public static TreeNode constructCore(int[] preVisit, int[] midVisit)
    {
        if (preVisit == null || midVisit == null)
            return null;

        // 创建root节点
        int rootValue = preVisit[0];
        TreeNode root = new TreeNode(rootValue);

        // 只有一个节点
        if (preVisit.length == 1)
        {
            if (midVisit.length == 1 && preVisit[0] == midVisit[0])
                return root;
            else
                System.out.println("Invalid Input...");
        }

        // 在中序遍历中找到根节点
        int rootIndex = 0;
        while (rootIndex <= midVisit.length - 1 && midVisit[rootIndex] != rootValue)
        {
            rootIndex++;
        }

        // 构建左子树
        int[] preLeft = Arrays.copyOfRange(preVisit, 1, rootIndex + 1);
        int[] midLeft = Arrays.copyOfRange(midVisit, 0, rootIndex);
        if (preLeft.length > 0)
        {
            root.left = constructCore(preLeft, midLeft);
        }

        // 构建右子树
        int[] preRight = Arrays.copyOfRange(preVisit, rootIndex + 1, preVisit.length);
        int[] midRight = Arrays.copyOfRange(midVisit, rootIndex + 1, midVisit.length);
        if (preRight.length > 0)
        {
            root.right = constructCore(preRight, midRight);
        }

        return root;
    }


    public static void main(String[] args) throws InterruptedException
    {
        //TreeNode root = new TreeNode(0);
        //buildRandomTree(root, 3);
        TreeNode root = constructCore(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        bfs(root);

    }
}
