import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q1FileCopy {
    public static void main(String[] args) {
        String sourceFile = "myfile.txt";
        String destinationFile = "copiedfile.txt";

        try (
                FileInputStream inputStream = new FileInputStream(sourceFile);
                FileOutputStream outputStream = new FileOutputStream(destinationFile);
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
