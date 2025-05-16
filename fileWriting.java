import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
// import java.io.FileNotFoundException;

public class fileWriting {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/UserName/Desktop/classTextFile.txt");
        Scanner scan = new Scanner(file);
        
        // String to store the text we want
        String fileContent = "";

        // Make a new file containing every odd line from the classTextFile
        int lineNumber = 1;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (lineNumber % 2  == 1) {
                fileContent = fileContent.concat(line + "\n");
            }
            lineNumber++;
        }

        scan.close();

        FileWriter writer = new FileWriter("/Users/UserName/Desktop/classTextFileTwo.txt");

        writer.write(fileContent);
        writer.close();
    }
}