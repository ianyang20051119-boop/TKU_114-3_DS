public class TaskLinkedList {

    private TaskNode head;
    private int size;

    public boolean addFirst(String code, String description) {

        if (find(code) != null) {
            return false;
        }

        TaskNode newNode = new TaskNode(code, description);
        newNode.next = head;
        head = newNode;
        size++;

        return true;
    }

    public boolean addLast(String code, String description) {

        if (find(code) != null) {
            return false;
        }

        TaskNode newNode = new TaskNode(code, description);

        if (head == null) {
            head = newNode;
            size++;
            return true;
        }

        TaskNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        size++;

        return true;
    }

    public TaskNode find(String code) {

        TaskNode current = head;

        while (current != null) {
            if (current.code.equalsIgnoreCase(code)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    public boolean completeTask(String code) {

        TaskNode task = find(code);

        if (task == null) {
            return false;
        }

        task.completed = true;
        return true;
    }

    public boolean remove(String code) {

        if (head == null) {
            return false;
        }

        if (head.code.equalsIgnoreCase(code)) {
            head = head.next;
            size--;
            return true;
        }

        TaskNode current = head;

        while (current.next != null) {

            if (current.next.code.equalsIgnoreCase(code)) {
                current.next = current.next.next;
                size--;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void showUnfinished() {

        if (head == null) {
            System.out.println("目前沒有工作");
            return;
        }

        TaskNode current = head;
        boolean found = false;

        while (current != null) {

            if (!current.completed) {
                System.out.println(current.code + " " + current.description);
                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("沒有未完成工作");
        }
    }

    public int getSize() {
        return size;
    }

    public int getUnfinishedCount() {

        int count = 0;

        TaskNode current = head;

        while (current != null) {

            if (!current.completed) {
                count++;
            }

            current = current.next;
        }

        return count;
    }
}