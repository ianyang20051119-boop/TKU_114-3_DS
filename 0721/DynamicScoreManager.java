import java.util.ArrayList;
import java.util.Scanner;

public class DynamicScoreManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();

        while (true) {
            System.out.print("請輸入成績(-1結束)：");

            if (!sc.hasNextInt()) {
                System.out.println("輸入錯誤，請輸入整數！");
                sc.next();
                continue;
            }

            int score = sc.nextInt();

            if (score == -1) {
                break;
            }

            if (score < 0 || score > 100) {
                System.out.println("成績必須介於0~100！");
                continue;
            }

            scores.add(score);
        }

        if (scores.isEmpty()) {
            System.out.println("沒有輸入任何成績。");
        } else {
            System.out.println("\n===== 成績統計 =====");
            System.out.println("筆數：" + scores.size());
            System.out.println("平均：" + calculateAverage(scores));
            System.out.println("最高：" + findMax(scores));
            System.out.println("最低：" + findMin(scores));

            System.out.println("\n===== 及格名單 =====");
            printPassedScores(scores);
        }

        sc.close();
    }

    public static double calculateAverage(ArrayList<Integer> scores) {
        int sum = 0;

        for (int score : scores) {
            sum += score;
        }

        return (double) sum / scores.size();
    }

    public static int findMax(ArrayList<Integer> scores) {
        int max = scores.get(0);

        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }

        return max;
    }

    public static int findMin(ArrayList<Integer> scores) {
        int min = scores.get(0);

        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }

        return min;
    }

    public static void printPassedScores(ArrayList<Integer> scores) {
        boolean found = false;

        for (int score : scores) {
            if (score >= 60) {
                System.out.println(score);
                found = true;
            }
        }

        if (!found) {
            System.out.println("沒有及格成績。");
        }
    }
}