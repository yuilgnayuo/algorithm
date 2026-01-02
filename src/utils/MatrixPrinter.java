package utils;

import java.util.Arrays;
import java.util.Map;

/**
 * 矩阵打印工具类
 * 支持任意类型的二维数组，自动对齐列宽，格式美观
 */
public class MatrixPrinter {

    /**
     * 打印矩阵（核心方法）
     * @param matrix 待打印的二维数组（矩阵）
     * @param <T> 矩阵元素类型（int、String、Double等）
     */
    public static <T> void printMatrix(T[][] matrix) {
        // 1. 处理空矩阵
        if (matrix == null || matrix.length == 0) {
            System.out.println("矩阵为空！");
            return;
        }

        // 2. 计算每列的最大宽度（保证列对齐）
        int[] columnMaxWidths = calculateColumnMaxWidths(matrix);

        // 3. 打印矩阵
        System.out.println("===== 矩阵开始 =====");
        for (T[] row : matrix) {
            // 处理行空的情况
            if (row == null) {
                System.out.println("| " + "空行" + " |");
                continue;
            }

            // 拼接当前行的每个元素（按列宽对齐）
            StringBuilder rowStr = new StringBuilder("| ");
            for (int col = 0; col < row.length; col++) {
                T element = row[col];
                String elementStr = element == null ? "null" : element.toString();
                // 格式化：左对齐，填充空格至列最大宽度
                rowStr.append(String.format("%-" + columnMaxWidths[col] + "s", elementStr))
                      .append(" | ");
            }
            // 移除最后多余的" | "，保持格式整洁
            if (rowStr.length() > 2) {
                rowStr.delete(rowStr.length() - 3, rowStr.length());
            }
            rowStr.append("|");
            System.out.println(rowStr);
        }
        System.out.println("===== 矩阵结束 =====\n");
    }

    public static void printXYIntMapMatrix(Map<String, Integer>[][] xyMapMatrix) {
        // 1. 处理空矩阵边界情况
        if (xyMapMatrix == null || xyMapMatrix.length == 0) {
            System.out.println("【XY整数Map矩阵】矩阵为空！");
            return;
        }

        // 2. 计算每列的最大宽度（保证矩阵列对齐，适配(1,2)格式）
        int[] columnMaxWidths = calculateColumnMaxWidths(xyMapMatrix);

        // 3. 格式化打印矩阵（带边框，格式整洁）
        System.out.println("===== XY整数Map二维矩阵开始 =====");
        for (Map<String, Integer>[] row : xyMapMatrix) {
            // 处理null行
            if (row == null) {
                System.out.println("| 空行 |");
                continue;
            }

            // 拼接当前行的每个Map元素
            StringBuilder rowStr = new StringBuilder("| ");
            for (int col = 0; col < row.length; col++) {
                Map<String, Integer> currentXYMap = row[col];
                // 格式化单个XY Map为标准(1,2)格式字符串
                String xyMapStr = formatXYIntMapToString(currentXYMap);
                // 左对齐填充空格，保证列宽一致，格式整齐
                rowStr.append(String.format("%-" + columnMaxWidths[col] + "s", xyMapStr))
                        .append(" | ");
            }

            // 移除末尾多余的" | "，优化格式整洁度
            if (rowStr.length() > 2) {
                rowStr.delete(rowStr.length() - 3, rowStr.length());
            }
            rowStr.append("|");
            System.out.println(rowStr);
        }
        System.out.println("===== XY整数Map二维矩阵结束 =====\n");
    }


    /**
     * 辅助方法：格式化单个XY Map为标准字符串{x=?, y=?}
     * 针对性处理null Map、缺失"x"/"y"键、值为null的场景
     * @param xyMap 待格式化的Map（键"x"/"y"，值Integer）
     * @return 标准化的XY字符串
     */
    private static String formatXYIntMapToString(Map<String, Integer> xyMap) {
        // 场景1：Map为null
        if (xyMap == null) {
            return "{x=null, y=null}";
        }

        // 场景2：提取"x"/"y"键对应的值（固定键名，针对性适配）
        Integer xValue = xyMap.get("x");
        Integer yValue = xyMap.get("y");

        // 处理值为null或缺失键的情况
        String xStr = (xValue != null) ? xValue.toString() : (xyMap.containsKey("x") ? "null" : "缺失x");
        String yStr = (yValue != null) ? yValue.toString() : (xyMap.containsKey("y") ? "null" : "缺失y");

        // 标准化返回格式，保证统一可读性
        return String.format("(%s,%s)", xStr, yStr);
    }


    /**
     * 辅助方法：计算每列的最大宽度（用于对齐）
     * @param matrix 二维数组
     * @param <T> 元素类型
     * @return 每列的最大宽度数组
     */
    private static <T> int[] calculateColumnMaxWidths(T[][] matrix) {
        // 先获取最大列数（处理行长度不一致的情况）
        int maxColumnCount = 0;
        for (T[] row : matrix) {
            if (row != null && row.length > maxColumnCount) {
                maxColumnCount = row.length;
            }
        }

        // 初始化列宽数组（默认宽度为4，适配"null"）
        int[] columnMaxWidths = new int[maxColumnCount];
        Arrays.fill(columnMaxWidths, 4);

        // 遍历每个元素，更新列宽
        for (T[] row : matrix) {
            if (row == null) continue;
            for (int col = 0; col < row.length; col++) {
                T element = row[col];
                int elementLength = element == null ? 4 : element.toString().length();
                if (elementLength > columnMaxWidths[col]) {
                    columnMaxWidths[col] = elementLength;
                }
            }
        }
        return columnMaxWidths;
    }

    // ========== 重载方法：支持基本类型int[][]（避免自动装箱的麻烦） ==========
    public static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("矩阵为空！");
            return;
        }
        // 转换为Integer[][]（泛型不支持基本类型）
        Integer[][] integerMatrix = new Integer[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            if (row == null) {
                integerMatrix[i] = null;
                continue;
            }
            integerMatrix[i] = new Integer[row.length];
            for (int j = 0; j < row.length; j++) {
                integerMatrix[i][j] = row[j];
            }
        }
        printMatrix(integerMatrix);
    }

    // ========== 测试示例 ==========
    public static void main(String[] args) {
        // 测试1：int类型矩阵（3x3）
        int[][] intMatrix = {
                {1, 12, 123},
                {456, 7890, 5},
                {67, 8, 90123}
        };
        System.out.println("【测试1：int类型矩阵】");
        printMatrix(intMatrix);

        // 测试2：String类型矩阵（行长度不一致）
        String[][] strMatrix = {
                {"Java", "Python", "C++"},
                {"SpringBoot", "Redis", null},
                {"MySQL"}
        };
        System.out.println("【测试2：String类型矩阵（行长度不一致）】");
        printMatrix(strMatrix);

        // 测试3：空矩阵
        int[][] emptyMatrix = new int[0][0];
        System.out.println("【测试3：空矩阵】");
        printMatrix(emptyMatrix);
    }
}