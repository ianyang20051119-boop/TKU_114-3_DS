import java.util.Scanner;

/*
================================================================================
【偵錯與錯誤分析摘要】

1. 編譯錯誤：System.out.println 行尾遺漏分號。
   - 修正：補上分號。
   
2. 陣列越界：for 條件寫成 i <= scores.length 導致存取 scores[3] 溢出。
   - 修正：修改為 i < scores.length。
   
3. 字串比較：使用 == 比較字串記憶體位址，而非內容。
   - 修正：修改為 "exit".equals(command)。
   
4. 邏輯錯誤：整數相除 total / scores.length 導致小數點失真（變為 82.00）。
   - 修正：強制轉型為 (double) total / scores.length（變為 82.33）。
   
5. 緩衝區問題：sc.nextInt() 殘留換行符 \n，導致隨後的 sc.nextLine() 被直接跳過。
   - 修正：在讀取 age 後插入 sc.nextLine() 消耗換行符。

【中斷點變數監控值】
- 迴圈越界時：i = 3, scores.length = 3 (異常觸發)
- 除法計算時：total = 247, scores.length = 3, average = 82.33
- 讀取指令時：age = 20, command = "exit" (正常讀取)
================================================================================
*/

public class DebuggingChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = {80, 75, 92};
        int total = 0;

        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }

        double average = (double) total / scores.length;
        System.out.printf("平均：%.2f%n", average);

        System.out.print("請輸入年齡：");
        int age = sc.nextInt();
        sc.nextLine(); 

        System.out.print("請輸入指令：");
        String command = sc.nextLine();

        if ("exit".equals(command)) {
            System.out.println("系統結束，年齡：" + age);
        }

        sc.close();
    }
}