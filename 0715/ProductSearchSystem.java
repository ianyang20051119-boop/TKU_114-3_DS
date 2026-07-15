import java.util.Scanner;

/*
================================================================================
【測試案例與預期結果紀錄】

測試案例 1：完整名稱搜尋 - 忽略大小寫與前後空白
- 輸入關鍵字： "   mOuSe  "
- 預期結果：成功找到 1 筆資料：商品名稱: Mouse, 價格: 490, 庫存: 20

測試案例 2：完整名稱搜尋 - 找不到商品
- 輸入關鍵字： "Keyboards" (多了 s)
- 預期結果：顯示「找不到符合完整名稱的商品。」

測試案例 3：部分名稱搜尋 - 找到多筆結果
- 輸入關鍵字： "o" (字母 o)
- 預期結果：成功找到 3 筆資料 (Keyboard, Mouse, Monitor)

測試案例 4：部分名稱搜尋 - 找不到結果
- 輸入關鍵字： "xyz"
- 預期結果：顯示「找不到含有關鍵字 'xyz' 的商品。」

測試案例 5：顯示商品名稱與搜尋關鍵字第一次出現的位置
- 輸入關鍵字： "o"
- 預期結果：
  - Keyboard 第一次出現 'o' 的索引位置：4
  - Mouse 第一次出現 'o' 的索引位置：1
  - Monitor 第一次出現 'o' 的索引位置：1

測試案例 6：空字串或全空白防呆驗證
- 輸入關鍵字： "" (直接按 Enter) 或 "   " (多個空白)
- 預期結果：系統提示「輸入錯誤！請勿輸入空字串或全空白。」並要求重新輸入。
================================================================================
*/

public class ProductSearchSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = {"Keyboard", "Mouse", "Monitor", "USB Cable", "Headset"};
        int[] prices = {890, 490, 5200, 250, 1290};
        int[] stocks = {12, 20, 5, 30, 8};

        while (true) {
            System.out.println("\n===== 商品搜尋系統 =====");
            System.out.println("1. 顯示全部商品");
            System.out.println("2. 完整名稱搜尋 (忽略大小寫與前後空白)");
            System.out.println("3. 部分名稱搜尋 (可顯示多筆結果)");
            System.out.println("4. 顯示名稱最長的商品");
            System.out.println("5. 顯示商品名稱與關鍵字首次出現位置");
            System.out.println("6. 結束程式");
            System.out.print("請輸入操作選項 (1-6): ");

            if (!sc.hasNextInt()) {
                System.out.println("輸入錯誤！請輸入有效數字。");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 6) {
                System.out.println("系統已結束，謝謝使用！");
                break;
            }

            switch (choice) {
                case 1:
                    printAllProducts(names, prices, stocks);
                    break;
                case 2:
                    exactSearch(sc, names, prices, stocks);
                    break;
                case 3:
                    partialSearch(sc, names, prices, stocks);
                    break;
                case 4:
                    printLongestProductName(names, prices, stocks);
                    break;
                case 5:
                    findKeywordIndex(sc, names);
                    break;
                default:
                    System.out.println("無此選項，請輸入 1 到 6 之間的數字。");
            }
        }
        sc.close();
    }

    public static String readValidInput(Scanner sc, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = sc.nextLine();
            if (input != null && !input.trim().isEmpty()) {
                break;
            }
            System.out.println("輸入錯誤！請勿輸入空字串或全空白。");
        }
        return input;
    }

    public static void printAllProducts(String[] names, int[] prices, int[] stocks) {
        System.out.println("\n編號\t商品名稱\t\t價格\t庫存");
        System.out.println("----------------------------------------");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%d\t%-15s\t%d\t%d\n", i, names[i], prices[i], stocks[i]);
        }
    }

    public static void exactSearch(Scanner sc, String[] names, int[] prices, int[] stocks) {
        String keyword = readValidInput(sc, "請輸入要完整搜尋的商品名稱：").trim().toLowerCase();
        boolean found = false;

        System.out.println("\n--- 完整搜尋結果 ---");
        for (int i = 0; i < names.length; i++) {
            if (names[i].toLowerCase().equals(keyword)) {
                System.out.printf("編號: %d | 商品名稱: %s | 價格: %d | 庫存: %d\n", i, names[i], prices[i], stocks[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("找不到符合完整名稱的商品。");
        }
    }

    public static void partialSearch(Scanner sc, String[] names, int[] prices, int[] stocks) {
        String keyword = readValidInput(sc, "請輸入要模糊搜尋的商品關鍵字：").trim().toLowerCase();
        boolean found = false;

        System.out.println("\n--- 部分搜尋結果 ---");
        for (int i = 0; i < names.length; i++) {
            if (names[i].toLowerCase().contains(keyword)) {
                System.out.printf("編號: %d | 商品名稱: %s | 價格: %d | 庫存: %d\n", i, names[i], prices[i], stocks[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.printf("找不到含有關鍵字 '%s' 的商品。\n", keyword);
        }
    }

    public static void printLongestProductName(String[] names, int[] prices, int[] stocks) {
        int longestIndex = 0;
        for (int i = 1; i < names.length; i++) {
            if (names[i].length() > names[longestIndex].length()) {
                longestIndex = i;
            }
        }
        System.out.println("\n--- 名稱最長的商品 ---");
        System.out.printf("商品名稱: %s (長度: %d)\n", names[longestIndex], names[longestIndex].length());
        System.out.printf("價格: %d 元 | 庫存: %d 個\n", prices[longestIndex], stocks[longestIndex]);
    }

    public static void findKeywordIndex(Scanner sc, String[] names) {
        String keyword = readValidInput(sc, "請輸入要查找定位的關鍵字 (區分大小寫)：");
        boolean foundAny = false;

        System.out.println("\n--- 關鍵字定位結果 ---");
        for (String name : names) {
            int index = name.indexOf(keyword);
            if (index != -1) {
                System.out.printf("商品名稱: %-15s | 關鍵字 '%s' 首次出現位置 (Index): %d\n", name, keyword, index);
                foundAny = true;
            }
        }
        if (!foundAny) {
            System.out.printf("所有商品名稱中皆未出現關鍵字 '%s'。\n", keyword);
        }
    }
}