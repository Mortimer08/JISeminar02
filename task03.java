
/*Напишите метод, который принимает на вход строку (String)
 и определяет является ли строка палиндромом (возвращает boolean значение). */
import java.util.Scanner;

public class task03 {
    public static void main(String[] args) {
        System.out.println("Введите строку для проверки на полиндром:");
        Scanner myScanner = new Scanner(System.in);
        String inputString = myScanner.nextLine();
        myScanner.close();
        System.out.println(isPalindrom(inputString));
    }

    public static boolean isPalindrom(String inStr) {
        int lastIndex = inStr.length()-1;
        for (int i = 0; i < inStr.length() / 2; i++) {
            if (inStr.charAt(i) != inStr.charAt(lastIndex)) {
                return false;
            }
            lastIndex--;
        }
        return true;
    }
}
