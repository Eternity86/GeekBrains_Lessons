/* ##########################################
# ДЗ к третьему уроку по Java на GeekBrains #
# ========================================= #
# Задача №2                                #
#                                           #
########################################## */

package ru.com.GeekBrains.Lesson3;

/*2.* Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
    "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
    Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
    apple – загаданное
    apricot - ответ игрока
    ap############# (15 символов, чтобы пользователь не мог узнать длину слова)

    Для сравнения двух слов посимвольно, можно пользоваться:
    String str = "apple";
    str.charAt(0); - метод вернет char, который стоит в слове str на первой позиции
    Играем до тех пор, пока игрок не отгадает слово
    Используем только маленькие буквы
*/

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String[] words = {
                "apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
                "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String word = words[new Random().nextInt(words.length)];
        System.out.println("Я загадал слово. Угадай, какое!");
        String guess;
        int temp;                                                                           // при попытке угадать сюда записываем длину более короткого слова
        char[] tempChar = {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'};    // массив символов - маска
        do {
            guess = input.nextLine().toLowerCase();
            if (guess.equals(word)) {
                break;
            } else {
                temp = guess.length() <= word.length() ? guess.length() : word.length();
                for (int i = 0; i < temp; i++) {
                    if (guess.charAt(i) == word.charAt(i)) tempChar[i] = guess.charAt(i);
                }
            }
            System.out.println(tempChar);

        } while (!guess.equals(word));
        System.out.println("Молодец!");



    }


}
