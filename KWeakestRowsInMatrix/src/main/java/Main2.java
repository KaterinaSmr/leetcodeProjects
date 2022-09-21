
//реализация с формулой
//реализация с массивом посещенных строк

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int[][][] testArrays = Main.init();
        System.out.println(Arrays.toString(kWeakestRows(testArrays[0], 3)));
        System.out.println(Arrays.toString(kWeakestRows(testArrays[1], 2)));
        System.out.println(Arrays.toString(kWeakestRows(testArrays[2], 4)));
        System.out.println(Arrays.toString(kWeakestRows(testArrays[3], 1)));
        System.out.println(Arrays.toString(kWeakestRows(testArrays[4], 2)));
        System.out.println(Arrays.toString(kWeakestRows(testArrays[5], 1)));
    }

    private static int[] kWeakestRows(int[][] mat, int k) {
        //with formula, and stream and Arrays.sort
        int m = mat.length;
        System.out.println("m = " + m);

        int n = mat[0].length;
        System.out.println("n = " + n);

        int[] array = new int[m];
        Arrays.fill(array, -1);
        for (int i = 0; i < m; i++) {
            System.out.println("i = " + i);
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0){
                    System.out.println("j = " + j);
                    array[i] = j * m + i;
                    System.out.println("array [" + i + "] = " + array[i]);
                    break;
                }
            }
            if (array[i] == -1)
                array[i] = n * m + i;
        }

        Arrays.sort(array);
        int [] result = Arrays.copyOf(Arrays.stream(array).map(i -> i % m).toArray(), k);

        return result;
    }
}
