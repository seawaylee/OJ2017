package algo_course.c3_str;

import algo_course.models.TreeNode;
import algo_course.tree.TreeUtil;

/**
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 * 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
 *
 * @author NikoBelic
 * @create 2017/8/6 15:39
 */
public class ChkIdentical
{
    public boolean chkIdentical(TreeNode t1, TreeNode t2)
    {
        StringBuilder sb1 = new StringBuilder();
        serializeTree(t1, sb1);
        StringBuilder sb2 = new StringBuilder();
        serializeTree(t2, sb2);
        if (sb1.toString().indexOf(sb2.toString()) != -1)
        {
            return true;
        }
        return false;
    }

    public void serializeTree(TreeNode t, StringBuilder sb)
    {
        if (t == null)
        {
            sb.append("#!");
            return;
        }
        sb.append(t.val).append("!");

        if (t.left != null)
            serializeTree(t.left, sb);
        else
            sb.append("#!");

        if (t.right != null)
            serializeTree(t.right, sb);
        else
            sb.append("#!");
    }

    public static void main(String[] args)
    {
        TreeNode t1 = TreeUtil.getTree();
        TreeNode t2 = new TreeNode(0);
        t2.left = new TreeNode(2);
        System.out.println(new ChkIdentical().chkIdentical(t1, t2));
    }
}
