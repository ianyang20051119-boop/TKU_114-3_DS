import java.util.Scanner;

public class ProductManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product[] products = new Product[10];

        products[0] = new Product("Apple", 30, 20);
        products[1] = new Product("Banana", 20, 15);
        products[2] = new Product("Milk", 80, 8);
        products[3] = new Product("Bread", 50, 5);
        products[4] = new Product("Egg", 10, 30);

        int count = 5;

        int searchCount = 0;
        int addCount = 0;
        int sellCount = 0;
        int restockCount = 0;
        int priceChangeCount = 0;

        int choice;

        do {
            System.out.println("\n===== 商品管理系統 =====");
            System.out.println("1. 顯示全部商品");
            System.out.println("2. 依完整名稱搜尋");
            System.out.println("3. 新增商品");
            System.out.println("4. 出售商品");
            System.out.println("5. 補充庫存");
            System.out.println("6. 修改商品價格");
            System.out.println("7. 顯示低庫存商品");
            System.out.println("8. 顯示全部庫存總價值");
            System.out.println("9. 結束");
            System.out.print("請輸入選項：");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("=== 商品列表 ===");
                    for (int i = 0; i < count; i++) {
                        System.out.println(products[i]);
                    }
                    break;

                case 2:
                    System.out.print("請輸入商品名稱：");
                    String searchName = sc.nextLine();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (products[i].getName().equals(searchName)) {
                            System.out.println(products[i]);
                            found = true;
                            searchCount++;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("找不到商品。");
                    }
                    break;

                case 3:
                    if (count == products.length) {
                        System.out.println("商品已滿，無法新增。");
                    } else {
                        System.out.print("商品名稱：");
                        String name = sc.nextLine();

                        System.out.print("價格：");
                        int price = sc.nextInt();

                        System.out.print("庫存：");
                        int stock = sc.nextInt();
                        sc.nextLine();

                        products[count] = new Product(name, price, stock);
                        count++;
                        addCount++;

                        System.out.println("新增成功。");
                    }
                    break;

                case 4:
                    System.out.print("商品名稱：");
                    String sellName = sc.nextLine();

                    boolean sold = false;

                    for (int i = 0; i < count; i++) {
                        if (products[i].getName().equals(sellName)) {
                            System.out.print("出售數量：");
                            int qty = sc.nextInt();
                            sc.nextLine();

                            if (products[i].sell(qty)) {
                                System.out.println("出售成功。");
                                sellCount++;
                            } else {
                                System.out.println("出售失敗。");
                            }
                            sold = true;
                            break;
                        }
                    }

                    if (!sold) {
                        System.out.println("找不到商品。");
                    }
                    break;

                case 5:
                    System.out.print("商品名稱：");
                    String restockName = sc.nextLine();

                    boolean restocked = false;

                    for (int i = 0; i < count; i++) {
                        if (products[i].getName().equals(restockName)) {
                            System.out.print("補貨數量：");
                            int qty = sc.nextInt();
                            sc.nextLine();

                            if (products[i].restock(qty)) {
                                System.out.println("補貨成功。");
                                restockCount++;
                            } else {
                                System.out.println("補貨失敗。");
                            }
                            restocked = true;
                            break;
                        }
                    }

                    if (!restocked) {
                        System.out.println("找不到商品。");
                    }
                    break;

                case 6:
                    System.out.print("商品名稱：");
                    String priceName = sc.nextLine();

                    boolean changed = false;

                    for (int i = 0; i < count; i++) {
                        if (products[i].getName().equals(priceName)) {
                            System.out.print("新價格：");
                            int newPrice = sc.nextInt();
                            sc.nextLine();

                            if (products[i].setPrice(newPrice)) {
                                System.out.println("修改成功。");
                                priceChangeCount++;
                            } else {
                                System.out.println("修改失敗。");
                            }
                            changed = true;
                            break;
                        }
                    }

                    if (!changed) {
                        System.out.println("找不到商品。");
                    }
                    break;

                case 7:
                    System.out.println("=== 低庫存商品 ===");
                    boolean low = false;

                    for (int i = 0; i < count; i++) {
                        if (products[i].isLowStock()) {
                            System.out.println(products[i]);
                            low = true;
                        }
                    }

                    if (!low) {
                        System.out.println("沒有低庫存商品。");
                    }
                    break;

                case 8:
                    long total = 0;

                    for (int i = 0; i < count; i++) {
                        total += products[i].getInventoryValue();
                    }

                    System.out.println("全部庫存總價值：" + total);
                    break;

                case 9:
                    System.out.println("===== 操作摘要 =====");
                    System.out.println("搜尋次數：" + searchCount);
                    System.out.println("新增商品：" + addCount);
                    System.out.println("出售商品：" + sellCount);
                    System.out.println("補充庫存：" + restockCount);
                    System.out.println("修改價格：" + priceChangeCount);
                    System.out.println("程式結束！");
                    break;

                default:
                    System.out.println("請輸入1~9。");
            }

        } while (choice != 9);

        sc.close();
    }
}