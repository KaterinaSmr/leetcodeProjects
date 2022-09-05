import java.util.Arrays;


public class Main1 {
    public static void main(String[] args) {
        int[][][] testArrays = Main.init();
        System.out.println(Arrays.toString(kWeakestRows(testArrays[0], 3)));
        System.out.println(Arrays.toString(kWeakestRows(testArrays[1], 2)));
        System.out.println(Arrays.toString(kWeakestRows(testArrays[2], 4)));
        System.out.println(Arrays.toString(kWeakestRows(testArrays[3], 1)));
        System.out.println(Arrays.toString(kWeakestRows(testArrays[4], 2)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int sums[] = new int[m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sums[i] += mat[i][j];
            }
        }

        System.out.println("sums: " + Arrays.toString(sums));
        int result[] = new int[k];
        int counter = 0;
        for (int i = 0; i <= n && counter < k; i++) {
            for (int j = 0; j < m && counter < k; j++) {
                if (sums[j] == i){
                    result[counter] = j;
                    System.out.println("i=" + i + ", j=" + j + ", sums[j]=" + sums[j] + ", counter=" + counter
                                    + ", result[counter]" + j);
                    counter++;
                }
            }
        }
        return result;
    }

}
