import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    /* ЗАДАЧА:
Дана строка (возможно, пустая), состоящая из букв A-Z:
AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB
Нужно написать функцию RLE, которая на выходе даст строку вида: A4B3C2XYZD4E3F3A6B28
И сгенерирует ошибку, если на вход пришла невалидная строка.
Пояснения:
Если символ встречается 1 раз, он остается без изменений;
Если символ повторяется более 1 раза, к нему добавляется количество повторений.
*/
    public static void main(String[] args) {
        String s="AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";
//        System.out.println(convert(s));

        convertWithStreams(s);

    }

    public static String convert(String s){
        if (s == null || s.isEmpty()){
            return "";
        }
        char[] chars = s.toCharArray();
        char temp = chars[0];
        int count = 1;
        String result="";

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == temp){
                count++;
            } else {
                result += temp + (count > 1 ? String.valueOf(count) : "");
                temp = chars[i];
                count = 1;
            }
        }
        result += temp + (count > 1 ? String.valueOf(count) : "");
        return result;
    }

    public static String convertWithStreams(String s){
       Map hm= Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(hm.toString());
        return hm.toString();
    }
}
