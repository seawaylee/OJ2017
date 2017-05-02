package interview;

import org.junit.Test;

import java.util.*;

/**
 * @author NikoBelic
 * @create 04/01/2017 09:47
 */
public class StringTest
{
    /**
     * 7、int和Integer有什么区别？
     *
     * @Author NikoBelic
     * @Date 04/01/2017 09:51
     */
    public void autoBox()
    {
        Integer a = new Integer(1);
        Integer b = 1;
        int c = 1;

        System.out.println(a == b);// false   两个引用不一样
        System.out.println(a == c);// true     a会自动拆箱后与c比较
        System.out.println(b == c);// true
    }

    /**
     * valueOf的源码  [-128,127] 会从常量池取值
     *
     * @Author NikoBelic
     * @Date 04/01/2017 09:54
     */
    @org.junit.Test
    public void cacheInteger()
    {
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
    }

    /**
     * Java虽然是值传递,但是如果传递的是对象,那么其实这个值是该对象的地址
     * 通过这个地址对该对象的属性进行修改,会生效
     *
     * @Author NikoBelic
     * @Date 04/01/2017 10:08
     */
    @Test
    public void testValueParse()
    {
        MyObj o1 = new MyObj();
        o1.a = 1;
        System.out.println(o1.a);
        change(o1);
        System.out.println(o1.a);
        Integer a = new Integer(129);
        changeBasic(a);
        System.out.println(a);
    }

    private void change(MyObj obj)
    {
        obj.a = 5;
    }

    private void changeBasic(Integer a)
    {
        a = 5;
    }

    class MyObj implements Comparable<MyObj>
    {
        int a;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        @Override
        public int compareTo(MyObj o)
        {
            return o.a - this.a;
        }

        @Override
        public String toString() {
            return "MyObj{" +
                    "a=" + a +
                    '}';
        }
    }


    /**
     * String和StringBuilder、StringBuffer的区别？
     * builder线程不安全   buffer线程安全安全  其他无任何区别
     *
     * @Author NikoBelic
     * @Date 04/01/2017 10:19
     */
    @Test
    public void testDifference()
    {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);// fasle
        System.out.println(s1 == s5);// true
        /*
        字符串的+操作其本质是创建了StringBuilder对象进行append操作，
        然后将拼接后的StringBuilder对象用toString方法处理成String对象
         */
        System.out.println(s1 == s6);// true  ??? -- false
        System.out.println(s1 == s6.intern());// true
        System.out.println(s2 == s2.intern());// false
    }

    /**
     * 方法区中字符串常量存储的是字符串首次出现的地址
     * @Author NikoBelic
     * @Date 04/01/2017 15:05
     */
    @Test
    public void methodAreaStr()
    {
        String sb1 = new StringBuilder("go").append("od").toString();
        System.out.println(sb1.intern() == sb1);
        String sb2 = new StringBuffer("ja").append("va").toString();
        System.out.println(sb2.intern() == sb2);
    }
    // Collections Arrays 工具类
    @Test
    public void arraylist()
    {
        // 将容器转换为线程安全的  - 装饰器模式
        List<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("cdd");
        list.add("baa");
        List<String> safeList = Collections.synchronizedList(list);
        Collections.sort(safeList);
        Map map = new HashMap<>();
        map.put("a",2);
        System.out.println(safeList);
        // 排序
        MyObj o1 = new MyObj();
        o1.a = 10;
        MyObj o2 = new MyObj();
        o2.a = 5;
        Set<MyObj> set = new TreeSet<>();
        set.add(o1);
        set.add(o2);
        System.out.println(set);
    }



    public static String reverse(String originStr)
    {
        StringBuilder sb = new StringBuilder(originStr);
        return sb.reverse().toString();

        //if(originStr == null || originStr.length() <= 1)
        //    return originStr;
        //return  reverse(originStr.substring(1)) + originStr.charAt(0);
    }


    public static void main(String[] args)
    {
        System.out.println(reverse("abc"));
    }
}
