import java.util.Scanner;
public class OrderSystem {
    
public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option;
        int quantity;
        int price = 0;
        int subtotal;
        int totalAmount = 0;
        int totalQuantity = 0;

        while (true) {

            System.out.println("=== Menu ===");
            System.out.println("1. Black tea ($30)");
            System.out.println("2. Green tea ($35)");
            System.out.println("3. Coffee ($50)");
            System.out.println("0. Checkout");
            System.out.print("請輸入選項：");
            option = sc.nextInt();

            if (option == 0) {
                break;
            }

            switch (option) {
                case 1:
                    price = 30;
                    break;
                case 2:
                    price = 35;
                    break;
                case 3:
                    price = 50;
                    break;
                default:
                    System.out.println("Unknown option");
                    continue;
            }

            System.out.print("請輸入數量：");
            quantity = sc.nextInt();

            if (quantity <= 0) {
                System.out.println("數量必須大於 0");
                continue;
            }

            subtotal = price * quantity;
            totalAmount += subtotal;
            totalQuantity += quantity;

            System.out.println("本次小計：" + subtotal);
            System.out.println();
        }

        System.out.println("===== Checkout =====");
        System.out.println("總數量：" + totalQuantity);
        System.out.println("總金額：" + totalAmount);

        sc.close();
    }
}