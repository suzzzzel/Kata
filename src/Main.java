import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);  // Чтение вводимой операции
        String input;   // Для операции :)
        System.out.println("Введите операцию для калькулятора :) \n" +  // Правила
                "1. Калькулятор воспринимает только ОДНУ арифметическую операцию (прим. 1 + 1)\n" +
                "2. Калькулятор воспринимает ТОЛЬКО арабские или ТОЛЬКО римские цифры (прим. 1 + 1 ИЛИ I + I)\n" +
                "3. Калькулятор воспринимает только целые числа. Будьте готовы к ответу 0\n" +
                "4. Калькулятор воспринимает числа ОТ 1 ДО 10. Как Римскими, так и Арабскими цифрами.\n" +
                "5. У Римских цифр нет ОТРИЦАТЕЛЬНЫХ значений, учитывайте это." +
                "6. Операции доступные для проведения:\n" +
                "+ = складывает числа\n" +
                "- = вычитает число\n" +
                "* = умножает числа\n" +
                "/ = делит числа\n");
        input = sc.nextLine(); // Ждем операцию
        System.out.println(calc(input)); // Делаем операцию И выводим в консоль :)
    }

    public static String calc(String input) throws Exception {
        Exception error = new Exception("Проверь свое выражение! Следуй правилам, пожалуйста :)");
        HashMap<String, Integer> map = new HashMap<>();  // Конвертация Римских цифр в Integer
        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);
        input = input.replace(" ", ""); // Убираем пробелы, они нам не нужны
        String str1; // Первая часть выражения;
        String str2; // Вторая часть выражения;
        String romanRes;
        int first;
        int second;
        int result;
        String operations = null; // Для нахождения операции
        int counter = 0; // Счетчик количества арифметических операций
        String[] listOfOperations = {"+", "-", "*", "/"}; // Всевозможные операции
        for (int x = 0; x < input.length(); x++) { // Ищем операцию и считаем их количество
            String temp = String.valueOf(input.charAt(x));
            if (Arrays.asList(listOfOperations).contains(temp)) { // Ищем совпадение среди списка операций
                counter++;
                operations = temp;
            }
        }
        if (counter != 1) {
            throw error;
        }
        str1 = input.substring(0, input.indexOf(operations));
        str2 = input.substring(input.indexOf(operations) + 1);
        if (map.containsKey(str1) && map.containsKey(str2)) {
            first = map.get(str1);
            second = map.get(str2);
            switch (operations) {
                case "+":
                    result = first + second;
                    if(result <= 0) {
                        throw error;
                    }
                    return "Результат: " + integerToRoman(result);
                case "-":
                    result = first - second;
                    if(result <= 0) {
                        throw error;
                    }
                    return "Результат: " + integerToRoman(result);
                case "*":
                    result = first * second;
                    if(result <= 0) {
                        throw error;
                    }
                    return "Результат: " + integerToRoman(result);
                case "/":
                    result = first / second;
                    if(result <= 0) {
                        throw error;
                    }
                    return "Результат: " + integerToRoman(result);
            }
        } else if ((!map.containsKey(str1) && map.containsKey(str2)) || (map.containsKey(str1) && !map.containsKey(str2))) {
            throw error;
        } else {
            first = Integer.parseInt(str1);
            second = Integer.parseInt(str2);
            if (first < 10 && second < 10) {
                switch (operations) {
                    case "+":
                        result = first + second;
                        return "Результат: " + result;
                    case "-":
                        result = first - second;
                        return "Результат: " + result;
                    case "*":
                        result = first * second;
                        return "Результат: " + result;
                    case "/":
                        result = first / second;
                        return "Результат: " + result;
                }
            }
        }
        throw error;
    }
        public static String integerToRoman (int number) {
            StringBuilder s = new StringBuilder();
            while (number >= 1000) {
                s.append("M");
                number -= 1000;
            }
            while (number >= 900) {
                s.append("CM");
                number -= 900;
            }
            while (number >= 500) {
                s.append("D");
                number -= 500;
            }
            while (number >= 400) {
                s.append("CD");
                number -= 400;
            }
            while (number >= 100) {
                s.append("C");
                number -= 100;
            }
            while (number >= 90) {
                s.append("XC");
                number -= 90;
            }
            while (number >= 50) {
                s.append("L");
                number -= 50;
            }
            while (number >= 40) {
                s.append("XL");
                number -= 40;
            }
            while (number >= 10) {
                s.append("X");
                number -= 10;
            }
            while (number >= 9) {
                s.append("IX");
                number -= 9;
            }
            while (number >= 5) {
                s.append("V");
                number -= 5;
            }
            while (number >= 4) {
                s.append("IV");
                number -= 4;
            }
            while (number >= 1) {
                s.append("I");
                number -= 1;
            }
            return s.toString();
        }
    }

