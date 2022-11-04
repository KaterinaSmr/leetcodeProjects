import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 */
public class Main {
    public static void main(String[] args) {
        String romanNum = "MCMXCIV";
        String romanNum1 = "XXVI";
        System.out.println(romanNum + " = " + romanToIntegerWithStringMap(romanNum));
    }

    public static int romanToIntegerWithStringMap(String romanNumber){
        HashMap<String, Integer> mapTable1 = new HashMap<>();
        mapTable1.put("IV", 4);
        mapTable1.put("IX", 9);
        mapTable1.put("XL", 40);
        mapTable1.put("XC",90);
        mapTable1.put("CD", 400);
        mapTable1.put("CM",900);
        HashMap <Character, Integer> mapTable = new HashMap<>();
        mapTable.put('M', 1000);
        mapTable.put('D', 500);
        mapTable.put('C', 100);
        mapTable.put('L', 50);
        mapTable.put('X',10);
        mapTable.put('V',5);
        mapTable.put('I',1);

        String temp = romanNumber;
        int result=0;
        for (Map.Entry<String, Integer> e : mapTable1.entrySet()) {
            if (temp.contains(e.getKey())){
                temp = temp.replace(e.getKey(), "");
                result += e.getValue();
            }
        }
        System.out.println(temp);
        result += temp.chars().mapToObj(i -> (char)(i)).map(c -> mapTable.get(Character.valueOf(c)))
                .mapToInt(i -> i!=null ? i.intValue():0).sum();
        return result;
    }

    public static int romanToIntegerWithStream(String romanNumber){
        HashMap <Character, Integer> mapTable = new HashMap<>();
        mapTable.put('M', 1000);
        mapTable.put('D', 500);
        mapTable.put('C', 100);
        mapTable.put('L', 50);
        mapTable.put('X',10);
        mapTable.put('V',5);
        mapTable.put('I',1);
        mapTable.put('J',-1);
        mapTable.put('Y',-10);
        mapTable.put('S',-100);

        String temp = romanNumber.replace("IX", "JX").replace("IV", "JV")
                .replace("XL", "YL").replace("XC", "YC")
                .replace("CD", "SD").replace("CM", "SM");

        System.out.println(temp);
        return temp.chars().mapToObj(i -> (char)(i)).map(c -> mapTable.get(Character.valueOf(c)))
                .mapToInt(Integer::intValue).sum();
    }
    public static int romanToIntegerDirectly(String romanNumber) {
        char[] chars = (romanNumber + 0).toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            switch (c) {
                case 'M':
                    result += 1000;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'C':
                    if (chars[i + 1] == 'D' || chars[i + 1] == 'M')
                        result -= 100;
                    else
                        result += 100;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'X':
                    if (chars[i + 1] == 'L' || chars[i + 1] == 'C')
                        result -= 10;
                    else
                        result += 10;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'I':
                    if (chars[i + 1] == 'V' || chars[i + 1] == 'X')
                        result -= 1;
                    else
                        result += 1;
                    break;
            }
        }
        return result;
    }
}
