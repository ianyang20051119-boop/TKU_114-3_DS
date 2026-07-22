public class LinkedListReverse {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Node empty = null;

        System.out.println("空串列：");
        printList(empty);

        empty = reverse(empty);
        System.out.println("反轉後：");
        printList(empty);

        Node single = new Node(10);

        System.out.println("\n單一節點：");
        printList(single);

        single = reverse(single);
        System.out.println("反轉後：");
        printList(single);

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println("\n多節點：");
        printList(head);

        head = reverse(head);

        System.out.println("反轉後：");
        printList(head);

        if (contains(head, 30)) {
            System.out.println("找到資料：30");
        } else {
            System.out.println("找不到資料：30");
        }

        if (contains(head, 50)) {
            System.out.println("找到資料：50");
        } else {
            System.out.println("找不到資料：50");
        }
    }

    public static Node reverse(Node head) {

        Node previous = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public static boolean contains(Node head, int value) {

        if (head == null) {
            System.out.println("空串列！");
            return false;
        }

        Node current = head;

        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }

        return false;
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