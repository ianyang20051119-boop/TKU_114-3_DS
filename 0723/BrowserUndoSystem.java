import java.util.Stack;

public class BrowserUndoSystem {

    public static void main(String[] args) {

        Stack<String> history = new Stack<>();
        String currentPage = null;

        System.out.println("=== 操作1：查看目前頁面 ===");
        showCurrentPage(currentPage);

        System.out.println("\n=== 操作2：開啟 Google ===");
        currentPage = openPage(history, currentPage, "Google");
        showCurrentPage(currentPage);

        System.out.println("\n=== 操作3：開啟 YouTube ===");
        currentPage = openPage(history, currentPage, "YouTube");
        showCurrentPage(currentPage);

        System.out.println("\n=== 操作4：開啟 GitHub ===");
        currentPage = openPage(history, currentPage, "GitHub");
        showCurrentPage(currentPage);

        System.out.println("\n=== 操作5：返回上一頁 ===");
        currentPage = goBack(history, currentPage);
        showCurrentPage(currentPage);

        System.out.println("\n=== 操作6：開啟 ChatGPT ===");
        currentPage = openPage(history, currentPage, "ChatGPT");
        showCurrentPage(currentPage);

        System.out.println("\n=== 操作7：返回上一頁 ===");
        currentPage = goBack(history, currentPage);
        showCurrentPage(currentPage);

        System.out.println("\n=== 操作8：返回上一頁 ===");
        currentPage = goBack(history, currentPage);
        showCurrentPage(currentPage);

        System.out.println("\n=== 操作9：返回上一頁 ===");
        currentPage = goBack(history, currentPage);
        showCurrentPage(currentPage);

        System.out.println("\n=== 操作10：返回上一頁 ===");
        currentPage = goBack(history, currentPage);
        showCurrentPage(currentPage);
    }

    public static String openPage(Stack<String> history, String currentPage, String newPage) {

        if (currentPage != null) {
            history.push(currentPage);
        }

        System.out.println("開啟：" + newPage);
        return newPage;
    }

    public static String goBack(Stack<String> history, String currentPage) {

        if (history.isEmpty()) {
            System.out.println("沒有上一頁！");
            return currentPage;
        }

        String previousPage = history.pop();
        System.out.println("返回：" + previousPage);
        return previousPage;
    }

    public static void showCurrentPage(String currentPage) {

        if (currentPage == null) {
            System.out.println("目前沒有開啟任何頁面。");
        } else {
            System.out.println("目前頁面：" + currentPage);
        }
    }
}