import java.util.Scanner;

public class OrderSystem {

    
    public static void printMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Black tea ($30)");
        System.out.println("2. Green tea ($35)");
        System.out.println("3. Coffee ($50)");
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

    
    public static String getItemName(int option) {
        switch (option) {
            case 1:
                return "Black tea";
            case 2:
                return "Green tea";
            case 3:
                return "Coffee";
            default:
                return "";
        }
    }

    
    public static int readValidQuantity(Scanner sc) {
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

    // 印出收據
    public static void printReceipt(int totalItems, int totalAmount) {
        System.out.println("===== Checkout =====");
        System.out.println("總數量：" + totalItems);
        System.out.println("總金額：" + totalAmount);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option;
        int price;
        int quantity;
        int subtotal;
        int totalAmount = 0;
        int totalItems = 0;

        while (true) {

            printMenu();
            option = sc.nextInt();

            if (option == 0) {
                break;
            }

            price = getPrice(option);

            if (price == 0) {
                System.out.println("Unknown option");
                continue;
            }

            quantity = readValidQuantity(sc);

            subtotal = calculateSubtotal(price, quantity);

            totalAmount += subtotal;
            totalItems += quantity;

            System.out.println(getItemName(option));
            System.out.println("本次小計：" + subtotal);
            System.out.println();
        }

        printReceipt(totalItems, totalAmount);

        sc.close();
    }
}