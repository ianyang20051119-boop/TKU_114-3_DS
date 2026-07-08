public class LoginCheck {
    public static void main(String[] args) {
        String username = "admin";
        String password = "1234";


        boolean valid= username.equals("admin") && password.equals("1234");

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("login: " + valid);
    }
}
            
