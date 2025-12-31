package algo.hot100;

import utils.MatrixPrinter;

import java.util.HashMap;
import java.util.Map;

public class P85_Max {

    public static void main(String[] args) {
//        char[][] matrix = {
//                {'1', '1', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'0', '0', '1', '1', '1'}};

        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        System.out.println(new P85_Max().maximalRectangle(matrix));
    }

    //  1*2，1*3
    //  2*2，2*3
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int N = matrix.length;
        int M = matrix[0].length;

        int ans = 0;
        Map<String, Integer>[][] dp = new Map[N][M];
        dp[0][0] = getNew(matrix[0][0] - '0', matrix[0][0] - '0');
        // first column
        for (int i = 1; i < N; i++) {
            if (matrix[i][0] == '1') {
                int x = dp[i - 1][0].get("x") + 1;
                int y = dp[i - 1][0].get("y");
                ans = Math.max(ans, x * y);
                dp[i][0] = getNew(x, 1);
            } else {
                dp[i][0] = getNew(0, 0);
            }
        }
        for (int i = 1; i < M; i++) {
            if (matrix[0][i] == '1') {
                int x = dp[0][i - 1].get("x");
                int y = dp[0][i - 1].get("y") + 1;
                ans = Math.max(ans, x * y);
                dp[0][i] = getNew(1, y);
            } else {
                dp[0][i] = getNew(0, 0);
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (matrix[i][j] == '1') {
                    var left = dp[i - 1][j];
                    var up = dp[i][j - 1];
                    var leftUp = dp[i - 1][j - 1];
                    int x = Math.min(Math.min(leftUp.get("x"), up.get("x")), left.get("x")) + 1;
                    int y = Math.min(Math.min(leftUp.get("y"), up.get("y")), left.get("y")) + 1;
                    ans = Math.max(ans, x * y);
                    dp[i][j] = getNew(x, y);
                } else {
                    dp[i][j] = getNew(0, 0);
                }
            }
        }
        MatrixPrinter.printXYIntMapMatrix(dp);
        return ans;
    }

    private Map<String, Integer> getNew(int x, int y) {
        Map map = new HashMap<>();
        map.put("x", x);
        map.put("y", y);
        return map;
    }

    private int getXMin(Map<String, Integer> left, Map<String, Integer> up,
                        Map<String, Integer> leftUp) {
        return Math.min(Math.min(leftUp.get("x"), up.get("x")), left.get("x"));
    }

    private int getYMin(Map<String, Integer> left, Map<String, Integer> up,
                        Map<String, Integer> leftUp) {
        return Math.min(Math.min(leftUp.get("y"), up.get("y")), left.get("y"));
    }
}
