package sward2offer.model;

/**
 * @author NikoBelic
 * @create 15/03/2017 21:17
 */
public class SimpleLinkedList
{
    public int val;
    public SimpleLinkedList next;

    public SimpleLinkedList(int val,SimpleLinkedList next)
    {
        this.val = val;
        this.next = next;
    }
}
