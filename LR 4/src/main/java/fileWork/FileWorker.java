package fileWork;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class FileWorker{
    public static void sortAndWriteFile(String message)  throws IOException {
        Path filePath = Paths.get("E:\\RIS 4\\RIS 4\\src\\main\\resources\\received messages.txt");
        List<String> lines;

        try {
            lines = Files.readAllLines(filePath);
            lines.add(message);

            lines.sort(Comparator.comparingInt((s) -> Integer.parseInt(s)));

            Files.write(filePath, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
