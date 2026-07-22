public class NumberHistoryList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Node head = null;

        System.out.println("=== 操作1：空串列 ===");
        printList(head);
        printStatistics(head);

        System.out.println("\n=== 操作2：前端新增10 ===");
        head = addFirst(head, 10);
        printList(head);

        System.out.println("\n=== 操作3：尾端新增20 ===");
        head = addLast(head, 20);
        printList(head);

        System.out.println("\n=== 操作4：前端新增5 ===");
        head = addFirst(head, 5);
        printList(head);

        System.out.println("\n=== 操作5：尾端新增30 ===");
        head = addLast(head, 30);
        printList(head);

        System.out.println("\n=== 操作6：搜尋20");
        System.out.println(contains(head, 20) ? "找到20" : "找不到20");

        System.out.println("\n=== 操作7：刪除10 ===");
        head = remove(head, 10);
        printList(head);

        System.out.println("\n=== 操作8：刪除100 ===");
        head = remove(head, 100);
        printList(head);

        System.out.println("\n=== 最終統計 ===");
        printStatistics(head);
    }

    public static Node addFirst(Node head, int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        return newNode;
    }

    public static Node addLast(Node head, int value) {
        Node newNode = new Node(value);

        if (head == null) {
            return newNode;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return head;
    }

    public static boolean contains(Node head, int value) {
        Node current = head;

        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public static Node remove(Node head, int value) {

        if (head == null) {
            System.out.println("空串列！");
            return null;
        }

        if (head.data == value) {
            return head.next;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }

        System.out.println("找不到資料：" + value);
        return head;
    }

    public static void printList(Node head) {

        if (head == null) {
            System.out.println("串列為空");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void printStatistics(Node head) {

        if (head == null) {
            System.out.println("Size：0");
            System.out.println("總和：0");
            System.out.println("最大值：無");
            System.out.println("最小值：無");
            return;
        }

        int size = 0;
        int sum = 0;
        int max = head.data;
        int min = head.data;

        Node current = head;

        while (current != null) {
            size++;
            sum += current.data;

            if (current.data > max) {
                max = current.data;
            }

            if (current.data < min) {
                min = current.data;
            }

            current = current.next;
        }

        System.out.println("Size：" + size);
        System.out.println("總和：" + sum);
        System.out.println("最大值：" + max);
        System.out.println("最小值：" + min);
    }
}