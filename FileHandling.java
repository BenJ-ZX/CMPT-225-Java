import static Helper.Study.*;
import java.io.File;
// Rewrite File
import java.io.FileWriter;
import java.io.PrintWriter;
// Read File
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
// The Creature
import java.io.IOException;

/* IOException
The parent directory doesn’t exist.
You don’t have permission to write to the file or directory.
The path points to a directory instead of a file.
The disk is full or a storage error occurs.
*/

@FunctionalInterface
interface WriteScreen{
    void w(String s);
}

public class FileHandling {

    // Create a New File
    public static void CreateFile(String path) throws IOException{

        File newFile = new File(path);

        if (newFile.createNewFile()){
            System.out.printf("'%s' was Created\n", path);
        } else {
            print("'" + path + "' " + "Already Exists");
        }

        // try { ... } catch (IOException e) { .... }
    }

    // Read File using Scanner
    public static void ReadFile(String path) throws IOException{

        File read = new File(path);
        Scanner input = new Scanner(read);

        printSection("Reading '" + path + "'");
        while (input.hasNextLine()){
            print(input.nextLine());
        }

        input.close();

        printSection();

        // try with resource doesn't need 'input.close()'
        // try (Scanner input = new Scanner(read)) { ... } catch (IOException e) { ... }
    }

    // Read File using FileReader & BufferedReader
    // Create file if no such path exists
    public static void ReadFile_(String path) throws IOException{
        FileReader read = new FileReader(path);
        BufferedReader input = new BufferedReader(read);

        String line = input.readLine();

        printSection("Reading '" + path + "'");

        while (line != null){

            print(line);
            line = input.readLine();

        }
        printSection();

        input.close();

    }

    // Write in file using FileWriter
    // append : false -> rewrite the whole file
    // append : true  -> add to the end of the file
    // Create file if no such path exists
    public static void WriteFile(String path, boolean append, String...text) throws IOException{

        FileWriter FileModification = new FileWriter(path, append);

        for (String s : text){
            FileModification.write(s);
        }
        FileModification.close();

        // try with resource doesn't need 'FileModification.close()'
        // try (FileWriter FileModification = new FileWriter(path, append)) { ... } catch (IOException e) { ... }
    }

    // Write in file using PrintWriter
    // Rewrites the whole file
    public static void WriteFile_(String path, boolean newLine, String...text) throws IOException{

        PrintWriter FileModification = new PrintWriter(path);

        WriteScreen WriteOnFile;

        if (newLine){ WriteOnFile = FileModification::println; } else { WriteOnFile = FileModification::print; }

        for (String s : text){
            WriteOnFile.w(s);
        }

        FileModification.close();

    }

    // Delete File
    // Delete Directory if Empty
    public static void DeleteFile(String path){
        File delFile = new File(path);

        if (delFile.delete()){
            print("File Deleted");
        } else {
            print("Failed to Delete the File");
        }

    }

    // Prints File Information
    public static void FileInfo(String path){

        File file = new File(path);
        printSection("File Information");
        print("File Name: " + file.getName());
        print("Absolute Path: " + file.getAbsolutePath());
        print("Length: " + file.length());
        print("Can Read: " + file.canRead());
        print("Can Write: " + file.canWrite());
        printSection();
    }

    public static void main(String[] args) throws IOException{

        String filePath = "readable.txt";

        CreateFile(filePath);

        WriteFile(filePath, false, "this\n", "that\n", "and maybe this\n");
        // this
        // that
        // and maybe this

        WriteFile(filePath, true, "or not\n");

        // *adds line*
        // or not

        ReadFile(filePath);

        WriteFile_(filePath, true, "Me", "Myself", "And I");
        // Me
        // Myself
        // And I

        WriteFile_(filePath, false, "Me", "Myself", "And I");
        // MeMyselfAnd I

        ReadFile_(filePath);

        FileInfo(filePath);

        DeleteFile(filePath);

    }

}
