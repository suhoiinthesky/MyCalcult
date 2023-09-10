package suhoiCalcult;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class calcul3 {

    private static final Map<String, Integer> romeMap = new HashMap<>();

    static {
        romeMap.put("I", 1);
        romeMap.put("IV", 4);
        romeMap.put("V", 5);
        romeMap.put("IX", 9);
        romeMap.put("X", 10);
        for (int i = 1; i <= 100; i++) {
            String roman = convertToRoman(i);
            romeMap.put(roman, i);
        }
    }
    private static String convertToRoman(int number) {
        if (number < 0){
            throw new IllegalArgumentException("В римской системе исчисления нету отрицательных чисел");
        }
        else if (number < 1 || number > 100) {
            throw new IllegalArgumentException("Число должно быть от 1 до 100");
        }

        StringBuilder result = new StringBuilder();


        int[] arabicNumbers = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int i = 0;


        while (number > 0) {
            if (number >= arabicNumbers[i]) {
                result.append(romanNumerals[i]);
                number -= arabicNumbers[i];

            } else {
                i++;
            }
        }

        return result.toString();

    }

    private static int calcult (int a, int b, String oper) {
        return switch (oper) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalStateException("Недействительный оператор: " + oper);
        };

    }


    public static void main(String[] args) throws ParseException {

        while (true) {
            System.out.println("Добро пожаловать в калькулятор");
            System.out.println("Введите выражение через проблел");
            Scanner scanner = new Scanner(System.in);
            String math = scanner.nextLine();
            String[] parts = math.trim().split(" ");
            String romanRegex = "^(I|II|III|IV|V|VI|VII|VIII|IX|X)$";
            String arabicRegex = "^[1-9]|10$";
            if (parts.length => 4){
                throw new ArrayIndexOutOfBoundsException("По ТЗ нельзя выпольнять операцию более чем с 2 переменными и одним оператором");
            }
            try {
                String a = parts[0];
                String c = parts[1];
                String b = parts[2];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Не верный формат ввода. Вводите переменные через пробел.");
            }
            String a = parts[0];
            String c = parts[1];
            String b = parts[2];
            int resul;
            if (a.matches(arabicRegex) && b.matches(arabicRegex)) {
                int num1 = Integer.parseInt(a);
                int nub2 = Integer.parseInt(b);
                resul = calcult(num1, nub2, c);
                System.out.println("Результат вычисления " + resul);

            } else if (a.matches(romanRegex) && b.matches(romanRegex)) {
                int Rnum1 = romeMap.get(a);
                int Rnum2 = romeMap.get(b);

                resul = calcult(Rnum1, Rnum2, c);

                resul = calcult(Rnum1, Rnum2, c);
                String resultRoman = convertToRoman(resul);
                System.out.println("Результат вычисления " + resultRoman);
            


            } else if ((a.matches(arabicRegex) && b.matches(romanRegex)) || (a.matches(romanRegex) && b.matches(arabicRegex))) {
                throw new IllegalArgumentException("Нельзя выполнять вычисления между двумя разными системами исчисления");
            } else {
                System.out.println("Вы ввели что то не то");
            }
        }
    }
}
