import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class User {
    String id;
    String name;
    String email;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String GetData() {
        return "ID = " + id + " " + "Name = " + name + " " + "Email = " + email;
    }
}

public class Q2WriteObjects {

    public static void addUsers() {
        Scanner scanner = new Scanner(System.in);

        try (FileWriter fileWriter = new FileWriter("users.txt", true)) {
            for (int i = 0; i < 5; i++) {
                System.out.println("\nEnter details for User " + (i + 1) + ":");
                System.out.print("\nID: ");
                String id = scanner.next();
                scanner.nextLine();
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();

                User user = new User(id, name, email);

                fileWriter.write(user.GetData() + "\n");
            }

            System.out.println("\nUser details saved to file successfully!\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void displayUsers() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("users.txt"))) {
            String line;

            System.out.println("\nStored User Data:\n");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        addUsers();
        displayUsers();
    }
}
