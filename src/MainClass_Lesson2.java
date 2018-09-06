public class MainClass_Lesson2 {
    public static void main(String[] args) {
        /* ДЗ ко второму уроку по Java на GeekBrains */

        /* 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        С помощью цикла и условия заменить 0 на 1, 1 на 0. */
        int[] arrInt = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        invertArray(arrInt);                        // т.к. массив передаётся по ссылке, то после работы внутренней метода изменяются значения переданного массива, хоть метод ничего и не возвращает
        printArray(arrInt);

        //=====================================================================================================================================================

        /* 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21. */
        int m2 = 8;
        int[] arrayInt = new int[m2];
        fillArrayMultipleOfThree(arrayInt);
        printArray(arrayInt);

        //=====================================================================================================================================================

        /* 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2. */
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        ifLesserSixMultipleTwo(array);
        printArray(array);

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
        int[] array1Dimension = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8};
        System.out.println("min = " + getMin(array1Dimension) + ", max = " + getMax(array1Dimension));

        //=====================================================================================================================================================

        /* 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
        Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 10]) → true,
        граница показана символами ||, эти символы в массив не входят. */
        //int m6 = 6;
        //int[] arr6 = new int[m6];
        int[] arr6_1 = {1, 1, 1, 2, 1};
        int[] arr6_2 = {2, 1, 1, 2, 1};
        int[] arr6_3 = {10, 10};
        System.out.println(checkBalance(arr6_1));
        System.out.println(checkBalance(arr6_2));
        System.out.println(checkBalance(arr6_3));

        //=====================================================================================================================================================

        /* 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
        при этом метод должен сместить все элементы массива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами. */
        int m7 = 6;
        int[] arr7 = new int[m7];
        arrayShift(arr7);
        //System.out.println(0 % 4);

        //=====================================================================================================================================================

        /* 8. ***** Создать матрицу размерностью m*n и заполнить её по спирали числами от 1 до (m*n) с шагом 1, начиная с крайнего верхнего левого положения (0, 0)*/
        int m8 = 5;
        int n8 = 7;
        int[][] array8 = new int[m8][n8];
        arraySpiralFilling(array8);


        //=====================================================================================================================================================

    }

    public static void printArray (int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void printTwoDimensionalArray (int[][] array) {
        int m = array.length, n = array[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
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

    public static void arrayShift(int[] array) {

    }

    public static void arraySpiralFilling(int[][] array) {

    }

}
