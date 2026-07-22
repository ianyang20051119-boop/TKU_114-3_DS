import java.util.Scanner;

public class PlaylistSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PlaylistLinkedList playlist = new PlaylistLinkedList();

        int choice = 0;

        do {
            System.out.println("\n===== 播放清單 =====");
            System.out.println("1. 新增歌曲");
            System.out.println("2. 搜尋歌曲");
            System.out.println("3. 刪除歌曲");
            System.out.println("4. 顯示播放順序");
            System.out.println("5. 結束");
            System.out.print("請輸入選項：");

            if (!sc.hasNextInt()) {
                System.out.println("請輸入1~5");
                sc.next();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("歌曲代碼：");
                    String code = sc.nextLine().trim();

                    System.out.print("歌曲名稱：");
                    String name = sc.nextLine().trim();

                    if (code.isEmpty() || name.isEmpty()) {
                        System.out.println("代碼與名稱不可空白");
                    } else if (playlist.addLast(code, name)) {
                        System.out.println("新增成功");
                    } else {
                        System.out.println("歌曲代碼不可重複");
                    }

                    break;

                case 2:

                    System.out.print("請輸入歌曲代碼：");
                    code = sc.nextLine().trim();

                    PlaylistNode node = playlist.find(code);

                    if (node == null) {
                        System.out.println("找不到歌曲");
                    } else {
                        System.out.println(node.code + " - " + node.name);
                    }

                    break;

                case 3:

                    System.out.print("請輸入歌曲代碼：");
                    code = sc.nextLine().trim();

                    if (playlist.remove(code)) {
                        System.out.println("刪除成功");
                    } else {
                        System.out.println("找不到歌曲");
                    }

                    break;

                case 4:

                    playlist.printPlaylist();

                    break;

                case 5:

                    System.out.println("程式結束");
                    break;

                default:

                    System.out.println("請輸入1~5");
            }

        } while (choice != 5);

        sc.close();
    }
}