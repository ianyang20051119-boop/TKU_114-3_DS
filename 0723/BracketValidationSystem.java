import java.util.Scanner;
import java.util.Stack;

public class BracketValidationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入字串：");
        String input = sc.nextLine();

        if (isValid(input)) {
            System.out.println("括號配對正確！");
        } else {
            System.out.println("括號配對錯誤！");
        }

        sc.close();
    }

    public static boolean isValid(String text) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (isLeftBracket(ch)) {
                stack.push(ch);
            } else if (isRightBracket(ch)) {

                if (stack.isEmpty()) {
                    return false;
                }

                char left = stack.pop();

                if (!isMatch(left, ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isLeftBracket(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    public static boolean isRightBracket(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    public static boolean isMatch(char left, char right) {

        if (left == '(' && right == ')') {
            return true;
        }

        if (left == '[' && right == ']') {
            return true;
        }

        if (left == '{' && right == '}') {
            return true;
        }

        return false;
    }
}