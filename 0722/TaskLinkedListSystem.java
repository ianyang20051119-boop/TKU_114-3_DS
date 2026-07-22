import java.util.Scanner;

public class TaskLinkedListSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskLinkedList list = new TaskLinkedList();

        int choice = 0;

        do {

            System.out.println("\n===== 工作管理系統 =====");
            System.out.println("1. 新增緊急工作");
            System.out.println("2. 新增一般工作");
            System.out.println("3. 完成工作");
            System.out.println("4. 刪除工作");
            System.out.println("5. 列出未完成工作");
            System.out.println("6. 顯示統計");
            System.out.println("7. 結束");
            System.out.print("請輸入選項：");

            if (!sc.hasNextInt()) {
                System.out.println("請輸入1~7");
                sc.next();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("工作代碼：");
                    String code = sc.nextLine().trim();

                    System.out.print("工作說明：");
                    String desc = sc.nextLine().trim();

                    if (code.isEmpty() || desc.isEmpty()) {
                        System.out.println("不可空白");
                    } else if (list.addFirst(code, desc)) {
                        System.out.println("新增成功");
                    } else {
                        System.out.println("代碼不可重複");
                    }

                    break;

                case 2:

                    System.out.print("工作代碼：");
                    code = sc.nextLine().trim();

                    System.out.print("工作說明：");
                    desc = sc.nextLine().trim();

                    if (code.isEmpty() || desc.isEmpty()) {
                        System.out.println("不可空白");
                    } else if (list.addLast(code, desc)) {
                        System.out.println("新增成功");
                    } else {
                        System.out.println("代碼不可重複");
                    }

                    break;

                case 3:

                    System.out.print("請輸入工作代碼：");
                    code = sc.nextLine().trim();

                    if (list.completeTask(code)) {
                        System.out.println("工作已完成");
                    } else {
                        System.out.println("找不到工作");
                    }

                    break;

                case 4:

                    System.out.print("請輸入工作代碼：");
                    code = sc.nextLine().trim();

                    if (list.remove(code)) {
                        System.out.println("刪除成功");
                    } else {
                        System.out.println("找不到工作");
                    }

                    break;

                case 5:

                    list.showUnfinished();

                    break;

                case 6:

                    System.out.println("工作總數：" + list.getSize());
                    System.out.println("未完成數量：" + list.getUnfinishedCount());

                    break;

                case 7:

                    System.out.println("程式結束");
                    break;

                default:

                    System.out.println("請輸入1~7");
            }

        } while (choice != 7);

        sc.close();
    }
}