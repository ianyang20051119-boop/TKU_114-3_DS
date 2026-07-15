import java.util.Scanner;

public class SalesMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] sales = new int[3][4];

        inputSales(sc, sales);
        System.out.println();

        printMatrix(sales);
        System.out.println();

        int[] productTotals = calculateProductTotals(sales);
        printProductTotals(productTotals);
        System.out.println();

        int[] dailyTotals = calculateDailyTotals(sales);
        printDailyTotals(dailyTotals);
        System.out.println();

        findBestSellingProduct(productTotals);

        sc.close();
    }

    public static void inputSales(Scanner sc, int[][] sales) {
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                while (true) {
                    System.out.printf("請輸入 商品 %d 在 第 %d 天 的銷售量 (>= 0): ", (i + 1), (j + 1));
                    if (sc.hasNextInt()) {
                        int amount = sc.nextInt();
                        if (amount >= 0) {
                            sales[i][j] = amount;
                            break;
                        }
                    } else {
                        sc.next();
                    }
                    System.out.println("輸入錯誤！銷售量不得小於 0 且必須為整數，請重新輸入。");
                }
            }
        }
    }

    public static void printMatrix(int[][] sales) {
        System.out.println("=== 銷售量統計表格 ===");
        System.out.println("\t第 1 天\t第 2 天\t第 3 天\t第 4 天");
        for (int i = 0; i < sales.length; i++) {
            System.out.printf("商品 %d\t", (i + 1));
            for (int j = 0; j < sales[i].length; j++) {
                System.out.print(sales[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[] calculateProductTotals(int[][] sales) {
        int[] productTotals = new int[sales.length];
        for (int i = 0; i < sales.length; i++) {
            int sum = 0;
            for (int j = 0; j < sales[i].length; j++) {
                sum += sales[i][j];
            }
            productTotals[i] = sum;
        }
        return productTotals;
    }

    public static void printProductTotals(int[] productTotals) {
        System.out.println("=== 各商品銷售總量 ===");
        for (int i = 0; i < productTotals.length; i++) {
            System.out.printf("商品 %d 總銷售量: %d\n", (i + 1), productTotals[i]);
        }
    }

    public static int[] calculateDailyTotals(int[][] sales) {
        int[] dailyTotals = new int[sales[0].length];
        for (int j = 0; j < sales[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < sales.length; i++) {
                sum += sales[i][j];
            }
            dailyTotals[j] = sum;
        }
        return dailyTotals;
    }

    public static void printDailyTotals(int[] dailyTotals) {
        System.out.println("=== 每日銷售總量 ===");
        for (int j = 0; j < dailyTotals.length; j++) {
            System.out.printf("第 %d 天全部商品總銷售量: %d\n", (j + 1), dailyTotals[j]);
        }
    }

    public static void findBestSellingProduct(int[] productTotals) {
        int maxIndex = 0;
        int maxSales = productTotals[0];
        for (int i = 1; i < productTotals.length; i++) {
            if (productTotals[i] > maxSales) {
                maxSales = productTotals[i];
                maxIndex = i;
            }
        }
        System.out.printf("總銷售量最高的商品是：商品 %d (總銷售量為 %d)\n", (maxIndex + 1), maxSales);
    }
}