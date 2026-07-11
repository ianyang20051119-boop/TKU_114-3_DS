import java.util.Scanner;

public class OrderSystemRefactor_demo {

    public static void showMenu() {
        System.out.println("=== Order Menu ===");
        System.out.println("1. Black tea");
        System.out.println("2. Green tea");
        System.out.println("3. Coffee");
        System.out.println("0. Checkout");
        System.out.print("請輸入選項：");
    }

    public static int getPrice(int option) {
        switch (option) {
            case 1:
                return 30;
            case 2:
                return 35;
            case 3:
                return 50;
            default:
                return 0;
        }
    }

    public static int readQuantity(Scanner sc) {
        int quantity;

        while (true) {
            System.out.print("請輸入數量：");
            quantity = sc.nextInt();

            if (quantity > 0) {
                return quantity;
            }

            System.out.println("數量必須大於 0");
        }
    }

    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }

    public static void printReceipt(int totalItems, int totalAmount) {
        System.out.println();
        System.out.println("=== Receipt ===");
        System.out.println("Total items: " + totalItems);
        System.out.println("Total amount: " + totalAmount);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalItems = 0;
        int totalAmount = 0;
        int option = -1;

        while (option != 0) {

            showMenu();
            option = sc.nextInt();

            if (option == 0) {
                break;
            }

            int price = getPrice(option);

            if (price == 0) {
                System.out.println("Unknown option");
                continue;
            }

            int quantity = readQuantity(sc);
            int subtotal = calculateSubtotal(price, quantity);

            totalItems += quantity;
            totalAmount += subtotal;

            System.out.println("Subtotal: " + subtotal);
            System.out.println();
        }

        printReceipt(totalItems, totalAmount);

        sc.close();
    }
}