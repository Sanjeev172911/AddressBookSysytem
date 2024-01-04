import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOperation {
    public String readFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine())  !=null ){
                System.out.println(line);
                content.append(line).append("\n");
            }
        } catch (IOException exception){
            exception.printStackTrace();
        }
        return content.toString();
    }

    public void writeToFile(String filePath, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,false))){
            writer.write(data);
            writer.newLine();
            System.out.println("Data Added");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void createFile(String filePath) {
        try {
            Path path = Path.of(filePath);
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("Files created: " +filePath);
            } else {
                System.out.println("File Already Exists: " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
