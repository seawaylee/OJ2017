package nowcoder.jd2018.brance;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static int sum = 0;
    public static boolean check(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else {
                if (stack.empty() || stack.pop() == ')') {
                    return false;
                }
            }
        }
        return true;
    }
    public static void find(String str) {
        if (str.equals("")) {
            sum++;
            return;
        }
        if (!check(str)) {
            return;
        }
        for (int j = str.length() - 1; j > 0; j--) {
            StringBuilder sb = new StringBuilder(str);
            if (sb.charAt(j) == ')') {
                sb.deleteCharAt(j);
                sb.deleteCharAt(0);
                find(sb.toString());
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        scanner.close();
        find(inputStr);
        System.out.println(sum);
    }

   

   
}