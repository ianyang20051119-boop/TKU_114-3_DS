import java.util.*;

public class ClinicQueueSystem {

    private Queue<Patient> queue;
    private Set<String> numbers;
    private int serviceCount;

    public ClinicQueueSystem() {
        queue = new LinkedList<>();
        numbers = new HashSet<>();
        serviceCount = 0;
    }

    public boolean register(Patient patient) {
        if (numbers.contains(patient.getNumber())) {
            System.out.println("號碼重複，無法掛號：" + patient.getNumber());
            return false;
        }

        queue.offer(patient);
        numbers.add(patient.getNumber());
        System.out.println("掛號成功：" + patient);
        return true;
    }

    public Patient callNext() {
        if (queue.isEmpty()) {
            System.out.println("目前沒有等待病患");
            return null;
        }

        Patient patient = queue.poll();
        numbers.remove(patient.getNumber());
        serviceCount++;

        System.out.println("叫號：" + patient);
        return patient;
    }

    public Patient peekNext() {
        if (queue.isEmpty()) {
            System.out.println("目前沒有等待病患");
            return null;
        }

        return queue.peek();
    }

    public void showWaitingList() {
        if (queue.isEmpty()) {
            System.out.println("等待清單為空");
            return;
        }

        System.out.println("目前等待清單：");

        for (Patient patient : queue) {
            System.out.println(patient);
        }
    }

    public void showDepartmentCount() {
        Map<String, Integer> count = new HashMap<>();

        for (Patient patient : queue) {
            String dept = patient.getDepartment();

            count.put(dept, count.getOrDefault(dept, 0) + 1);
        }

        System.out.println("各科別等待人數：");

        for (String dept : count.keySet()) {
            System.out.println(dept + "：" + count.get(dept) + " 人");
        }

        System.out.println("總服務人數：" + serviceCount);
    }


    public static void main(String[] args) {

        ClinicQueueSystem clinic = new ClinicQueueSystem();

        clinic.register(new Patient("001", "王小明", "內科"));
        clinic.register(new Patient("002", "李小華", "外科"));
        clinic.register(new Patient("003", "陳美玲", "內科"));

        clinic.register(new Patient("001", "測試", "牙科"));

        System.out.println();

        clinic.showWaitingList();

        System.out.println();

        System.out.println("下一位：");
        System.out.println(clinic.peekNext());

        System.out.println();

        clinic.callNext();
        clinic.callNext();

        System.out.println();

        clinic.showWaitingList();

        System.out.println();

        clinic.showDepartmentCount();

        System.out.println();

        clinic.callNext();
        clinic.callNext();
    }
}