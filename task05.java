
/*
 * Напишите метод, который вернет содержимое текущей папки в виде массива строк.
Напишите метод, который запишет массив, возвращенный предыдущим методом в файл.
Обработайте ошибки с помощью try-catch конструкции. В случае возникновения исключения, оно должно записаться в лог-файл.
 */
import java.util.logging.*;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;

public class task05 {
    public static void main(String[] args) {
        String path = "/home/mort/GB Study Projects/GBJavaIntroducing/Seminar02/";
        String[] fl = getDirList(path);
        writeListToFile(fl);
    }

    public static String[] getDirList(String path) {
        String[] fileList = new String[0];
        try {
            File targetDir = new File(path);
            System.out.println("Dir scanned");
            fileList = targetDir.list();
        } catch (Exception e) {
            System.out.println("Dir reading error");
            System.out.println(e.getMessage());
        }
        return fileList;
    }

    public static void writeListToFile(String[] fileList) {
        try {
            FileWriter fw = new FileWriter("files.txt", false);
            for (String line : fileList) {
                fw.append(line);
                fw.append("\n");
            }
            fw.flush();
            System.out.println("File created");
            fw.close();
        } catch (Exception e) {
            System.out.println("File writing error");
            System.out.println(e.getMessage());
        }
    }
}
