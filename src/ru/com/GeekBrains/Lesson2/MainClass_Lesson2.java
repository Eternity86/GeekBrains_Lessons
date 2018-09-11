package ru.com.GeekBrains.Lesson2;/* ##########################################
# ДЗ ко второму уроку по Java на GeekBrains #
# ========================================= #
#                                           #
#                                           #
########################################## */

public class MainClass_Lesson2 {
    public static void main(String[] args) {

        /* 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        С помощью цикла и условия заменить 0 на 1, 1 на 0. */
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        printArray(array1);
        invertArray(array1);                        // т.к. массив передаётся по ссылке, то после работы внутренней метода изменяются значения переданного массива, хоть метод ничего и не возвращает
        printArray(array1);

        //=====================================================================================================================================================

        /* 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21. */
        int m2 = 8;
        int[] array2 = new int[m2];
        fillArrayMultipleOfThree(array2);
        printArray(array2);

        //=====================================================================================================================================================

        /* 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2. */
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray(array3);
        ifLesserSixMultipleTwo(array3);
        printArray(array3);

        //=====================================================================================================================================================

        /* 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
        заполнить его диагональные элементы единицами. */
        int m4 = 9;                              // размерность двумерного массива m*n
        int n4 = 9;
        int[][] matrix = new int[m4][n4];
        fillUpUnitsDiagonally(matrix, 1);
        printTwoDimensionalArray(matrix);

        //=====================================================================================================================================================

        /* 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета). */
        int m5 = 10;                                             // размерность массива
        int[] array5 = new int[m5];
        fillArrayByRandom(array5, 100);
        printArray(array5);
        System.out.println("min = " + getMin(array5) + ", max = " + getMax(array5));

        //=====================================================================================================================================================

        /* 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
        Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 10]) → true,
        граница показана символами ||, эти символы в массив не входят. */
        //int m6 = 6;
        //int[] array6 = new int[m6];
        int[] array6_1 = {1, 1, 1, 2, 1};
        int[] array6_2 = {2, 1, 1, 2, 1};
        int[] array6_3 = {10, 10};
        System.out.println(checkBalance(array6_1));
        System.out.println(checkBalance(array6_2));
        System.out.println(checkBalance(array6_3));

        //=====================================================================================================================================================

        /* 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
        при этом метод должен сместить все элементы массива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами. */
        int m7 = 40;           // размерность одномерного массива
        int[] array7 = new int[m7];
        fillArrayByRandom(array7, 100);
        int n7 = -25;
        printArray(array7);
        // long startTime = System.nanoTime();
        arrayShiftNTimes(array7, n7);
        // System.out.println((System.nanoTime() - startTime) / 1_000_000_000.0 + " секунд");
        printArray(array7);

        //=====================================================================================================================================================

        /* 8. ***** Создать матрицу размерностью m*n и заполнить её по спирали числами от 1 до (m*n) с шагом 1,
        начиная с крайнего верхнего левого положения (0, 0)*/
        int m8 = 5;
        int n8 = 7;
        int[][] array8 = new int[m8][n8];
        arraySpiralFilling(array8);
        printTwoDimensionalArraySpiral(array8);


        //=====================================================================================================================================================

    }

    public static void fillArrayByRandom(int[] array, int limit) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * limit);
        }
    }

    public static void printArray (int[] array) {
        for (int anArray : array) {
            System.out.printf("%d ", anArray);
        }
        System.out.println();
    }

    public static void printTwoDimensionalArray (int[][] array) {
        // int m = array.length;
        int n = array[0].length;
        for (int[] anArray : array) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", anArray[j]);
            }
            System.out.println();
        }
    }

    public static void printTwoDimensionalArraySpiral (int[][] array) {
        // int m = array.length;
        int n = array[0].length;
        for (int[] anArray : array) {
            for (int j = 0; j < n; j++) {
                if (anArray[j] < 10){
                    System.out.printf("0%d ", anArray[j]);
                } else {
                    System.out.printf("%d ", anArray[j]);
                }
            }
            System.out.println();
        }
    }

    public static void invertArray (int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;           // максимально упростили запись инвертирования значения, используя тернарный оператор
        }
    }

    public static void  fillArrayMultipleOfThree(int[] array) {
        for (int i = 0, j = 0; i < array.length; i++, j+=3) {
            array[i] = j;
        }
    }

    public static void ifLesserSixMultipleTwo(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 2;
        }
    }

    public static void fillUpUnitsDiagonally(int[][] array, int unitFiller) {
        int m = array.length, n = array[0].length;      // получаем размерность двумерного массива
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i == ((n - 1) - j)) {     // через объединение условий мы не заносим дважды в центр массива заполнитель, когда размерность массива нечётная
                    array[i][j] = unitFiller;           // заполняем диагональные элементы переданным заполнителем; меняем массив на char и можно заполнителем сделать 'X'
                } else {
                    array[i][j] = 0;                    // по умолчанию значения типа int в переданном массиве всё равно инициализируются нулём, но во избежание сделаем это ещё раз сами
                }
            }
        }
    }

    // поиск минимального и максимального значений разносим по разным методам
    public static int getMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) min = array[i];
        }
        return min;
    }
    public static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        return max;
    }

    public static boolean checkBalance(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (sumPartOfArray(array, 0, i) == sumPartOfArray(array, i + 1, array.length - 1)) {
                return true;                                    // в случае true по индексам i и i+1 массив разбивается на два равных по сумме значений
            }
        }
        return false;
    }
    public static int sumPartOfArray(int[] array, int startPosition, int endPosition) {
        if (endPosition < startPosition) return 0;              // момент, когда мы сложили весь массив, начиная слева, и справа ничего не осталось - возможно, костыль
        int sum = 0;
        for (int i = startPosition; i <= endPosition; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static void arrayShiftNTimes(int[] array, int n) {   // n раз в цикле выполняем сдвиг массива
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                arrayShiftPositive(array);
            }
        } else if (n < 0) {
            n = -n;                                         // если n отрицательное - делаем его положительным, чтобы использовать в цикле
            for (int i = 1; i <= n; i++) {
                arrayShiftNegative(array);
            }
        }
    }
    public static void arrayShiftPositive(int[] array) {    // цикличный сдвиг массива при положительном n - вправо
        int m = array.length - 1;                           // индекс последнего элемента массива
        int last = array[m];                                // запоминаем значение последнего элемента массива, чтобы потом его восстановить после всех манипуляций
        // System.arraycopy(array, 0, array, 1, array.length - 1);
        // На маленьком кол-ве элементов массива arraycopy не работает быстрее "ручного копирования" в цикле, как указано по ссылке ниже.
        // Когда элементов в массиве становится много, через arraycopy становится заметно быстрее
        // http://developer.alexanderklimov.ru/android/java/array.php#arraycopy
        for (int i = m; i > 0 ; i--) {
            array[i] = array[i - 1];
        }
        array[0] = last;                                    // первому элементу массива после всех манипуляций присваиваем значение последнего элемента
    }
    public static void arrayShiftNegative(int[] array) {    // цикличный сдвиг массива при отрицательном n - влево
        int m = array.length - 1;
        int first = array[0];
        // if (array.length - 1 > 0) System.arraycopy(array, 1, array, 0, array.length - 1);
        for (int i = 0; i < m; i++) {
            array[i] = array[i + 1];
        }
        array[m] = first;
    }

    public static void arraySpiralFilling(int[][] array) {
        int m = array.length, n = array[0].length;
        int limit = m * n;
        int countNumber = 0;
        int i = 0, j = 0;
        int k = -1;
        while (countNumber < limit) {
            while (j < n) {
                countNumber++;
                array[i][j] = countNumber;
                j++;
            }
            if (countNumber == limit) return;
            i++;
            j--;
            while (i < m) {
                countNumber++;
                array[i][j] = countNumber;
                i++;
            }
            if (countNumber == limit) return;
            i--;
            j--;
            while (j > k) {
                countNumber++;
                array[i][j] = countNumber;
                j--;
            }
            if (countNumber == limit) return;
            i--;
            j++;
            k++;
            while (i > k) {
                countNumber++;
                array[i][j] = countNumber;
                i--;
            }
            if (countNumber == limit) return;
            i++;
            j++;
            m--;
            n--;
        }
        /*while (j < n) {
            countNumber++;
            array[i][j] = countNumber;
            j++;
        }
        i++;
        j--;
        while (i < m) {
            countNumber++;
            array[i][j] = countNumber;
            i++;
        }
        i--;
        j--;
        while (j >= k) {
            countNumber++;
            array[i][j] = countNumber;
            j--;
        }
        i--;
        j++;
        while (i > k) {
            countNumber++;
            array[i][j] = countNumber;
            i--;
        }
        i++;
        j++;
        m--;
        n--;
        while (j < n) {
            countNumber++;
            array[i][j] = countNumber;
            j++;
        }
        i++;
        j--;
        while (i < m) {
            countNumber++;
            array[i][j] = countNumber;
            i++;
        }
        i--;
        j--;
        while (j > k) {
            countNumber++;
            array[i][j] = countNumber;
            j--;
        }
        i--;
        j++;
        k++;
        while (i > k) {
            countNumber++;
            array[i][j] = countNumber;
            i--;
        }
        i++;
        j++;
        m--;
        n--;
        while (j < n) {
            countNumber++;
            array[i][j] = countNumber;
            j++;
        }*/
        /*i++;
        j--;
        while (i < m) {
            countNumber++;
            array[i][j] = countNumber;
            i++;
        }
        i--;
        j--;
        while (j > k) {
            countNumber++;
            array[i][j] = countNumber;
            j--;
        }*/
        //      m=5 (array.length), n=7 (array[0].length)
        //      int countNumber = 0;
        //      int i = 0, j = 0;
        // 1.	i равно 0, j увеличивается от 0 до n-1
        //          array[0][0] ... array[0][n-1]
        // 2.	i увеличивается от 1 до m-1, j равно n-1
        //          array[1][n-1] ... array[m-1][n-1]
        // 3.	i равно m-1, j уменьшается от n-2 до 0
        //          array[m-1][n-2] ... array[m-1][0]
        // 4.	i уменьшается от m-2 до 1, j равно 0
        //          array[m-2][0] ... array[1][0]
        // 5.	i равно 1, j увеличивается от 1 до n-2
        //          array[1][1] ... array[1][n-2]
        // 6.	i увеличивается от 2 до m-2, n равно n-2
        //          array[2][n-2] ... array[m-2][n-2]
        // 7.	i равно m-2, j уменьшается от n-3 до 1
        //          array[m-2][n-3] ... array[m-2][1]
        // 8.	i равно m-3, j увеличивается от 1 до n-3
        //          array[m-3][1] ... array[m-3][n-3]


    }

}
