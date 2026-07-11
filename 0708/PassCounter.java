public class PassCounter {
    public static void main(String[] args) {
        int[] scores = {80, 55, 70};
        int Count = 0;

        for (int score : scores) {
            if (score >= 60) {
                Count++;
            }
        }

        System.out.println("Pass count " +Count);
    }
}