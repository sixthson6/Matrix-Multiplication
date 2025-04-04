import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input Matrix A
        System.out.print("Matrix A: ");
        String[] dimensionsA = scanner.nextLine().split(",");
        int rowsA = Integer.parseInt(dimensionsA[0].trim());
        int colsA = Integer.parseInt(dimensionsA[1].trim());

        int[][] matrixA = new int[rowsA][colsA];
        System.out.println("Enter elements of Matrix A:");
        for (int i = 0; i < rowsA; i++) {
            String[] row = scanner.nextLine().trim().split("\\s+");
            for (int j = 0; j < colsA; j++) {
                matrixA[i][j] = Integer.parseInt(row[j]);
            }
        }

        // Input Matrix B
        System.out.print("Matrix B: ");
        String[] dimensionsB = scanner.nextLine().split(",");
        int rowsB = Integer.parseInt(dimensionsB[0].trim());
        int colsB = Integer.parseInt(dimensionsB[1].trim());

        // Check if multiplication is possible
        if (colsA != rowsB) {
            System.out.println("Matrix multiplication not possible. Number of columns in A must equal number of rows in B.");
            return;
        }

        int[][] matrixB = new int[rowsB][colsB];
        System.out.println("Enter elements of Matrix B:");
        for (int i = 0; i < rowsB; i++) {
            String[] row = scanner.nextLine().trim().split("\\s+");
            for (int j = 0; j < colsB; j++) {
                matrixB[i][j] = Integer.parseInt(row[j]);
            }
        }

        // Perform matrix multiplication
        int[][] matrixC = multiplyMatrices(matrixA, matrixB);

        // Display the result
        System.out.println("\nMatrix C:\n");
        printMatrix(matrixC);
    }

    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("| ");
            for (int num : row) {
                System.out.print(num + "  ");
            }
            System.out.println("|");
        }
    }
}