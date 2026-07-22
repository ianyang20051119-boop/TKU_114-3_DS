import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CounterServiceSystem {

    static class Customer {
        private int number;
        private String name;

        public Customer(int number, String name) {
            this.number = number;
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "號碼：" + number + " 姓名：" + name;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue<Customer> waitingQueue = new LinkedList<>();
        Queue<Customer> servedQueue = new LinkedList<>();

        int nextNumber = 1;
        int choice = 0;

        do {
            System.out.println("\n===== 櫃台叫號系統 =====");
            System.out.println("1. 取號");
            System.out.println("2. 叫號");
            System.out.println("3. 查看下一位");
            System.out.println("4. 等待人數");
            System.out.println("5. 處理紀錄");
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
                    String name = sc.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("姓名不可空白！");
                        break;
                    }

                    Customer customer = new Customer(nextNumber++, name);
                    waitingQueue.offer(customer);

                    System.out.println("取號成功：" + customer);

                    break;

                case 2:

                    if (waitingQueue.isEmpty()) {
                        System.out.println("目前沒有等待中的民眾！");
                    } else {
                        Customer served = waitingQueue.poll();
                        servedQueue.offer(served);
                        System.out.println("叫號：" + served);
                    }

                    break;

                case 3:

                    if (waitingQueue.isEmpty()) {
                        System.out.println("目前沒有等待中的民眾！");
                    } else {
                        System.out.println("下一位：" + waitingQueue.peek());
                    }

                    break;

                case 4:

                    System.out.println("等待人數：" + waitingQueue.size());

                    break;

                case 5:

                    if (servedQueue.isEmpty()) {
                        System.out.println("目前沒有處理紀錄。");
                    } else {
                        System.out.println("===== 處理紀錄 =====");

                        for (Customer c : servedQueue) {
                            System.out.println(c);
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
}