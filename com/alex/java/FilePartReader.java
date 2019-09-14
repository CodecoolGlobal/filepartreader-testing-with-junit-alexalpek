import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {

    private String filePath;
    private int fromLine = 0;
    private int toLine = 0;

    public void setup(String filePath, int fromLine, int toLine) {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        } else {
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toLine;
        }
    }

    public String read(){
        StringBuilder line = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while(br.readLine()!=null)
                line.append(br.readLine());
            return line.toString();
        } catch (IOException e) {
            return e.getMessage();
        }
    }


     public String readLines() {
        StringBuilder line = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            for (int i = fromLine; i <= toLine; i++)
                line.append(br.readLine());
            return line.toString();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
