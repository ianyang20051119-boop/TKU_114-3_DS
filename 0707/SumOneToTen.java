public class SumOneToTen {
    public static void main(String[] args) {
        int sum = 0; // 用來儲存加總結果的變數

        // 使用 for 迴圈從 1 加到 10
        for (int i = 1; i <= 10; i++) {
            sum += i; // 等同於 sum = sum + i;
        }

        // 輸出預期結果
        System.out.println("Sum: " + sum);
    }
}