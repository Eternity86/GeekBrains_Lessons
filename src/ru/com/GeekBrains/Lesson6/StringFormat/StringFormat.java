package ru.com.GeekBrains.Lesson6.StringFormat;

import java.util.regex.Matcher;

class StringFormat {
    public static void main(String[] args) {

        String str1 = "      Предложение    один    Теперь     предложение   два     Предложение три    Ну ещё предложение четыре     И предложение пять  И в самом   конце   предложение    шесть   ";
        System.out.println(str1);

        StringBuilder stringBuilder = new StringBuilder(str1.replaceAll(" +", " ").trim());     // преобразуем String в StringBuilder, заменяем множественные пробелы на одинарные пробелы и по окончании убираем предшествующие и завершающие пробелы
        System.out.println(stringBuilder);

        for(int i = 1; i < stringBuilder.length(); i++) {                                                         // по всей длине stringBuilder:
            if (stringBuilder.charAt(i) >= 'A' && stringBuilder.charAt(i) <= 'Я') {                               // если буква большая, значит это начало предложения -
                stringBuilder.setCharAt(i - 1, '.');                                                   // устанавливаем перед ней точку
            }
        }

        stringBuilder = new StringBuilder(stringBuilder.toString().replaceAll("\\.", Matcher.quoteReplacement(". ")));    // заменяем точку на точку с пробелом, чтобы привести текст в нормальный вид

        if (stringBuilder.charAt(stringBuilder.length() - 1) != '.') {                                            // если в конце текста нет точки -
            stringBuilder.append('.');                                                                            // добавляем эту самую точку
        }

        System.out.println(stringBuilder);
    }
}

