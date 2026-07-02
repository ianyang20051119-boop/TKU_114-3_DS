import java.util.Scanner;

public class ScoreReport {
    public static void main(String[] var0) {
        Scanner var1 = new Scanner(System.in);

        // 讀取學生姓名
        System.out.print("請輸入姓名：");
        String var2 = var1.nextLine();

        System.out.print("請輸入 Java 成績：");
        int var3 = var1.nextInt();

        System.out.print("請輸入 English 成績：");
        int var4 = var1.nextInt();
        
        System.out.print("請輸入 Math 成績：");
        int var6 = var1.nextInt();
       
        // 計算三科平均，使用 3.0 保留小數結果
        double average = (var3 + var4 + var6) / 3.0;

        System.out.println();
        System.out.println("=== 成績報表 ===");
        System.out.println("姓名: " + var2);
        System.out.println("Java: " + var3);
        System.out.println("English: " + var4);
        System.out.println("Math: " + var6);
        System.out.println("平均: " + average);
        var1.close();
    }
}