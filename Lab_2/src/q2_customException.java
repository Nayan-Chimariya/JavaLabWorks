import java.util.Scanner;

//custom checked exception
class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}

//custom runtime exception
class InvalidMarkException extends RuntimeException {

    public InvalidMarkException() {
        super("Invalid mark entered!");
    }

    public InvalidMarkException(String message) {
        super(message);
    }
}

public class q2_customException {

    static void checkNumber(int number) throws MyException {
        if (number < 0) {
            throw new MyException("Negative number detected: " + number);
        } else {
            System.out.println("Number is valid: " + number);
        }
    }

    static void validateMark(int mark) {
        if (mark < 0 || mark > 100) {
            throw new InvalidMarkException("Mark out of valid range: " + mark);
        } else {
            System.out.println("Valid mark: " + mark);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Custom Checked Exception\n");

        System.out.println("Enter a number: ");
        int num = scanner.nextInt();

        try {
            checkNumber(num);
        } catch (MyException ex) {
            System.out.println("Caught MyException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("An error occurred: " + ex.getMessage());
        }

        System.out.println("\nCustom Runtime Exception\n");

        System.out.println("Enter a mark (0-100): ");
        int mark = scanner.nextInt();

        try {
            validateMark(mark);
        } catch (InvalidMarkException ex) {
            System.out.println("Caught InvalidMarkException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("An error occurred: " + ex.getMessage());
        }
    }
}

