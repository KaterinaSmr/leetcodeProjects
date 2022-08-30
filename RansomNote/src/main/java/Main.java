import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed
 * by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 */

public class Main {
    public static void main(String[] args) {
        String rNote = "sdfzewr";
        String magazine = "ssdfejwgppppkgdmelwjeserewhb";
        System.out.println("Can construct? " + check(rNote, magazine));

    }
    // сделать через стрим
     static boolean check(String ransomNote, String magazine){
        Map <Character, Integer> rnMap= stringToMap(ransomNote);
        Map <Character, Integer> magMap =stringToMap (magazine);

         System.out.println(rnMap);

         Integer quantitiyInMag;
         char c;
         int v;
         for (Map.Entry<Character, Integer> e: rnMap.entrySet()){
             c = e.getKey();
             v = e.getValue();
             quantitiyInMag = magMap.get(c);
             System.out.println(c + " - " + v + " - " + quantitiyInMag);
             if (quantitiyInMag == null || quantitiyInMag < v) {
                 return false;
             }
         }
        return true;
    }

    static Map<Character, Integer> stringToMap(String s){
        Map <Character, Integer> map = new HashMap<>();
        for (char c:s.toCharArray()) {
            map.compute(c, (k, v)-> (v == null)? 1 : v+1);
        }
        return map;
    }
}
