import java.io.*;
import java.util.Scanner;

public class Q3WriteLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String user_input;
        System.out.println("\nEnter your text: ");
        user_input=scanner.nextLine();


        try (FileWriter fileWriter = new FileWriter("myfile.txt")){
                fileWriter.write(user_input);
        } catch (IOException ex) {
            System.out.println("Error occurred: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
        System.out.println("\nFile Written successfully!");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("myfile.txt"))) {
            String line;

            System.out.println("\nFile Contents:\n");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}

