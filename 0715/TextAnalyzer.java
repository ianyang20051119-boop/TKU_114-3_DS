import java.util.Scanner;

public class TextAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = readValidInput(sc);

        System.out.println("\n=== 文本分析結果 ===");
        System.out.printf("原始字元數：%d\n", text.length());
        System.out.printf("Trim後字元數：%d\n", text.trim().length());

        String[] words = splitWords(text);
        System.out.printf("單字數量：%d\n", words.length);

        int vowelCount = countVowels(text);
        System.out.printf("母音 (a, e, i, o, u) 總數：%d\n", vowelCount);

        String longestWord = findLongestWord(words);
        System.out.printf("最長單字：%s (長度：%d)\n", longestWord, longestWord.length());

        System.out.print("\n請輸入欲查詢的搜尋關鍵字：");
        String keyword = sc.nextLine();
        int keywordCount = countKeyword(words, keyword);
        System.out.printf("關鍵字「%s」出現次數 (忽略大小寫)：%d 次\n", keyword, keywordCount);

        sc.close();
    }

    public static String readValidInput(Scanner sc) {
        String input;
        while (true) {
            System.out.print("請輸入一行文字：");
            input = sc.nextLine();
            if (input != null && !input.trim().isEmpty()) {
                break;
            }
            System.out.println("輸入錯誤！請勿輸入空字串或全空白文字。\n");
        }
        return input;
    }

    public static String[] splitWords(String text) {
        String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            return new String[0];
        }
        return trimmed.split("\\s+");
    }

    public static int countVowels(String text) {
        int count = 0;
        String lowerText = text.toLowerCase();
        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    public static String findLongestWord(String[] words) {
        if (words.length == 0) {
            return "";
        }
        String longest = words[0];
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
        }
        return longest;
    }

    public static int countKeyword(String[] words, String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return 0;
        }
        int count = 0;
        String lowerKeyword = keyword.trim().toLowerCase();
        for (String word : words) {
            if (word.toLowerCase().equals(lowerKeyword)) {
                count++;
            }
        }
        return count;
    }
}