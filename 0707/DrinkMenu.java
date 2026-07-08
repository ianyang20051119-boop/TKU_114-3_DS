public class DrinkMenu {
    public static void main(String[] args) {
        int option = 2;

        switch (option) {
            case 1:
                System.out.println("black tea");
                break;
            case 2:
                System.out.println("green tea");
                break;
            case 3:
                System.out.println("coffee");
                break;
            default:
                System.out.println("Unknown option");
        }
    }
}