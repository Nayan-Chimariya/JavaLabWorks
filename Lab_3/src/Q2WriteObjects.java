import java.io.*;
import java.util.Scanner;

class User implements Serializable {
    String id;
    String name;
    String email;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

public class Q2WriteObjects {

    public static void addUsers() {
        Scanner scanner = new Scanner(System.in);

        try (FileOutputStream fos = new FileOutputStream("users.dat", true);
             ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos))) {

            for (int i = 0; i < 5; i++) {
                System.out.println("\nEnter details for User " + (i + 1) + ":");
                System.out.print("ID: ");
                String id = scanner.next();
                scanner.nextLine();
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();

                User user = new User(id, name, email);

                oos.writeObject(user);
            }

            System.out.println("\nUser details saved to file successfully!\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void displayUsers() {
        try (FileInputStream fis = new FileInputStream("users.dat");
             ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis))) {

            System.out.println("\nStored User Data:\n");

            while (true) {
                try {
                    User user = (User) ois.readObject();
                    System.out.println("ID = " + user.id + " | Name = " + user.name + " | Email = " + user.email);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.out.println("Class not found: " + e.getMessage());
                }
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
