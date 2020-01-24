package lesson2.homework;

import java.util.Arrays;

public class HomeWork {
   
    // Task1. C помощью цикла и условия заменить 0 на 1, 1 на 0
    public static int[] inverse(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 - array[i] ;    // мой вариант
        }
        return array;
    }

    // Task 2. С помощью цикла заполнить массив значениями 0 3 6 9 12 15 18 21;
    public static int[] fillArray(int len) {
        int[] arr = new int[len];
        for (int i = 1; i < len; i++) {
            arr[i] = arr[i] * 3;        // мой вариант
        }
        return arr;
    }

    // Task 3. Пройти по массиву циклом, и числа меньшие 6 умножить на 2
    public static void Task3() {
        int[] ar = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(ar));
        for(int i = 0; i<ar.length; i++) {
            if (ar[i]<6) ar[i]=ar[i]*2;
        }
        System.out.println(Arrays.toString(ar));
    }

     // Task 4. создать квадр.массив и заполнить диагональ единицами
    public static void Task4(int n) {
        int[][] array = new int[n][n];
        for (int i = 0; i<n; i++) {
            array[i][i] = 1;
            array[i][n-i-1] = 1;
            for (int j = 0; j<n; j++) {
                System.out.printf("%d ", array[i][j]);
            }
            System.out.println();
        }
    }

    // Task 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы
    public static void Task5() {
        int[] array = new int[] {1, 2, 3, 6, 7, 8, 4, 9, 1, 5};
        int min=array[1], max=array[1];
        for (int i = 0; i <array.length ; i++) {
            if (array[i]<min) min = array[i];
            if (array[i]>max) max = array[i];
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Min=" +  min + ", Max=" + max);
    }

    // Task 6. сбалансирован ли массив   -> Алгоритм "схождения" левого и правого указателей...
    public static boolean IsBalance(int [] array) {
        int left_ptr = 0, right_ptr = array.length-1;
        int left_sum = array[0], right_sum = array[array.length-1];
        while (left_ptr < right_ptr-1) {
            if (left_sum < right_sum) {
                left_ptr++;
                left_sum += array[left_ptr];
            } else {
                right_ptr--;
                right_sum += array[right_ptr];
            }
        }
        //System.out.println(Arrays.toString(array));
        //System.out.println("L=" + left_ptr + ":" + left_sum + " R=" + right_ptr + ":" + right_sum);
        return (left_sum == right_sum);
    }

    // Task 7. ShiftArray
    public static void ShiftArray(int[] array, int shift) {
        int len = array.length;
        if (shift<0) shift = len - (-shift) % len; else shift = shift % len;
        for (int iters=1; iters<=shift; iters++) {
            int temp = array[len - 1];
            for (int i = len - 1; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = temp;
        }
    }

    public static void main (String[] args){
        System.out.println("Task 1");
        Task1();
        System.out.println("Task 2");
        Task2();
        System.out.println("Task 3");
        Task3();
        System.out.println("Task 4");
        Task4(8);
        System.out.println("Task 5");
        Task5();

        System.out.println("Task 6 ? is balance");
        int[] arr1 = new int[] {1,2,3,4,5,5};
        System.out.println(IsBalance(arr1));
        int[] arr2 = new int[] {1,2,3,4,5,6,7,8};
        System.out.println(IsBalance(arr2));

        System.out.println("Task 7");
        System.out.println(Arrays.toString(arr2));
        ShiftArray(arr2, -2);
        System.out.println(Arrays.toString(arr2));
    }
}
