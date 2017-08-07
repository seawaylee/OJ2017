package algo_course.models;

/**
 * @author NikoBelic
 * @create 09/01/2017 00:31
 */
public class TreeNode
{
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer val) {
        this.val = val;
    }

    @Override
    public String toString()
    {
        return "TreeNode{" + "val=" + val + ", left=" + left + ", right=" + right + '}';
    }
}
