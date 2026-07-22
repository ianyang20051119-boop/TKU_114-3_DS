public class LinkedListSearchRemove {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Node head = null;

        head = addLast(head, 10);
        head = addLast(head, 20);
        head = addLast(head, 30);
        head = addLast(head, 40);

        System.out.println("原始串列：");
        printList(head);

        System.out.println("contains(20)：" + contains(head, 20));
        System.out.println("contains(50)：" + contains(head, 50));

        System.out.println("\n刪除 head(10)");
        head = removeValue(head, 10);
        printList(head);

        System.out.println("\n刪除中間(30)");
        head = removeValue(head, 30);
        printList(head);

        System.out.println("\n刪除最後(40)");
        head = removeValue(head, 40);
        printList(head);

        System.out.println("\n刪除不存在(100)");
        head = removeValue(head, 100);
        printList(head);

        System.out.println("\n刪除剩下的節點(20)");
        head = removeValue(head, 20);
        printList(head);

        System.out.println("\n空串列再次刪除");
        head = removeValue(head, 20);
        printList(head);
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

    public static Node removeValue(Node head, int value) {

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
}