import java.util.Scanner;
public class OrderSystem_demo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option = -1;
        int quantity;
        int price = 0;
        int subtotal;
        int totalAmount = 0;
        int totalItems = 0;

        while (option != 0) {

            System.out.println("=== Order Menu ===");
            System.out.println("1. Black tea  $30");
            System.out.println("2. Green tea  $35");
            System.out.println("3. Coffee     $50");
            System.out.println("0. Checkout");
            System.out.print("請輸入選項：");
            option = sc.nextInt();

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
                case 0:
                    break;
                default:
                    System.out.println("Unknown option");
                    continue;
            }

            if (option == 0) {
                break;
            }

            System.out.print("請輸入數量：");
            quantity = sc.nextInt();

            if (quantity <= 0) {
                System.out.println("數量必須大於 0");
                continue;
            }

            subtotal = price * quantity;
            totalAmount += subtotal;
            totalItems += quantity;

            System.out.println("Subtotal: " + subtotal);
            System.out.println();
        }

        System.out.println();
        System.out.println("=== Receipt ===");
        System.out.println("Total items: " + totalItems);
        System.out.println("Total amount: " + totalAmount);

        sc.close();
    }
}
    

