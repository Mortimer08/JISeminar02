
/*
 * Напишите метод, который вернет содержимое текущей папки в виде массива строк.
Напишите метод, который запишет массив, возвращенный предыдущим методом в файл.
Обработайте ошибки с помощью try-catch конструкции. В случае возникновения исключения, оно должно записаться в лог-файл.
 */
import java.util.logging.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class task05 {
    static Logger myLogger;
    static {
        try {
            myLogger = Logger.getLogger(task05.class.getName()); // создаём (объект?) логгер
            // myLogger.setLevel(Level.INFO); // Устанавливаем для своего логгера уровень
            // INFO
            // ConsoleHandler fh = new ConsoleHandler(); // создаём экземляр обработчика -
            // файловый обработчик
            FileHandler fh = new FileHandler("log.txt",true);
            myLogger.addHandler(fh); // добавляем логгеру созданный обработчик
            SimpleFormatter myFormatter = new SimpleFormatter(); // создаём форматтер
            fh.setFormatter(myFormatter); // устанавливаем обработчику форматтер
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws SecurityException, IOException {

        String path = "/home/mort/GB Study Projects/GBJavaIntroducing/Seminar03/";
        String[] fl = getDirList(path);
        writeListToFile(fl);

    }

    public static String[] getDirList(String path) throws SecurityException, IOException {
        String[] fileList = new String[0];

        try {
            File targetDir = new File(path);
            myLogger.log(Level.INFO, "Dir scanned");
            fileList = targetDir.list();
        } catch (Exception e) {
            String errorMsg = String.format("Error occurred: %s", e.getMessage());
            myLogger.warning(errorMsg);
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
            myLogger.log(Level.INFO, "File created");
            fw.close();
        } catch (Exception e) {
            String errorMsg = String.format("File writing error occurred: %s", e.getMessage());
            myLogger.warning(errorMsg);
        }
    }
}
