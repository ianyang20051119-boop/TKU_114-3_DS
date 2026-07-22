import java.util.*;

public class DeliveryProcessingSystem {

    private Queue<DeliveryTask> waitingQueue;
    private Stack<DeliveryTask> completedStack;

    public DeliveryProcessingSystem() {
        waitingQueue = new LinkedList<>();
        completedStack = new Stack<>();
    }


    // 新增配送工作
    public void addTask(DeliveryTask task) {
        waitingQueue.offer(task);
        System.out.println("新增配送：" + task);
    }


    // 完成下一筆配送
    public DeliveryTask completeNextTask() {

        if (waitingQueue.isEmpty()) {
            System.out.println("目前沒有待配送工作");
            return null;
        }

        DeliveryTask task = waitingQueue.poll();
        completedStack.push(task);

        System.out.println("完成配送：" + task);

        return task;
    }


    // 查看下一筆配送
    public DeliveryTask peekNextTask() {

        if (waitingQueue.isEmpty()) {
            System.out.println("目前沒有待配送工作");
            return null;
        }

        return waitingQueue.peek();
    }


    // 復原最近完成
    public DeliveryTask undoComplete() {

        if (completedStack.isEmpty()) {
            System.out.println("沒有完成紀錄可復原");
            return null;
        }

        DeliveryTask task = completedStack.pop();

        // 回到 Queue 尾端
        waitingQueue.offer(task);

        System.out.println("復原配送：" + task);

        return task;
    }


    // 顯示等待數與完成數
    public void showStatus() {

        System.out.println("等待配送數：" + waitingQueue.size());
        System.out.println("完成數：" + completedStack.size());

    }


    // 顯示所有完成紀錄
    public void showCompletedRecords() {

        if (completedStack.isEmpty()) {
            System.out.println("沒有完成紀錄");
            return;
        }

        System.out.println("所有處理紀錄：");

        for (DeliveryTask task : completedStack) {
            System.out.println(task);
        }
    }


    public static void main(String[] args) {

        DeliveryProcessingSystem system = new DeliveryProcessingSystem();


        system.addTask(
            new DeliveryTask("D001", "台北市", "文件")
        );

        system.addTask(
            new DeliveryTask("D002", "新北市", "包裹")
        );

        system.addTask(
            new DeliveryTask("D003", "桃園市", "食物")
        );


        System.out.println();

        System.out.println("下一筆：");
        System.out.println(system.peekNextTask());


        System.out.println();

        system.completeNextTask();
        system.completeNextTask();


        System.out.println();

        system.showStatus();


        System.out.println();

        system.undoComplete();


        System.out.println();

        system.showStatus();


        System.out.println();

        system.showCompletedRecords();


        System.out.println();

        system.completeNextTask();
        system.completeNextTask();
        system.completeNextTask();
    }
}