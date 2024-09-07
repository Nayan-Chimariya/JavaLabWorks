import java.util.Scanner;

public class q2_yourName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter your name : ");
        String user_name = scanner.next();

        System.out.printf("\nUser name : %s\n",user_name.toUpperCase());
    }
}
