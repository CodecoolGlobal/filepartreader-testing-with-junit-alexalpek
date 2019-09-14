import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {

    private String filePath = null;
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

    public String read() throws IOException {
        return Files.readString(Paths.get(filePath), StandardCharsets.US_ASCII);
    }


    String readLines() {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            for (int i = fromLine; i <= toLine; i++)
                br.readLine();
            line = br.readLine();
            return line;
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
