public class Main {

    public static void main(String[] args) {
        String test1 = "BZA"; //4
        String test2 = "AZGB"; //13
        String test3 = "ZNMD"; //23

        System.out.println(test1 + " - " + getTime(test1));
        System.out.println(test2 + " - " + getTime(test2));
        System.out.println(test3 + " - " + getTime(test3));
    }
    private static int getTime(String s){
//        s = s.toUpperCase();
        char[] chars = s.toCharArray();
        int totalTime = 0;
        char current = 'A';
        char next;
        for (int i = 0; i < chars.length; i++) {
            next = chars[i];
            totalTime += getTime(current, next);
            current = chars[i];
        }
        return totalTime;
    }
    private static int getTime(char current, char next){
        int stepsDirect = Math.abs(next - current);
        int stepsReverse = 26 - stepsDirect;
        return Math.min(stepsDirect, stepsReverse);
    }
}


