package ru.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
1) Дан метод random2, которая с равной вероятностью возвращает 0 и 1. С ее помощью нужно было написать метод random4,
который, в свою очередь, возвращает с равной вероятностью числа 0, 1, 2, 3.
2) Даны 2 строки. Нужно определить, являются ли они анаграммами. Если не являются, то вычислить разницу строк в символах.
4) Реализовать итератор для набора четных. Тут нужно было продумать поля итератора и переопределить методы next()
и hasNext(). На 5 баллов нужно было придумать, как сделать, чтобы итератор не хранил массив чисел.
На втором этапе было 2 задачи.
1) Есть кинотеатр с одним рядом кресел. Сам ряд представлен массивом нулей и единиц, где 0 – свободное место,
а 1 – занятое. Нужно реализовать метод, который находит максимально удаленное свободное место от занятых мест.

 */
public class Main {
    public static void main(String[] args) {
//        for (int i = 0; i < 20; i++) {
//            random4();
//        }
//        checkForAnagram("AABCD","DACBZ");
        farestSeat(new int[]{1,0,0,1,0,0,1,0,0,0,0,0,1,0,0});

    }
    static Random random = new Random();

    static int random4(){
        int r1 = random2();
        int r2 = random2();
        int result = 2*r1 + r2;
        System.out.println("r1=" + r1 + " | r2=" + r2 + " | result=" + result);
        return  result;
    }

    static int random2(){
        return random.nextInt(2);
    }

    static void checkForAnagram(String s1, String s2){
        String[] arr1 = s1.split("");
        String[] arr2 = s2.split("");

        Map<String, Long> map1=Arrays.stream(s1.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map1);
        Map<String, Long> map2=Arrays.stream(s2.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map2);

        Set<String> allStrings = new HashSet<>(map1.keySet());
        allStrings.addAll(map2.keySet());
        System.out.println("All strings: " + allStrings);
        for (String s:allStrings) {
            Long m1 = map1.get(s);
            Long m2 = map2.get(s);
            if (m1 == null || m2 == null || (m1 - m2 != 0)){
                System.out.println(s + " : " + m1 + " ; " + m2);
            }
        }
    }

    public static void farestSeat(int arr[]){
        int max = 0;
        int pos = 0;
        int count=0;
        boolean start = arr[0] == 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0){
                count++;
            } else if (count > 0) {
                if (start && count > max){
                    max = count;
                    pos = 0;
                }
                if (count/2 > max){
                    max = count/2;
                    pos = i - count/2 -1;
                }
                count = 0;
                start = false;
            }
        }
        if (count > 0 && count > max){
            max = count;
            pos = arr.length-1;
        }
        System.out.println("max = " + max);
        System.out.println("pos = " + pos);
    }

}