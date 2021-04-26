import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // 1. Primitive types hold simple values

        // integer assignment
        int i = 1;
        int j = 2;

        // calculate sum
        int sum = i + j;

        // outputs sum to screen
        System.out.println(sum);

        // outputs if number is odd
        System.out.println(isOdd(sum));

        // outputs if number is even
        System.out.println(isEven(sum));

        // array declaration, initialization
        int[] numbers = {4, 9, 21, 3};

        System.out.printf("Max number is %d ", maxIntFromList(numbers));
        Arrays.sort(numbers);

        // sort a user's inputted integer values
        Integer[] numbersInput = getNumbersFromUser();
        Arrays.sort(numbersInput);
        System.out.println(Arrays.toString(numbersInput));

        // read content of file
        try {
            // add relative filepath; e.g. /home/john/file.txt
            printFileContents("/home/john/file.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        // creating a scanner instance
        Scanner scanner = new Scanner(System.in);

        // accept an operation
        System.out.println("Enter operation: add | subtract | multiply | divide");
        String operation = scanner.nextLine();

        // accept two numbers
        System.out.println("Enter first number");
        int num1 = scanner.nextInt();

        System.out.println("Enter second number");
        int num2 = scanner.nextInt();

        // compute
        Float result = compute(num1, num2, operation);

        // print result with 2 d.p formatting
        System.out.printf("Result of %s operation is %.2f", operation, result);

    }

    // function declarations
    static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    static boolean isEven(int number) {
        return !isOdd(number);
    }

    // gets number input from user; object reference
    static Integer[] getNumbersFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter how many numbers");
        int count = scanner.nextInt();

        Integer[] numbers = new Integer[count];
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number");
            numbers[i] = scanner.nextInt();
        }
        return numbers;

    }

    // prints file contents from inputted path; while construct
    static void printFileContents(String pathName) throws FileNotFoundException {
        File file = new File(pathName);
        Scanner scanner = new Scanner(file);

        int lineCount = 1;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(lineCount + " " + line);
            lineCount++;
        }
    }

    // compute maximum from list of numbers; looping construct, if-else construct
    static int maxIntFromList(int[] numbers) {

        // set max as first value in numbers list
        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    // perform computation of two numbers with selected operation; switch construct
    static float compute(float num1, float num2, String operation) {
        switch (operation) {
            case "add":
                return num1 + num2;
            case "subtract":
                return num1 - num2;
            case "multiply":
                return num1 * num2;
            case "divide":
                return num1 / num2;
            default:
                System.out.println("Operation not permitted");
                return 0;
        }
    }

}
