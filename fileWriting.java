// This thing is supposed to create a text file with every odd line of another file
// Default input file will be classTextFile.txt. If it doesn't exist, enter the path to whatever input file you want
// It will create a new file, with a name of your choice, in your desktop to output the odd lines to

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class fileWriting {
    public static void main(String[] args) throws IOException {
        // Get the user's home directory
        String home = System.getProperty("user.home");

        // Scanner for the person to input stuff
        Scanner input = new Scanner(System.in);

        // Prerequisite: the file classTextFile.txt exists
        File inputFile = new File(home + "/Desktop/classTextFile.txt");
        
        if (inputFile.exists()) {
            System.out.println("Looks like classTextFile.txt already exists. It'll be the input file by default.");
        }

        while (!inputFile.exists()) {
            System.out.println("Erm input file not found at " + inputFile.getAbsolutePath());
            System.out.print("Enter the full path to the input file: ");
            String path = input.nextLine();
            
            inputFile = new File(path);
            System.out.println();
        }

        // Creates a file called classTextFileTwo to put the output in
        System.out.print("Enter the NAME of the file you want to output to, excluding the path and format. ");
        System.out.println("(If it doesn't exist on your desktop, it will be automatically placed there and formatted as a .txt file): ");

        String outputFileName = input.nextLine();

        File outputFile = new File(home + "/Desktop/" + outputFileName + ".txt");

        int function = 0;

        while (function < 1 || function > 5) {
            System.out.println("What would you like to do? Type out the NUMBER corresponding to your choice.");
            System.out.println("1  Keep all lines\n2  Keep the odd lines\n3  Keep the even lines\n4  Add something to the start of each line\n5  Add something to the end of each line");
            function = input.nextInt();
        }

        // Clear the annoying leftover newline in the input buffer
        input.nextLine();

        Scanner scan = new Scanner(inputFile);
        
        // String to store the text we want
        String fileContent = "";

        // Add every odd line from the input file to the string
        int lineNumber = 1;

        if (function == 1) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                fileContent += line + "\n";
                lineNumber++;
            }
        }

        else if (function == 2) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (lineNumber % 2  == 1) {
                    fileContent += line + "\n";
                }
                lineNumber++;
            }
        }

        else if (function == 3) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (lineNumber % 2  == 0) {
                    fileContent += line + "\n";
                }
                lineNumber++;
            }
        }

        else if (function == 4) {
            System.out.println("What would you like to add to the start of each line?");
            String addition = input.nextLine();

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                fileContent += addition + line + "\n";
            }
        }

        else if (function == 5) {
            System.out.println("What would you like to add to the end of each line?");
            String addition = input.nextLine();

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                fileContent += line + addition + "\n";
            }
        }

        input.close();
        scan.close();

        // Write that in 🗣🗣📝!!
        FileWriter writer = new FileWriter(outputFile);

        writer.write(fileContent);
        writer.close();

        System.out.print("yippee! Output written to " + outputFile.getAbsolutePath());
    }
}