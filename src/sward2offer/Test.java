package sward2offer;

/**
 * @author NikoBelic
 * @create 15/03/2017 16:18
 */
public class Test
{
    public static void main(String[] args)
    {
        String s1 = new String("HelloWorld");
        String s2 = "HelloWorld";
        String s3 = "Hello";
        String s4 = "World";
        String s5 = s3 + s4;

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        //System.out.println(s1.intern() == s2);
        System.out.println(s2 == s5);


    }
}
