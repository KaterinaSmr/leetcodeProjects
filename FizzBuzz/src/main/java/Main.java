import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return a string array answer (1-indexed) where:
 *
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 * Example 2:
 *
 * Input: n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 */

public class Main {

    public static void main(String[] args) {

        System.out.println(3 + " : " + fizzBuzz(3));
        System.out.println(3 + " : " + fizzBuzz(5));
        System.out.println(3 + " : " + fizzBuzz(15));


    }
    static List<String> fizzBuzz(int n) {
        List <String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add((i % 15) == 0 ? "FizzBuzz" : (i % 3) == 0 ? "Fizz" : (i % 5) == 0 ? "Buzz" : String.valueOf(i) );
        }
        return result;
    }
}
