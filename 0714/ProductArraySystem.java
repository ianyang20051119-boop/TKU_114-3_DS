import java.util.Scanner;

public class ProductArraySystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = {"Keyboard", "Mouse", "Monitor", "USB Cable", "Headset"};
        int[] prices = {890, 490, 5200, 250, 1290};
        int[] stocks = {12, 20, 5, 30, 8};

        int buyCount = 0;
        int restockCount = 0;

        while (true) {
            System.out.println("\n===== 商品管理系統 =====");
            System.out.println("1. 顯示全部商品");
            System.out.println("2. 依商品編號查詢");
            System.out.println("3. 購買商品");
            System.out.println("4. 補充商品庫存");
            System.out.println("5. 顯示低庫存商品");
            System.out.println("6. 顯示全部庫存總價值");
            System.out.println("7. 結束程式");
            System.out.print("請輸入操作選項 (1-7): ");

            if (!sc.hasNextInt()) {
                System.out.println("輸入錯誤！請輸入有效數字。");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();

            if (choice == 7) {
                System.out.println("\n===== 操作摘要 =====");
                System.out.printf("本次執行共成功購買商品：%d 次\n", buyCount);
                System.out.printf("本次執行共成功補充庫存：%d 次\n", restockCount);
                System.out.println("系統已順利結束，謝謝使用！");
                break;
            }

            switch (choice) {
                case 1:
                    printAllProducts(names, prices, stocks);
                    break;
                case 2:
                    queryProduct(sc, names, prices, stocks);
                    break;
                case 3:
                    if (purchaseProduct(sc, names, prices, stocks)) {
                        buyCount++;
                    }
                    break;
                case 4:
                    if (restockProduct(sc, names, stocks)) {
                        restockCount++;
                    }
                    break;
                case 5:
                    printLowStock(names, prices, stocks);
                    break;
                case 6:
                    printTotalValue(prices, stocks);
                    break;
                default:
                    System.out.println("無此選項，請輸入 1 到 7 之間的數字。");
            }
        }
        sc.close();
    }

    public static void printAllProducts(String[] names, int[] prices, int[] stocks) {
        System.out.println("\n編號\t商品名稱\t\t價格\t庫存");
        System.out.println("----------------------------------------");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%d\t%-15s\t%d\t%d\n", i, names[i], prices[i], stocks[i]);
        }
    }

    public static void queryProduct(Scanner sc, String[] names, int[] prices, int[] stocks) {
        System.out.print("請輸入要查詢的商品編號 (0-" + (names.length - 1) + "): ");
        if (!sc.hasNextInt()) {
            System.out.println("查詢失敗：請輸入整數編號。");
            sc.next();
            return;
        }
        int id = sc.nextInt();
        if (id < 0 || id >= names.length) {
            System.out.println("查詢失敗：查無此商品編號。");
            return;
        }
        System.out.println("\n--- 商品查詢結果 ---");
        System.out.printf("名稱：%s\n", names[id]);
        System.out.printf("價格：%d 元\n", prices[id]);
        System.out.printf("庫存：%d 個\n", stocks[id]);
    }

    public static boolean purchaseProduct(Scanner sc, String[] names, int[] prices, int[] stocks) {
        System.out.print("請輸入欲購買的商品編號 (0-" + (names.length - 1) + "): ");
        if (!sc.hasNextInt()) {
            System.out.println("購買失敗：請輸入整數編號。");
            sc.next();
            return false;
        }
        int id = sc.nextInt();
        if (id < 0 || id >= names.length) {
            System.out.println("購買失敗：查無此商品編號。");
            return false;
        }

        System.out.printf("當前商品：%s，剩餘庫存：%d。請輸入購買數量: ", names[id], stocks[id]);
        if (!sc.hasNextInt()) {
            System.out.println("購買失敗：數量必須是整數。");
            sc.next();
            return false;
        }
        int quantity = sc.nextInt();
        if (quantity <= 0) {
            System.out.println("購買失敗：購買數量必須大於 0。");
            return false;
        }
        if (quantity > stocks[id]) {
            System.out.println("購買失敗：庫存不足！");
            return false;
        }

        stocks[id] -= quantity;
        int cost = prices[id] * quantity;
        System.out.printf("購買成功！已扣除庫存。總花費：%d 元。\n", cost);
        return true;
    }

    public static boolean restockProduct(Scanner sc, String[] names, int[] stocks) {
        System.out.print("請輸入欲補充的商品編號 (0-" + (names.length - 1) + "): ");
        if (!sc.hasNextInt()) {
            System.out.println("進貨失敗：請輸入整數編號。");
            sc.next();
            return false;
        }
        int id = sc.nextInt();
        if (id < 0 || id >= names.length) {
            System.out.println("進貨失敗：查無此商品編號。");
            return false;
        }

        System.out.printf("當前商品：%s，原有庫存：%d。請輸入欲補充的數量: ", names[id], stocks[id]);
        if (!sc.hasNextInt()) {
            System.out.println("進貨失敗：數量必須是整數。");
            sc.next();
            return false;
        }
        int quantity = sc.nextInt();
        if (quantity <= 0) {
            System.out.println("進貨失敗：補充數量必須大於 0。");
            return false;
        }

        stocks[id] += quantity;
        System.out.printf("庫存補充成功！商品 %s 最新庫存為：%d\n", names[id], stocks[id]);
        return true;
    }

    public static void printLowStock(String[] names, int[] prices, int[] stocks) {
        System.out.println("\n=== 低庫存商品警告 (庫存 < 10) ===");
        System.out.println("編號\t商品名稱\t\t價格\t庫存");
        System.out.println("----------------------------------------");
        boolean hasLowStock = false;
        for (int i = 0; i < names.length; i++) {
            if (stocks[i] < 10) {
                System.out.printf("%d\t%-15s\t%d\t%d\n", i, names[i], prices[i], stocks[i]);
                hasLowStock = true;
            }
        }
        if (!hasLowStock) {
            System.out.println("目前所有商品庫存皆充足。");
        }
    }

    public static void printTotalValue(int[] prices, int[] stocks) {
        int totalValue = 0;
        for (int i = 0; i < prices.length; i++) {
            totalValue += prices[i] * stocks[i];
        }
        System.out.println("\n----------------------------------------");
        System.out.printf("目前倉庫內所有商品的庫存總價值為：%d 元\n", totalValue);
        System.out.println("----------------------------------------");
    }
}