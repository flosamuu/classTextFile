import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class fileWriting {
    public static void main(String[] args) throws IOException {
        // Get the user's home directory
        String home = System.getProperty("user.home");

        // Prerequisite: the file classTextFile.txt exists
        File inputFile = new File(home + "/Desktop/classTextFile.txt");

        // Creates a file called classTextFileTwo
        File outputFile = new File(home + "/Desktop/classTextFileTwo.txt");
        
        Scanner input = new Scanner(System.in);

        if (!inputFile.exists()) {
            System.out.println("Erm input file not found at " + inputFile.getAbsolutePath());
            System.out.print("Enter the full path to the input file: ");
            String path = input.nextLine();
            
            inputFile = new File(path);
        }
        
        input.close();
        Scanner scan = new Scanner(inputFile);
        
        // String to store the text we want
        String fileContent = "";

        // Make a new file containing every odd line from the input file
        int lineNumber = 1;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (lineNumber % 2  == 1) {
                fileContent += line + "\n";
            }
            lineNumber++;
        }

        scan.close();

        FileWriter writer = new FileWriter(outputFile);


        writer.write(fileContent);
        writer.close();
        System.out.print("yippee! Output written to " + outputFile.getAbsolutePath());
    }
}