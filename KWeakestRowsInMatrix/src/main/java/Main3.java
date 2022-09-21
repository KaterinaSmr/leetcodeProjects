import java.util.Arrays;

public class Main3 {
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
        int y = mat.length, x = mat[0].length, kix = 0;
        int[] vis = new int[y], ans = new int[k];
        for (int j = 0; j <= x; j++)
            for (int i = 0; i < y; i++) {
                if (vis[i] == 0 && (j == x || mat[i][j] == 0)) {
                    ans[kix++] = i;
                    vis[i]++;
                }
                if (kix == k) return ans;
            }
        return ans;
    }
}
