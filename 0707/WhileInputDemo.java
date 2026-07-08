import java.util.Scanner;

public class WhileInputDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        System.out.println("Enter numbers (0 to stop):");

        while (true) {
            number = scanner.nextInt();

            if (number == 0) {
                break;
            }

            System.out.println("You entered: " + number);
        }

        scanner.close();   // 關閉 Scanner
        System.out.println("Input stopped.");
    }
}