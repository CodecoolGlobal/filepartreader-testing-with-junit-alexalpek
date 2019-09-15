import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class FilePartReader {

    private String filePath;
    private int fromLine = 0;
    private int toLine = 0;

    void setup(String filePath, int fromLine, int toLine) {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        } else {
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toLine;
        }
    }

    String read(){
        try {
            String content;
            content = new String(Files.readAllBytes(Paths.get(filePath)));
            return content; }
        catch (IOException e) {
            return "IOException error";
        }
    }

    String readLines(){
        StringBuilder line = new StringBuilder();
        try {
            List content = Files.readAllLines(Paths.get(filePath));
            for (int i = fromLine - 1; i < toLine; i++) {
                 line.append(content.get(i));
            }
            return line.toString();
        } catch (IOException e) {
            return "IOException error";
        }
    }
}
