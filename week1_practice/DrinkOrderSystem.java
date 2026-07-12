import java.util.Scanner;

public class DrinkOrderSystem {

    // 顯示選單
    public static void printMenu() {
        System.out.println("=== Drink Menu ===");
        System.out.println("1. Black tea  $30");
        System.out.println("2. Green tea  $35");
        System.out.println("3. Milk tea   $45");
        System.out.println("4. Coffee     $50");
        System.out.println("0. Checkout");
        System.out.print("請輸入選項：");
    }

    // 回傳價格
    public static int getPrice(int option) {
        switch (option) {
            case 1:
                return 30;
            case 2:
                return 35;
            case 3:
                return 45;
            case 4:
                return 50;
            default:
                return 0;
        }
    }

    // 回傳商品名稱
    public static String getItemName(int option) {
        switch (option) {
            case 1:
                return "Black tea";
            case 2:
                return "Green tea";
            case 3:
                return "Milk tea";
            case 4:
                return "Coffee";
            default:
                return "";
        }
    }

    // 讀取合法數量
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

    // 計算小計
    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }

    // 計算折扣後金額
    public static int calculateDiscountedTotal(int totalAmount) {
        if (totalAmount >= 300) {
            return totalAmount * 9 / 10;
        }
        return totalAmount;
    }

    // 印出收據
    public static void printReceipt(int blackTeaCount, int greenTeaCount,
            int milkTeaCount, int coffeeCount,
            int totalItems, int totalAmount, int finalAmount) {

        System.out.println();
        System.out.println("=== Receipt ===");
        System.out.println("Black tea: " + blackTeaCount);
        System.out.println("Green tea: " + greenTeaCount);
        System.out.println("Milk tea: " + milkTeaCount);
        System.out.println("Coffee: " + coffeeCount);
        System.out.println("Total items: " + totalItems);
        System.out.println("Original amount: " + totalAmount);

        if (totalAmount >= 300) {
            System.out.println("Discount: Yes");
        } else {
            System.out.println("Discount: No");
        }

        System.out.println("Final amount: " + finalAmount);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option;
        int quantity;
        int price;
        int subtotal;

        int totalItems = 0;
        int totalAmount = 0;

        int blackTeaCount = 0;
        int greenTeaCount = 0;
        int milkTeaCount = 0;
        int coffeeCount = 0;

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

            totalItems += quantity;
            totalAmount += subtotal;

            switch (option) {
                case 1:
                    blackTeaCount += quantity;
                    break;
                case 2:
                    greenTeaCount += quantity;
                    break;
                case 3:
                    milkTeaCount += quantity;
                    break;
                case 4:
                    coffeeCount += quantity;
                    break;
            }

            System.out.println(getItemName(option) + " x " + quantity);
            System.out.println("Subtotal: " + subtotal);
            System.out.println();
        }

        int finalAmount = calculateDiscountedTotal(totalAmount);

        printReceipt(blackTeaCount, greenTeaCount, milkTeaCount,
                coffeeCount, totalItems, totalAmount, finalAmount);

        sc.close();
    }
}