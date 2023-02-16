/*
Напишите метод, который сжимает строку.
Пример: вход aaaabbbcdd.
*/

public class task02 {
    public static void main(String[] args) {
        StringBuilder inputString = new StringBuilder();
        inputString.append("aaaaabbabcddd");
        System.out.println(compressString(inputString));
    }

    public static StringBuilder compressString(StringBuilder inStr) {
        // StringBuilder result = new StringBuilder();
        for (int i = 0; i < inStr.length() - 1; i++) {
            if (inStr.charAt(i) == inStr.charAt(i + 1)) {
                int count = 2;
                inStr.replace(i + 1, i + 2, String.valueOf(count));
                // if (inStr.length() > i + 2) {
                while (inStr.charAt(i) == inStr.charAt(i + 2)){
                    // count++;
                    inStr.replace(i + 1, i + 2, String.valueOf(++count));
                    inStr.replace(i + 2, i + 3, "");
                    if (inStr.length() <= i + 2) break;

                }
                i++;
                // }

            }
        }
        return inStr;
    }
}
