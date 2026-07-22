public class TaskNode {
    String code;
    String description;
    boolean completed;
    TaskNode next;

    public TaskNode(String code, String description) {
        this.code = code.trim();
        this.description = description.trim();
        this.completed = false;
        this.next = null;
    }
}