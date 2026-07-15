import java.util.Scanner;

public class ArrayStatistics {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = readCount(sc);
        int[] scores = new int[count];

        inputScores(sc, scores);

        System.out.println("\n=== 成績統計結果 ===");
        printScores(scores);

        int total = calculateTotal(scores);
        double average = (double) total / scores.length;
        int max = findMax(scores);
        int min = findMin(scores);

        System.out.println("--------------------");
        System.out.printf("總分：%d 分\n", total);
        System.out.printf("平均：%.2f 分\n", average);
        System.out.printf("最高分：%d 分\n", max);
        System.out.printf("最低分：%d 分\n", min);

        int passCount = countPass(scores);
        int failCount = scores.length - passCount;
        System.out.printf("及格人數：%d 人\n", passCount);
        System.out.printf("不及格人數：%d 人\n", failCount);
        System.out.println("--------------------");

        System.out.print("請輸入要搜尋的目標成績：");
        while (!sc.hasNextInt()) {
            System.out.print("輸入錯誤！請輸入整數成績：");
            sc.next();
        }
        int target = sc.nextInt();
        
        int index = findIndex(scores, target);
        if (index != -1) {
            System.out.printf("成績 %d 第一次出現的索引位置（Index）為：%d\n", target, index);
        } else {
            System.out.printf("找不到成績 %d 的資料。\n", target);
        }

        sc.close();
        System.out.println("====================");
    }

    public static int readCount(Scanner sc) {
        int count = 0;
        while (true) {
            System.out.print("請輸入資料筆數 (1-50)：");
            if (sc.hasNextInt()) {
                count = sc.nextInt();
                if (count >= 1 && count <= 50) {
                    break;
                }
            } else {
                sc.next();
            }
            System.out.println("輸入錯誤！筆數必須介於 1 到 50 之間，請重新輸入。");
        }
        return count;
    }

    public static void inputScores(Scanner sc, int[] scores) {
        System.out.println("\n請開始輸入每位學生的成績 (0-100)：");
        for (int i = 0; i < scores.length; i++) {
            while (true) {
                System.out.printf("請輸入第 %d 筆成績: ", i + 1);
                if (sc.hasNextInt()) {
                    int score = sc.nextInt();
                    if (score >= 0 && score <= 100) {
                        scores[i] = score;
                        break;
                    }
                } else {
                    sc.next();
                }
                System.out.println("輸入錯誤！成績必須介於 0 到 100 之間，請重新輸入。");
            }
        }
    }

    public static int calculateTotal(int[] scores) {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }

    public static int findMax(int[] scores) {
        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }

    public static int findMin(int[] scores) {
        int min = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        return min;
    }

    public static int countPass(int[] scores) {
        int count = 0;
        for (int score : scores) {
            if (score >= 60) {
                count++;
            }
        }
        return count;
    }

    public static int findIndex(int[] scores, int target) {
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void printScores(int[] scores) {
        System.out.print("全部成績：[ ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i]);
            if (i < scores.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }
}