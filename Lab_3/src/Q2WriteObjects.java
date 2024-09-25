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

class AppendableObjectOutputStream extends ObjectOutputStream {
    // Constructor that does not write a header when appending
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        // Skip writing a header when appending
        reset();
    }
}

public class Q2WriteObjects {

    private static final String FILE_NAME = "users.dat";

    public static void addUsers() {
        Scanner scanner = new Scanner(System.in);

        try (FileOutputStream fos = new FileOutputStream(FILE_NAME, true);
             ObjectOutputStream oos = isFileEmpty()
                     ? new ObjectOutputStream(fos) // First time, write the header
                     : new AppendableObjectOutputStream(fos)) { // Append mode, skip the header

            for (int i = 0; i < 3; i++) {
                System.out.println("\nEnter details for User " + (i + 1) + ":");
                System.out.print("ID: ");
                String id = scanner.next();
                scanner.nextLine();
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();

                User user = new User(id, name, email);
                oos.writeObject(user); // Append user to the file
            }

            System.out.println("\nUser details saved to file successfully!\n");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void displayUsers() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            System.out.println("\nStored User Data:\n");

            while (true) {
                try {
                    User user = (User) ois.readObject();
                    System.out.println("ID = " + user.id + " | Name = " + user.name + " | Email = " + user.email);
                } catch (EOFException e) {
                    // End of file reached
                    break;
                } catch (ClassNotFoundException e) {
                    System.out.println("Class not found: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    // Helper method to check if the file is empty or not
    private static boolean isFileEmpty() {
        File file = new File(Q2WriteObjects.FILE_NAME);
        return !file.exists() || file.length() == 0;
    }

    public static void main(String[] args) {
        addUsers();
        displayUsers();
    }
}
