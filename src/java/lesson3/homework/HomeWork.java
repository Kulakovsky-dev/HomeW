package lesson3.homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork {

    /* example:
     * input: Mama mila ramu, Ramu mila mama!!!, [mama, ramu]
     * output: 4
     * use regex, split, lowerCase, replace methods
     * */
    public int countOfWordsFromDictionaryInString(String input, String[] dictionary) {
        //посчитать все слова из словаря в input
        //если одно слово встречается 5 раз его нужно посчитать 5 раз
        input = input.toLowerCase();
        input = input.replaceAll("," , "");
        String[] inArray = input.split(" ");
        int count = 0;
        for(int i=0; i<dictionary.length; i++) {
            for(int j=0; j<inArray.length; j++) {
                if (dictionary[i].equals(inArray[j])) count++;
            }
        }
        return count;
    }

    /* example:
     * input: [1,0,3,17,2,7,14,1,1,7], K = 6
     * output: 3
     * use sort
     * */
    public int kOrderValue(int[] array, int k) {
        //метод должен вернуть К по порядку элемент массива
        boolean changed=false;
        int tmp;
        while (true) {
            // System.out.println(Arrays.toString(array));
            changed = false;
            for(int i=0; i<array.length-1; i++) {
                if (array[i]>array[i+1]) {
                   tmp = array[i];
                   array[i] = array[i+1];
                   array[i+1] = tmp;
                   changed = true;
                }
            }
            if (changed==false) break;
        }
        // System.out.println(Arrays.toString(array));
        return array[k-1];
    }

    /*
    *  Это реальная задача, которую я сегодня делал на работе
    *  Кому интересно, можете проверить свои силы))))
    *  Если слово из values есть в словаре from, его необходимо заменить
    *  с from[i] на to[i] [a, b, c], [a, b], [x, y] -> [x, y, c]
    *  Если словарь to длиннее from, то строка to[from.length] - дефолтное
    *  значение для всех values, которых нет в словаре from
    *  [a, b, c, d], [a, b], [x, y, lol] -> [x, y, lol, lol]
    *  Если словарь from длиннее to, то необходимо удалить из values все значения
    *  имющиеся в куске from на индексах от to.length до rom.length
    *  [a, b, c, d], [a, b, e, d], [x, y] -> [x, y, c] d удалем, так как он есть во
    *  from
     */
    public String[] translate(String[] values, String[] from, String[] to) {
        boolean changed, todelete;
        for(int i=0; i<values.length; i++) {
            changed = false;
            todelete = false;
            for(int j=0; j<from.length; j++) {
                if (values[i].equals(from[j])) {
                    if(j<to.length) {
                        values[i] = to[j];
                        changed = true;
                    } else { todelete = true;
                    }
                    break;
                }
            }
            if(changed==false && to.length>from.length) values[i]=to[from.length];
            if(todelete) values[i]="DEL"; // пока не реализовал "усечение" массива - заполнил DEL
        }
        return(values);
    }

    /* example:
     * input: m.levin.main@mailg.spb.com
     * output: true
     *
     * use matches
     * */
    public boolean isEmail(String input) {
        // --- сначала проверим @ на наличие единственного, причем не в начале и не в конце
        int i=input.indexOf("@"), j=input.lastIndexOf("@");
        if (i<=0 || (j>=0 && j!=i) || (i==input.length()-1)) return false;
        // --- проверим точки, не в начале, не в конце, не подряд, не рядом с @
        if (input.indexOf(".")==0 || input.lastIndexOf(".")==input.length()-1) return false;
        if (input.indexOf("..")>=0) return false;
        if (input.lastIndexOf(".@")>=0 || input.lastIndexOf("@.")>=0) return false;
        // --- проверим первая - буква
        char ch = input.charAt(0);
        boolean valid = false;
        if (ch>='a' && ch<='z') valid=true;
        if (ch>='A' && ch<='Z') valid=true;
        if (valid==false) return false;
        // --- проверим, что в строке только буквы,цифры, либо точка, либо @
        String str= input.replaceAll("@","");
        str = str.replaceAll("\\.","");
        str = str.replaceAll("[a-zA-Z0-9]","");  // \w
        if (str.equals("")) return true;
        return false;
    }

    public void binarySearchGame() {
        int secretValue = new Random().nextInt(100); // компьютер загадывает число
        // TODO: 20.01.2020
        //мы печатаем в консоль наши предположения (в цикле), компютер отвечает > , < или =
        //на каждый наш вопрос
        //если задано более 7 вопросов и не угадано значение, мы проиграли
        //если компютер вывел =, мы выиграли
        Scanner in = new Scanner(System.in);
        System.out.println("Угадайте число {1..100]");
        for (int i=7; i>0; i--) {
            int answer = in.nextInt();
            if (answer==secretValue) {
                System.out.println("Вы угадали !");
                return;
            }
            if (answer<secretValue) {
                System.out.println("Загаданное число больше, осталось " + (i-1) + " попыток");
            } else {
                System.out.println("Загаданное число меньше, осталось " + (i-1) + " попыток");
            }
        }
        System.out.println("Вы проиграли !");
        return;
    }

    public void wordsGame() {
        // TODO: 20.01.2020  
    }
}
