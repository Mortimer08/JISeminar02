
/*
 * Напишите метод, который составит строку, состоящую из
 *  100 повторений слова TEST и метод, который запишет эту
 *  строку в простой текстовый файл, обработайте исключения.
 */
import java.io.FileWriter;
import java.io.IOException;

public class taskp4 {
    public static void main(String[] args) {
        StringBuilder testLine = line("TEST");
        writeToFile(testLine);
    }

    public static StringBuilder line(String inStr) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            result.append(inStr);
        }
        return result;
    }

    public static void writeToFile(StringBuilder inStr) {
        try (FileWriter f = new FileWriter("test.txt", false)) {
            f.write(String.valueOf(inStr));
            f.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}