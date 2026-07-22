public class BuildLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        Node head = null;

        if (head == null) {
            System.out.println("目前是空串列。");
        }

        head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        head.next = second;
        second.next = third;
        third.next = fourth;

        System.out.println("串列內容：");

        Node current = head;
        int count = 0;
        int sum = 0;

        while (current != null) {
            System.out.println(current.data);
            count++;
            sum += current.data;
            current = current.next;
        }

        System.out.println("節點數：" + count);
        System.out.println("總和：" + sum);

        int target = 50;
        current = head;
        boolean found = false;

        while (current != null) {
            if (current.data == target) {
                found = true;
                break;
            }
            current = current.next;
        }

        if (found) {
            System.out.println(target + " 找到了。");
        } else {
            System.out.println(target + " 找不到資料。");
        }
    }
}