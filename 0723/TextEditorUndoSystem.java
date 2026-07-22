import java.util.Scanner;
import java.util.Stack;

public class TextEditorUndoSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<String> history = new Stack<>();

        String text = "";
        int choice = 0;

        do {
            System.out.println("\n===== 文字編輯器 =====");
            System.out.println("1. 新增文字");
            System.out.println("2. 刪除最後幾個字元");
            System.out.println("3. Undo");
            System.out.println("4. 顯示內容");
            System.out.println("5. Undo 三次測試");
            System.out.println("6. 結束");
            System.out.print("請輸入選項：");

            if (!sc.hasNextInt()) {
                System.out.println("請輸入1~6！");
                sc.next();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("請輸入要新增的文字：");
                    String addText = sc.nextLine();

                    history.push(text);
                    text = addText(text, addText);

                    System.out.println("新增完成！");
                    break;

                case 2:

                    System.out.print("請輸入要刪除幾個字元：");

                    if (!sc.hasNextInt()) {
                        System.out.println("請輸入正整數！");
                        sc.next();
                        break;
                    }

                    int count = sc.nextInt();
                    sc.nextLine();

                    history.push(text);
                    text = deleteLast(text, count);

                    System.out.println("刪除完成！");
                    break;

                case 3:

                    text = undo(history, text);

                    break;

                case 4:

                    System.out.println("目前內容：" + text);

                    break;

                case 5:

                    history.push(text);
                    text = addText(text, "ABC");

                    history.push(text);
                    text = addText(text, "123");

                    history.push(text);
                    text = addText(text, "XYZ");

                    System.out.println("目前內容：" + text);

                    text = undo(history, text);
                    System.out.println("Undo1：" + text);

                    text = undo(history, text);
                    System.out.println("Undo2：" + text);

                    text = undo(history, text);
                    System.out.println("Undo3：" + text);

                    break;

                case 6:

                    System.out.println("程式結束！");
                    break;

                default:

                    System.out.println("請輸入1~6！");
            }

        } while (choice != 6);

        sc.close();
    }

    public static String addText(String text, String add) {
        return text + add;
    }

    public static String deleteLast(String text, int count) {

        if (count <= 0) {
            return text;
        }

        if (count >= text.length()) {
            return "";
        }

        return text.substring(0, text.length() - count);
    }

    public static String undo(Stack<String> history, String text) {

        if (history.isEmpty()) {
            System.out.println("沒有可復原的紀錄！");
            return text;
        }

        System.out.println("Undo 成功！");
        return history.pop();
    }
}