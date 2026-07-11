public class PriceMaxMin {
    public static void main(String[] args) {
        int Price1 = 100;
        int Price2 = 200;
        int Price3 = 300;

        int max = Price1;
        int min = Price1;

        if (Price2 > max) {
            max = Price2;
        }

        if (Price3 > max) {
            max = Price3;
        }

        if (Price2 < min) {
            min = Price2;
        }

        if (Price3 < min) {
            min = Price3;
        }

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}
