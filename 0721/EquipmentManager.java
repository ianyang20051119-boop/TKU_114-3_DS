import java.util.ArrayList;
import java.util.Scanner;

public class EquipmentManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Equipment> equipments = new ArrayList<>();

        int choice = 0;

        do {
            System.out.println("\n===== 設備管理系統 =====");
            System.out.println("1. 新增設備");
            System.out.println("2. 依代碼搜尋");
            System.out.println("3. 借出設備");
            System.out.println("4. 歸還設備");
            System.out.println("5. 列出可借設備");
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
                    System.out.print("設備代碼：");
                    String code = sc.nextLine().trim();

                    System.out.print("設備名稱：");
                    String name = sc.nextLine().trim();

                    if (code.isEmpty() || name.isEmpty()) {
                        System.out.println("代碼與名稱不得為空白！");
                        break;
                    }

                    if (findEquipment(equipments, code) != null) {
                        System.out.println("代碼不可重複！");
                        break;
                    }

                    equipments.add(new Equipment(code, name));
                    System.out.println("新增成功！");
                    break;

                case 2:
                    System.out.print("請輸入設備代碼：");
                    code = sc.nextLine().trim();

                    Equipment equipment = findEquipment(equipments, code);

                    if (equipment == null) {
                        System.out.println("找不到設備！");
                    } else {
                        System.out.println(equipment);
                    }
                    break;

                case 3:
                    System.out.print("請輸入設備代碼：");
                    code = sc.nextLine().trim();

                    equipment = findEquipment(equipments, code);

                    if (equipment == null) {
                        System.out.println("找不到設備！");
                    } else if (equipment.borrow()) {
                        System.out.println("借出成功！");
                    } else {
                        System.out.println("設備已借出！");
                    }
                    break;

                case 4:
                    System.out.print("請輸入設備代碼：");
                    code = sc.nextLine().trim();

                    equipment = findEquipment(equipments, code);

                    if (equipment == null) {
                        System.out.println("找不到設備！");
                    } else if (equipment.giveBack()) {
                        System.out.println("歸還成功！");
                    } else {
                        System.out.println("設備本來就是可借用狀態！");
                    }
                    break;

                case 5:
                    boolean found = false;

                    System.out.println("===== 可借設備 =====");

                    for (Equipment e : equipments) {
                        if (e.isAvailable()) {
                            System.out.println(e);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("目前沒有可借設備。");
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

    public static Equipment findEquipment(ArrayList<Equipment> equipments, String code) {
        for (Equipment e : equipments) {
            if (e.getCode().equalsIgnoreCase(code)) {
                return e;
            }
        }
        return null;
    }
}