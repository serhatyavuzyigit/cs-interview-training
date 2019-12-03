import java.util.*;

// https://www.hackerrank.com/challenges/matrix-rotation-algo/problem?h_r=internal-search

public class MatrixLayerRotation {

    static int[][] general_matrix;
    static int[][] backup_matrix;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int m, n, r;
        m = input.nextInt();
        n = input.nextInt();
        r = Integer.parseInt(input.nextLine().trim());

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            String elements = input.nextLine();
            String[] elements_arr = elements.split(" ");
            for (int j = 0; j < elements_arr.length; j++) {
                matrix[i][j] = Integer.parseInt(elements_arr[j]);
            }
        }

        general_matrix = matrix;
        backup_matrix = new int[m][n];
        copyMatrix(backup_matrix, matrix, m, n);

        int layer = (Math.min(m, n)) / 2;

        for (int times = 0; times < r; times++) {
            for (int i = 0; i < layer; i++) {
                leftMove(i, getRowElementsArray(i, i + 1, n - i), i);
                downMove(i, getColumnElementsArray(i, i, m - i - 1), i);
                rightMove(m - i - 1, getRowElementsArray(m - i - 1, i, n - i - 1), i);
                upMove(n - i - 1, getColumnElementsArray(n - i - 1, i + 1, m - i), i);
            }
            copyMatrix(backup_matrix, general_matrix, m, n);
        }
        printMatrix();

    }

    private static void downMove(int column_number, int[] row_elements, int ind) {
        int index = ind + 1;
        for (int i = 0; i < row_elements.length; i++) {
            general_matrix[index][column_number] = row_elements[i];
            index++;
        }

    }

    private static void upMove(int column_number, int[] row_elements, int ind) {
        int index = ind;
        for (int i = 0; i < row_elements.length; i++) {
            general_matrix[index][column_number] = row_elements[i];
            index++;
        }
    }

    private static void rightMove(int row_number, int[] column_elements, int ind) {
        int index = 1 + ind;
        for (int i = 0; i < column_elements.length; i++) {
            general_matrix[row_number][index] = column_elements[i];
            index++;
        }

    }

    private static void leftMove(int row_number, int[] column_elements, int ind) {
        int index = ind;
        for (int i = 0; i < column_elements.length; i++) {
            general_matrix[row_number][index] = column_elements[i];
            index++;
        }
    }

    private static int[] getColumnElementsArray(int column_number, int start, int end) {
        int size = end - start;
        int[] arr = new int[size];
        int index = 0;
        for (int i = start; i < end; i++) {
            arr[index] = backup_matrix[i][column_number];
            index++;
        }
        return arr;
    }

    private static int[] getRowElementsArray(int row_number, int start, int end) {
        int size = end - start;
        int[] arr = new int[size];
        int index = 0;
        for (int i = start; i < end; i++) {
            arr[index] = backup_matrix[row_number][i];
            index++;
        }
        return arr;

    }

    private static void printMatrix() {
        for (int i = 0; i < general_matrix.length; i++) {
            for (int j = 0; j < general_matrix[i].length; j++) {
                System.out.print(general_matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void copyMatrix(int[][] backup_matrix, int[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backup_matrix[i][j] = matrix[i][j];
            }
        }
    }
}
