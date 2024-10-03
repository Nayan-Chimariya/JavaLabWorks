import java.sql.*;
import java.util.Scanner;

public class Q2GatherInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many records do you want to enter? : ");
        int num_records = scanner.nextInt();

        for (int i = 0; i < num_records; i++) {
            System.out.printf("\nEnter Record [%d]\n",i+1);

            System.out.println("Roll No : ");
            int roll = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Name : ");
            String name = scanner.nextLine();

            System.out.println("Email : ");
            String email = scanner.next();

            scanner.nextLine();

            System.out.println("Address : ");
            String address = scanner.nextLine();

            handleDatabase(name,roll,email,address);
        }
    }

    public static void handleDatabase(String name, int roll, String email, String address){

        String DB_URL = "jdbc:mysql://localhost:3306/students";
        String USER = "root";
        String PASSWORD = System.getenv("PASSWORD");

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection established successfully!\n");

            String query1 = "CREATE TABLE IF NOT EXISTS StudentsRecord ("
                    + "Name varchar(255), "
                    + "Roll int, "
                    + "Email varchar(255), "
                    + "Address varchar(255))";

            Statement statement = conn.createStatement();
            int result1 = statement.executeUpdate(query1);

            String query2 = "INSERT INTO StudentsRecord (Name, Roll, Email, Address) VALUES (?, ?, ?, ?)";
            PreparedStatement prepared_statement = conn.prepareStatement(query2);
            prepared_statement.setString(1, name);
            prepared_statement.setInt(2, roll);
            prepared_statement.setString(3, email);
            prepared_statement.setString(4, address);

            int result2 = prepared_statement.executeUpdate();
            System.out.println(result2 + " record(s) inserted.");
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}
