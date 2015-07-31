import java.io.*;
import java.util.Scanner;

public class Lesson8FibonacciSequence {
    final static String FILE_FOLDER = "C://tmp//lesson8.txt";

    public static void main(String[] args) {
        Lesson8FibonacciSequence sequence = new Lesson8FibonacciSequence();
        System.out.println("Please enter some numbers:");
        Scanner keyboardInput = new Scanner(System.in);
        String text = keyboardInput.nextLine();
        sequence.writeToFile(FILE_FOLDER, text);
        String[] textArray = text.split(" ");

        if (sequence.checkFibonacciSequence(textArray)) {
            sequence.writeToFile(FILE_FOLDER, "Fibonacci sequence: " + text);
        } else {
            sequence.writeToFile(FILE_FOLDER, "not Fibonacci sequence: " + text);

        }
        System.out.println(sequence.readFromFile(text));
    }


    public void writeToFile(String fileName, String text) {

        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readFromFile(String readLine) {
        BufferedReader reader = null;
        String result = null;
        try {
            reader = new BufferedReader(new FileReader(FILE_FOLDER));
            result = reader.readLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean checkFibonacciSequence(String[] textArray) {
    int lenght = textArray.length;
        boolean fibocacciCheck = false;
        for (int i = 2; i < lenght; i++) {
            int firstElement = Integer.parseInt(textArray[i - 2]);
            int secondElement = Integer.parseInt(textArray[i - 1]);
            int thirdElement = Integer.parseInt(textArray[i]);

            fibocacciCheck = (thirdElement == secondElement + firstElement);
            if (fibocacciCheck){
                fibocacciCheck = true;
            }
            else {
                break;
            }
        }
        return fibocacciCheck;
    }
}



