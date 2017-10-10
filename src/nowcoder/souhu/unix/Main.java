import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String filepath = sc.nextLine();
        UnixPath(filepath);
        //System.out.println(resultpath);
    }

    private static void UnixPath(String filepath)
    {
        Stack<String> paths = new Stack<String>();
        String[] littlep = filepath.split("/");
        for (String path : littlep)
        {
            if (!paths.isEmpty() && path.equals(".."))
            {
                paths.pop();
            } else if (!path.equals(".") && !path.equals("") && !path.equals(".."))
            {
                paths.push(path);
            }
        }
        List<String> list = new ArrayList(paths);
        String result = "/";
        for (int i = 0; i < list.size(); i++)
        {
            if (i == list.size() - 1)
                result = result + list.get(i);
            else
                result = result + list.get(i) + "/";

        }
        System.out.println(result);
    }

}