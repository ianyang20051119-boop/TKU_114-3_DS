import java.util.ArrayList;
import java.util.Scanner;

public class NameListManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        int choice=0;

        do {
            System.out.println("\n===== 姓名管理系統 =====");
            System.out.println("1. 新增姓名");
            System.out.println("2. 搜尋姓名");
            System.out.println("3. 修改姓名");
            System.out.println("4. 刪除姓名");
            System.out.println("5. 列出全部姓名");
            System.out.println("6. 結束");
            System.out.print("請輸入選項：");

            if (!sc.hasNextInt()) {
                System.out.println("請輸入1~6！");
                sc.next();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("請輸入姓名：");
                    String newName = sc.nextLine().trim();

                    if (newName.isEmpty()) {
                        System.out.println("姓名不得為空白！");
                    } else {
                        names.add(newName);
                        System.out.println("新增成功！");
                    }
                    break;

                case 2:
                    System.out.print("請輸入要搜尋的姓名：");
                    String searchName = sc.nextLine().trim();

                    int index = findName(names, searchName);

                    if (index != -1) {
                        System.out.println("找到：" + names.get(index));
                    } else {
                        System.out.println("找不到此姓名！");
                    }
                    break;

                case 3:
                    System.out.print("請輸入要修改的姓名：");
                    String oldName = sc.nextLine().trim();

                    int modifyIndex = findName(names, oldName);

                    if (modifyIndex == -1) {
                        System.out.println("找不到此姓名！");
                    } else {
                        System.out.print("請輸入新姓名：");
                        String newValue = sc.nextLine().trim();

                        if (newValue.isEmpty()) {
                            System.out.println("姓名不得為空白！");
                        } else {
                            names.set(modifyIndex, newValue);
                            System.out.println("修改成功！");
                        }
                    }
                    break;

                case 4:
                    System.out.print("請輸入要刪除的姓名：");
                    String deleteName = sc.nextLine().trim();

                    int deleteIndex = findName(names, deleteName);

                    if (deleteIndex == -1) {
                        System.out.println("找不到此姓名！");
                    } else {
                        names.remove(deleteIndex);
                        System.out.println("刪除成功！");
                    }
                    break;

                case 5:
                    if (names.isEmpty()) {
                        System.out.println("目前沒有任何姓名。");
                    } else {
                        System.out.println("===== 全部姓名 =====");
                        for (int i = 0; i < names.size(); i++) {
                            System.out.println((i + 1) + ". " + names.get(i));
                        }
                    }
                    break;

                case 6:
                    System.out.println("程式結束！");
                    break;

                default:
                    System.out.println("請輸入1~6！");
            }

        } while (choice != 6);

        sc.close();
    }

    public static int findName(ArrayList<String> names, String target) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }
}