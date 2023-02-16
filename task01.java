/*
 * Дано четное число N (>0) и символы c1 и c2.
Написать метод, который вернет строку длины N, которая состоит из чередующихся символов c1 и c2, начиная с c1.
 */
public class task01 {
    public static void main(String[] args) {
        int n = 11;
        String c1 = "a";
        String c2 = "b";

        System.out.println(getString(n, c1, c2));
    }

    public static StringBuilder getString(int n, String c1, String c2) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n / 2; i++) {
            result.append(c1);
            result.append(c2);
        }
        if (result.length() < n) {
            result.append(c1);
        }
        return result;
    }

}