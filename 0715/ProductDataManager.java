import java.util.Scanner;

/*
================================================================================
【測試案例與預期結果紀錄】

測試案例 1：完整名稱搜尋 - 成功
- 輸入關鍵字： "Keyboard"
- 預期結果：成功找到 1 筆：Keyboard | 價格: 890 | 庫存: 12

測試案例 2：部分名稱搜尋 - 成功多筆
- 輸入關鍵字： "u"
- 預期結果：成功找到 2 筆：Mouse (庫存 20) 與 USB Cable (庫存 30)

測試案例 3：部分名稱搜尋 - 查無此商品
- 輸入關鍵字： "Laptop"
- 預期結果：顯示「找不到包含關鍵字 'Laptop' 的商品。」

測試案例 4：顯示低庫存與庫存總價值
- 選擇功能：5 與 6
- 預期結果：
  - 低庫存 (庫存 < 10) 商品顯示：Monitor (5個), Headset (8個)。
  - 總價值顯示：(890*12) + (490*20) + (5200*5) + (250*30) + (1290*8) = 64,220 元。

測試案例 5：新增商品 - 成功格式
- 輸入文字： "Speaker,1500,15"
- 預期結果：顯示「新商品新增成功！」，且選擇「1. 顯示全部商品」時會看到第 6 筆 Speaker。

測試案例 6：新增商品 - 格式錯誤 (欄位不足)
- 輸入文字： "Speaker,1500"
- 預期結果：顯示「新增失敗：格式錯誤，必須包含名稱、價格、庫存並以逗號隔開。」且程式繼續運行。

測試案例 7：新增商品 - 數字轉換錯誤 (非整數)
- 輸入文字： "Speaker,abc,15" 或 "Speaker,1500,ten"
- 預期結果：捕捉到 NumberFormatException，顯示「新增失敗：價格或庫存必須為整數數字。」且程式繼續運行。

測試案例 8：新增商品 - 數值邏輯錯誤 (小於 0)
- 輸入文字： "Speaker,-100,15"
- 預期結果：顯示「新增失敗：價格與庫存不得小於 0。」且程式繼續運行。
================================================================================
*/

public class ProductDataManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] records = {
            "Keyboard,890,12",
            "Mouse,490,20",
            "Monitor,5200,5",
            "USB Cable,250,30",
            "Headset,1290,8"
        };

        int currentCount = records.length;
        String[] names = new String[currentCount + 1];
        int[] prices = new int[currentCount + 1];
        int[] stocks = new int[currentCount + 1];

        for (int i = 0; i < currentCount; i++) {
            String[] data = records[i].split(",");
            names[i] = data[0];
            prices[i] = Integer.parseInt(data[1]);
            stocks[i] = Integer.parseInt(data[2]);
        }

        while (true) {
            System.out.println("\n===== 商品數據管理系統 =====");
            System.out.println("1. 顯示全部商品");
            System.out.println("2. 完整名稱搜尋");
            System.out.println("3. 部分名稱搜尋");
            System.out.println("4. 新增一筆商品資料");
            System.out.println("5. 顯示低庫存商品");
            System.out.println("6. 顯示庫存總價值");
            System.out.println("7. 結束程式");
            System.out.print("請輸入操作選項 (1-7): ");

            if (!sc.hasNextInt()) {
                System.out.println("輸入錯誤！請輸入有效數字。");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 7) {
                System.out.println("系統已結束，謝謝使用！");
                break;
            }

            switch (choice) {
                case 1:
                    printAllProducts(names, prices, stocks, currentCount);
                    break;
                case 2:
                    exactSearch(sc, names, prices, stocks, currentCount);
                    break;
                case 3:
                    partialSearch(sc, names, prices, stocks, currentCount);
                    break;
                case 4:
                    if (currentCount >= names.length) {
                        System.out.println("系統容量已達上限，無法再新增商品。");
                    } else {
                        if (addNewProduct(sc, names, prices, stocks, currentCount)) {
                            currentCount++;
                        }
                    }
                    break;
                case 5:
                    printLowStock(names, prices, stocks, currentCount);
                    break;
                case 6:
                    printTotalValue(prices, stocks, currentCount);
                    break;
                default:
                    System.out.println("無此選項，請輸入 1 到 7 之間的數字。");
            }
        }
        sc.close();
    }

    public static void printAllProducts(String[] names, int[] prices, int[] stocks, int count) {
        System.out.println("\n編號\t商品名稱\t\t價格\t庫存");
        System.out.println("----------------------------------------");
        for (int i = 0; i < count; i++) {
            System.out.printf("%d\t%-15s\t%d\t%d\n", i, names[i], prices[i], stocks[i]);
        }
    }

    public static void exactSearch(Scanner sc, String[] names, int[] prices, int[] stocks, int count) {
        System.out.print("請輸入要精準搜尋的商品完整名稱：");
        String keyword = sc.nextLine().trim();
        boolean found = false;

        System.out.println("\n--- 完整搜尋結果 ---");
        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(keyword)) {
                System.out.printf("編號: %d | 商品名稱: %s | 價格: %d | 庫存: %d\n", i, names[i], prices[i], stocks[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("找不到符合該名稱的商品。");
        }
    }

    public static void partialSearch(Scanner sc, String[] names, int[] prices, int[] stocks, int count) {
        System.out.print("請輸入要模糊搜尋的商品關鍵字：");
        String keyword = sc.nextLine().trim().toLowerCase();
        boolean found = false;

        System.out.println("\n--- 部分搜尋結果 ---");
        for (int i = 0; i < count; i++) {
            if (names[i].toLowerCase().contains(keyword)) {
                System.out.printf("編號: %d | 商品名稱: %s | 價格: %d | 庫存: %d\n", i, names[i], prices[i], stocks[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.printf("找不到包含關鍵字 '%s' 的商品。\n", keyword);
        }
    }

    public static boolean addNewProduct(Scanner sc, String[] names, int[] prices, int[] stocks, int count) {
        System.out.print("請輸入新商品資料 (格式：名稱,價格,庫存)：");
        String input = sc.nextLine();

        try {
            if (input == null || input.trim().isEmpty()) {
                throw new IllegalArgumentException("輸入內容不可為空。");
            }

            String[] parts = input.split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException("格式錯誤，必須包含名稱、價格、庫存並以逗號隔開。");
            }

            String name = parts[0].trim();
            if (name.isEmpty()) {
                throw new IllegalArgumentException("商品名稱不可為空。");
            }

            int price = Integer.parseInt(parts[1].trim());
            int stock = Integer.parseInt(parts[2].trim());

            if (price < 0 || stock < 0) {
                throw new IllegalArgumentException("價格與庫存不得小於 0。");
            }

            names[count] = name;
            prices[count] = price;
            stocks[count] = stock;

            System.out.println("新商品新增成功！");
            return true;

        } catch (NumberFormatException e) {
            System.out.println("新增失敗：價格或庫存必須為整數數字。");
        } catch (IllegalArgumentException e) {
            System.out.println("新增失敗：" + e.getMessage());
        }
        return false;
    }

    public static void printLowStock(String[] names, int[] prices, int[] stocks, int count) {
        System.out.println("\n=== 低庫存商品 (庫存 < 10) ===");
        boolean hasLowStock = false;
        for (int i = 0; i < count; i++) {
            if (stocks[i] < 10) {
                System.out.printf("商品: %-15s | 庫存: %d\n", names[i], stocks[i]);
                hasLowStock = true;
            }
        }
        if (!hasLowStock) {
            System.out.println("目前所有商品庫存充足。");
        }
    }

    public static void printTotalValue(int[] prices, int[] stocks, int count) {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i] * stocks[i];
        }
        System.out.printf("\n當前所有商品庫存總價值為：%d 元\n", total);
    }
}