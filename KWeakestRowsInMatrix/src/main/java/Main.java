import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][][] testArrays = init();
        System.out.println(Arrays.toString(kWeakestRows(testArrays[0], 3)));
        System.out.println(Arrays.toString(kWeakestRows(testArrays[1], 2)));
        System.out.println(Arrays.toString(kWeakestRows(testArrays[2], 4)));
        System.out.println(Arrays.toString(kWeakestRows(testArrays[3], 1)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int counter=0;
        int [] dummy = new int[n];
        Arrays.fill(dummy, 1);
        int [] result = new int[k];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (mat[i][j] != 1){
                    result[counter] = i;
                    counter++;
                    if (counter >= k)
                        return result;
                    mat[i] = dummy;
                }
            }
        }
        return new int[]{0};
    }

    public static int[][][] init(){
        int[][] mat1 = new int[][]{
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}};
        int[][] mat2 = new int[][]{
                {1,0,0,0},
                {1,1,1,1},
                {1,0,0,0},
                {1,0,0,0}};
        int[][] mat3 = new int[][]{
                {1,0},
                {1,0},
                {1,0},
                {1,1}};
        int[][] mat4 = new int[][]{
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
        };
        int[][] mat5 = new int[][]{
                {1,0},
                {0,0},
                {1,0}
        };
        return new int[][][]{mat1, mat2, mat3, mat4,mat5};
    }
}
