import java.util.Scanner;

public class QuantityValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入商品數量：");
        int score = sc.nextInt();

        while (score < 0 || score == 0) {
            System.out.print("數量不合法，請重新輸入）：");
            score = sc.nextInt();
        }

        System.out.println("商品數量: " + score);

        sc.close();
    }
}