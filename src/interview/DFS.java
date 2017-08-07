package interview;

import java.util.*;

/**
 * @author NikoBelic
 * @create 04/01/2017 17:38
 */
public class DFS
{
    private Deque<TreeNode> q = new ArrayDeque<>();

    private void dfs(TreeNode node)
    {
        if (node == null)
            return;
        System.out.println(node.val);
        dfs(node.left);
        dfs(node.right);
    }

    private void bfs(TreeNode node)
    {
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

    public static void main(String[] args)
    {
        DFS d = new DFS();
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
        //d.dfs(root);
        d.bfs(root);
    }
}

class TreeNode
{
    Integer val;
    TreeNode left;
    TreeNode right;

    public TreeNode(Integer val)
    {
        this.val = val;
    }

}