import java.util.Scanner;

public class GradeStatistics {

    // 檢查成績是否合法
    public static boolean isValidScore(int score) {
        return score >= 0 && score <= 100;
    }

    // 判斷是否及格
    public static boolean isPassing(int score) {
        return score >= 60;
    }

    // 根據平均分數回傳等第
    public static String getGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // 印出統計結果
    public static void printSummary(int count, int total, double average,
                                    int max, int min,
                                    int passCount, int failCount,
                                    String grade) {

        System.out.println();
        System.out.println("=== Grade Summary ===");
        System.out.println("Count: " + count);
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Pass count: " + passCount);
        System.out.println("Fail count: " + failCount);
        System.out.println("Average grade: " + grade);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int score;
        int count = 0;
        int total = 0;
        int max = 0;
        int min = 100;
        int passCount = 0;
        int failCount = 0;

        while (true) {

            System.out.print("請輸入成績（輸入 -1 結束）：");
            score = sc.nextInt();

            if (score == -1) {
                break;
            }

            if (!isValidScore(score)) {
                System.out.println("成績必須介於 0~100！");
                continue;
            }

            total += score;
            count++;

            if (score > max) {
                max = score;
            }

            if (score < min) {
                min = score;
            }

            if (isPassing(score)) {
                passCount++;
            } else {
                failCount++;
            }
        }

        if (count == 0) {
            System.out.println("No scores entered.");
        } else {
            double average = (double) total / count;
            String grade = getGrade(average);

            printSummary(count, total, average, max, min,
                         passCount, failCount, grade);
        }

        sc.close();
    }
}