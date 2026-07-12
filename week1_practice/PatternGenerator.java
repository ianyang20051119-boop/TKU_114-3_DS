import java.util.Scanner;

public class PatternGenerator {

    // 顯示選單
    public static void printMenu() {
        System.out.println("=== Pattern Menu ===");
        System.out.println("1. Multiplication Table");
        System.out.println("2. Triangle");
        System.out.println("3. Reverse Triangle");
        System.out.println("4. Number Grid");
        System.out.println("0. Exit");
        System.out.print("請輸入選項：");
    }

    // 讀取正整數
    public static int readPositiveInt(Scanner sc, String message) {
        int value;

        while (true) {
            System.out.print(message);
            value = sc.nextInt();

            if (value > 0) {
                return value;
            }

            System.out.println("輸入必須大於 0");
        }
    }

    // 九九乘法表
    public static void printMultiplicationTable() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(i + "x" + j + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }

    // 正三角形
    public static void printTriangle(int height) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 倒三角形
    public static void printReverseTriangle(int height) {
        for (int i = height; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 數字方格
    public static void printNumberGrid(int rows, int cols) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0) {

            printMenu();
            option = sc.nextInt();

            switch (option) {

                case 1:
                    printMultiplicationTable();
                    break;

                case 2:
                    int height = readPositiveInt(sc, "請輸入高度：");
                    printTriangle(height);
                    break;

                case 3:
                    height = readPositiveInt(sc, "請輸入高度：");
                    printReverseTriangle(height);
                    break;

                case 4:
                    int rows = readPositiveInt(sc, "請輸入列數：");
                    int cols = readPositiveInt(sc, "請輸入欄數：");
                    printNumberGrid(rows, cols);
                    break;

                case 0:
                    System.out.println("Bye");
                    break;

                default:
                    System.out.println("Unknown option");
            }

            System.out.println();
        }

        sc.close();
    }
}