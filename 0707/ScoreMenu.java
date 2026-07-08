import java.util.Scanner;
    public class ScoreMenu {
        public static void main(String[] args) {
         
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入姓名：");
            String name = scanner.nextLine();
        System.out.print("輸入Java成績：");
            int javascore = scanner.nextInt();
        System.out.print("輸入英文成績：");
            int englishscore = scanner.nextInt();
        System.out.print("輸入數學成績：");
            int mathscore = scanner.nextInt();
        
            
        double average = (javascore + englishscore + mathscore) / 3.0;

        String status;
         if (average >= 60) {
            status = "及格";
         } else {
            status = "不及格";
         }
        
        String grade;
         if (average >= 90) {
             grade = "A";
         } else if (average >= 80) {
            grade = "B";
         } else if (average >= 70) {
            grade = "C";
         } else if (average >= 60) {
            grade = "D";
         } else {
            grade = "F";
         }

        int choice=-1;
         while (choice != 0) {
            System.out.println("===== Menu =====");
            System.out.println("1：顯示平均分數");
            System.out.println("2：顯示及格狀態");
            System.out.println("3：顯示等第");
            System.out.println("0：離開");
            System.out.print("請輸入選項：");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("姓名：" + name);
                    System.out.println("平均分數：" + average);
                    break;
                case 2:
                    System.out.println("姓名：" + name);
                    System.out.println("及格狀態：" + status);
                    break;
                case 3:
                    System.out.println("姓名：" + name);
                    System.out.println("等第：" + grade);
                    break;
                case 0:
                    System.out.println("離開程式");
                    break;
                default:
                    System.out.println("程式無效");
            }
            
         }

        scanner.close();



        }

    }

    

