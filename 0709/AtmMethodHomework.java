import java.util.Scanner;

public class AtmMethodHomework {

    // 顯示選單
    public static void printMenu() {
        System.out.println("=== ATM Menu ===");
        System.out.println("1. Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("0. Exit");
        System.out.print("請輸入選項：");
    }

    // 讀取合法金額
    public static int readPositiveAmount(Scanner sc, String message) {
        int amount;

        while (true) {
            System.out.print(message);
            amount = sc.nextInt();

            if (amount > 0) {
                return amount;
            }

            System.out.println("金額必須大於 0");
        }
    }

    // 存款
    public static int deposit(int balance, int amount) {
        return balance + amount;
    }

    // 提款
    public static int withdraw(int balance, int amount) {
        if (amount > balance) {
            System.out.println("餘額不足！");
            return balance;
        }

        return balance - amount;
    }

    // 顯示餘額
    public static void printBalance(int balance) {
        System.out.println("目前餘額：" + balance);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int balance = 1000;
        int option = -1;

        while (option != 0) {

            printMenu();
            option = sc.nextInt();

            switch (option) {

                case 1:
                    printBalance(balance);
                    break;

                case 2:
                    int depositAmount = readPositiveAmount(sc, "請輸入存款金額：");
                    balance = deposit(balance, depositAmount);
                    System.out.println("存款成功！");
                    printBalance(balance);
                    break;

                case 3:
                    int withdrawAmount = readPositiveAmount(sc, "請輸入提款金額：");
                    balance = withdraw(balance, withdrawAmount);
                    printBalance(balance);
                    break;

                case 0:
                    System.out.println("謝謝使用，再見！");
                    break;

                default:
                    System.out.println("選項錯誤！");
            }

            System.out.println();
        }

        sc.close();
    }
}