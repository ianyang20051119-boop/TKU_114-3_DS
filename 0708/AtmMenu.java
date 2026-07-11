import java.util.Scanner;

public class AtmMenu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int balance = 1000;
        int option = -1;
        int amount;

        while (option != 0) {

            System.out.println("=== ATM Menu ===");
            System.out.println("1. Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("0. Exit");
            System.out.print("請輸入選項：");
            option = sc.nextInt();

            switch (option) {

                case 1:
                    System.out.println("目前餘額：" + balance);
                    break;

                case 2:
                    System.out.print("請輸入存款金額：");
                    amount = sc.nextInt();

                    if (amount <= 0) {
                        System.out.println("存款金額必須大於 0");
                    } else {
                        balance += amount;
                        System.out.println("存款成功！");
                        System.out.println("目前餘額：" + balance);
                    }
                    break;

                case 3:
                    System.out.print("請輸入提款金額：");
                    amount = sc.nextInt();

                    if (amount <= 0) {
                        System.out.println("提款金額必須大於 0");
                    } else if (amount > balance) {
                        System.out.println("餘額不足！");
                    } else {
                        balance -= amount;
                        System.out.println("提款成功！");
                        System.out.println("目前餘額：" + balance);
                    }
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