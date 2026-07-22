import java.util.ArrayList;
import java.util.Scanner;

public class ContactBookSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();

        int choice = 0;

        do {
            System.out.println("\n===== 通訊錄管理系統 =====");
            System.out.println("1. 新增聯絡人");
            System.out.println("2. 搜尋聯絡人");
            System.out.println("3. 修改電話");
            System.out.println("4. 刪除聯絡人");
            System.out.println("5. 顯示完整清單");
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
                    addContact(sc, contacts);
                    break;

                case 2:
                    searchContact(sc, contacts);
                    break;

                case 3:
                    updatePhone(sc, contacts);
                    break;

                case 4:
                    deleteContact(sc, contacts);
                    break;

                case 5:
                    showAllContacts(contacts);
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

    public static void addContact(Scanner sc, ArrayList<Contact> contacts) {
        System.out.print("請輸入代碼：");
        String code = sc.nextLine().trim();

        if (findContact(contacts, code) != null) {
            System.out.println("代碼不可重複！");
            return;
        }

        System.out.print("請輸入姓名：");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("姓名不可空白！");
            return;
        }

        System.out.print("請輸入電話：");
        String phone = sc.nextLine().trim();

        System.out.print("請輸入Email：");
        String email = sc.nextLine().trim();

        contacts.add(new Contact(code, name, phone, email));
        System.out.println("新增成功！");
    }

    public static void searchContact(Scanner sc, ArrayList<Contact> contacts) {
        System.out.print("請輸入代碼：");
        String code = sc.nextLine().trim();

        Contact contact = findContact(contacts, code);

        if (contact == null) {
            System.out.println("找不到聯絡人！");
        } else {
            System.out.println(contact);
        }
    }

    public static void updatePhone(Scanner sc, ArrayList<Contact> contacts) {
        System.out.print("請輸入代碼：");
        String code = sc.nextLine().trim();

        Contact contact = findContact(contacts, code);

        if (contact == null) {
            System.out.println("找不到聯絡人！");
            return;
        }

        System.out.print("請輸入新電話：");
        String phone = sc.nextLine().trim();

        contact.setPhone(phone);
        System.out.println("修改成功！");
    }

    public static void deleteContact(Scanner sc, ArrayList<Contact> contacts) {
        System.out.print("請輸入代碼：");
        String code = sc.nextLine().trim();

        Contact contact = findContact(contacts, code);

        if (contact == null) {
            System.out.println("找不到聯絡人！");
        } else {
            contacts.remove(contact);
            System.out.println("刪除成功！");
        }
    }

    public static void showAllContacts(ArrayList<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("目前沒有聯絡人。");
            return;
        }

        System.out.println("===== 聯絡人清單 =====");

        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public static Contact findContact(ArrayList<Contact> contacts, String code) {
        for (Contact contact : contacts) {
            if (contact.getCode().equalsIgnoreCase(code)) {
                return contact;
            }
        }
        return null;
    }
}